from django.urls import path

from polls import views

urlpatterns = [
    path('movies/', views.MovieList.as_view()),
    path('export/csv/', views.exportCSV),
    path('export/json/', views.exportJSON),
    path('export/excell/', views.exportEXCEL),

]