import csv
from tablib import Dataset
from django.http import HttpResponse
from rest_framework import status

from polls.models import Movies


def simple_upload(request):
    movie = Movies()
    dataset = Dataset()
    file = open('./polls/movies.csv', 'rb')
    print(file.read())
    # records = csv.reader(file)
    # for line in records:
    #     movie.title = line[1]
    #     movie.director = line[2]
    #     movie.producer = line[3]
    #     movie.rating = line[4]
    #     movie.save()
    # file.close()
