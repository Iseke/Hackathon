from django.contrib import admin
from polls.models import  News,FilterData,NewsNew


@admin.register(News)
class NewsAdmin(admin.ModelAdmin):
    list_display = ('id', 'pagefrom', 'title', 'description', 'sentanalyze', 'photolink', 'newslink')

@admin.register(FilterData)
class filterAdmin(admin.ModelAdmin):
    list_display = ('sitename','titlecontent')

@admin.register(NewsNew)
class NewsAdmin22(admin.ModelAdmin):
    list_display = ('id', 'pagefrom', 'title', 'description', 'sentanalyze', 'photolink', 'newslink')
