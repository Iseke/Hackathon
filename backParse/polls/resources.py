from import_export import resources
from .models import News


class NewsResource(resources.ModelResource):
    class Meta:
        model = News
