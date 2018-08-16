from django.core import serializers
from django.http import JsonResponse
from django.shortcuts import render
from rest_framework.parsers import JSONParser

from simon_blog.actionresult import actionresult
from rest_framework import viewsets
from rest_framework.response import Response
from rest_framework.decorators import api_view
from simon_blog.serializers import BooksSerializer,SnippetSerializer
# Create your views here.
from django.views.decorators.http import require_http_methods

from simon_blog.models import books,Snippet
import json


class BooksViewSet(viewsets.ModelViewSet):
    queryset = books.objects.all()
    serializer_class = BooksSerializer




# 新增一份书籍
@require_http_methods(['GET'])
def add_books(request):
    response = actionresult()
    try:
        book = books(book_name=request.GET.get('book_name'))
        book.save()
        response.err_num = 0
        response.data = ''
    except Exception as e:
        response.msg = str(e)
        response.err_num = 1
    return JsonResponse(response)

@require_http_methods(['GET'])
def show_books(request):
    try:
        book_list = books.objects.all()
        serializer = BooksSerializer(book_list,many=True)
        return JsonResponse(serializer.data, safe=False)
    except Exception as e :
        return JsonResponse(actionresult(msg=str(e),err_num=1))

@api_view(['GET','POST','PUT'])
def book_detail(request,pk):
    book = books.objects.get(pk=pk)
    serializer = BooksSerializer(book)
    return Response(serializer.data)

def snippet_list(request):
    """List all code snippets, or create a new snippet."""
    if request.method == 'GET':
        snippet = Snippet.objects.all()
        serializer = SnippetSerializer(snippet,many=True)
        return JsonResponse(serializer.data,safe=False)
    elif request.method == 'POST':
        data = JSONParser().parse(request)
        serializer = SnippetSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data,status=201)
        return JsonResponse(serializer.data,status=400)