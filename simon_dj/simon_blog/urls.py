from django.conf.urls import url,include
from rest_framework import routers
from simon_blog import views

router = routers.DefaultRouter()
router.register(r'books',views.BooksViewSet)
urlpatterns = [
#url(r'^',include(router.urls)),
url(r'add_books$', views.add_books, ),
url(r'show_books$', views.show_books, ),
url(r'book_detail/(?P<pk>[0-9]+)$', views.book_detail,),
]