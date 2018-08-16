from rest_framework import serializers
from simon_blog.models import books, Snippet

class BooksSerializer(serializers.ModelSerializer):
    class Meta:
        model = books
        fields=('book_name','add_time')

class SnippetSerializer(serializers.ModelSerializer):
    class Meta:
        model = Snippet
        fields=('id','created','title','code','linenos')