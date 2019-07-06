from import_export import resources
from .models import Movies


class MoviesResource(resources.ModelResource):

    class Meta:
        model = Movies