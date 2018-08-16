from django.shortcuts import render
from django.http.response import HttpResponse, JsonResponse
from .models import Post
from .serializers import PostSerializer

# Create your views here.


def homepage(request):
    posts = Post.objects.all()
    post_list = list()
    for count, post in enumerate(posts):
        post_list.append("NO.{}".format(str(count) + str(post))+"<br>")
        post_list.append("<small>"+str(post.body)+"</small><br><br>")
    return HttpResponse(post_list)


def post_list(request):
    post = Post.objects.all()
    serialize_post = PostSerializer(post, many=True)
    return JsonResponse(serialize_post.data,safe=False)
