from import_export import resources
from .models import News,NewsNew


class NewsResource(resources.ModelResource):
    class Meta:
        model = News


class News2Resource(resources.ModelResource):
    class Meta:
        model = NewsNew
