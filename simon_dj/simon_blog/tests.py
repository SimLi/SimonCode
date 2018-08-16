from django.test import TestCase

# Create your tests here.
from simon_blog.models import Snippet

snippet = Snippet(code='foo = "bar"\n')
snippet.save()

snippet = Snippet(code='print " Hello World ! "\n')
snippet.save()

