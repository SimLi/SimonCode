from rest_framework import serializers
from mainsite.models import Post


class PostSerializer(serializers.ModelSerializer):
    class Meta:
        model = Post
        fields=('title', 'slug', 'body', 'pub_date')