from django.urls import path

from polls import views

urlpatterns = [
    path('news/', views.NewsList.as_view()),
    path('export/csv/', views.exportCSV),
    path('export/json/', views.exportJSON),
    path('export/excell/', views.exportEXCEL),
    path('import/', views.simple_upload),
    path('filterdata/', views.FilterDataView.as_view())
]