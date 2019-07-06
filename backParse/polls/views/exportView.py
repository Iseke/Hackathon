from django.http import HttpResponse
from polls.resources import MoviesResource

def exportCSV(request):
    movies = MoviesResource()
    dataset = movies.export()
    response = HttpResponse(dataset.csv, content_type='text/csv')
    response['Content-Disposition'] = 'attachment; filename="movies.csv"'
    return response


def exportJSON(request):
    movies = MoviesResource()
    dataset = movies.export()
    response = HttpResponse(dataset.json, content_type='application/json')
    response['Content-Disposition'] = 'attachment; filename="movies.json"'
    return response


def exportEXCEL(request):
    movies = MoviesResource()
    dataset = movies.export()
    response = HttpResponse(dataset.xlsx, content_type='application/json')
    response['Content-Disposition'] = 'attachment; filename="movies.xlsx"'
    return response

