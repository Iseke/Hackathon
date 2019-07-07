import pandas as pd

from tablib import Dataset
from django.http import HttpResponse
from polls.resources import  News2Resource
from polls.models import  FilterData

def simple_upload(request):
    news = News2Resource()
    dataset = Dataset()
    file = open('./polls/importnews.csv')
    imported_data = dataset.load(file.read())
    result = news.import_data(dataset, dry_run=True)  # Test the data import

    if not result.has_errors():
        news.import_data(dataset, dry_run=False)  # Actually import now

    return HttpResponse()

