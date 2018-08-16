from django.db import models

# Create your models here.
from django.utils import timezone


class Post(models.Model):
    title = models.CharField(max_length=100)
    slug = models.CharField(max_length=200)
    body = models.TextField()
    pub_date = models.DateTimeField(default=timezone.now)

    class Meta:
        ordering = ('-pub_date',)
        db_table = "post"

    def __unicode__(self):
        return self.title

    def __str__(self):
        return self.title


class User(models.Model):
    """用户表"""
    username = models.CharField(max_length=20)
    password = models.CharField(max_length=256)
    email = models.EmailField()
    home_url = models.URLField()
    screen_name = models.CharField(max_length=100)
    create = models.DateTimeField(auto_created=True)
    activated = models.IntegerField()
    logged = models.IntegerField()
    group_name = models.CharField(max_length=20)

    class Meta:
        db_table = "t_user"


class Contents(models.Model):
    """文章表"""
    title=models.CharField(max_length=200)
    slug=models.CharField(max_length=200)
    created=models.DateTimeField(auto_now_add=True)
    modified=models.IntegerField()
    content=models.TextField()
    author_id=models.IntegerField()
    type=models.CharField(max_length=16)
    status=models.CharField(max_length=16)
    tags=models.CharField(max_length=200)
    categories=models.CharField(max_length=200)
    hits=models.IntegerField()
    comments_num=models.IntegerField()
    allow_comment=models.CharField(max_length=2)

    class Meta:
        db_table = "t_contents"
        ordering = ["-created"]
