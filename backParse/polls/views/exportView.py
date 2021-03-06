from django.http import HttpResponse
from polls.resources import News2Resource
from django_filters.rest_framework import DjangoFilterBackend
from polls.filters import NewsFilter
from rest_framework import filters


def exportCSV(request):
    news = News2Resource()
    dataset = news.export()
    response = HttpResponse(dataset.csv, content_type='text/csv')
    response['Content-Disposition'] = 'attachment; filename="news.csv"'
    return response


def exportJSON(request):
    news = News2Resource()
    dataset = news.export()
    response = HttpResponse(dataset.json, content_type='application/json')
    response['Content-Disposition'] = 'attachment; filename="news.json"'
    return response


def exportEXCEL(request):
    news = News2Resource()
    dataset = news.export()
    response = HttpResponse(dataset.xlsx, content_type='application/json')
    response['Content-Disposition'] = 'attachment; filename="news.xlsx"'
    return response

