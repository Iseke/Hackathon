from django.contrib import admin
from polls.models import Movies

@admin.register(Movies)
class ProductAdmin(admin.ModelAdmin):
    list_display = ('id', 'title', 'director', 'producer', 'rating')