from django.contrib import admin
from polls.models import  News


@admin.register(News)
class NewsAdmin(admin.ModelAdmin):
    list_display = ('id', 'pagefrom', 'title', 'description', 'sentanalyze', 'photolink', 'newslink')