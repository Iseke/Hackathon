from django_filters import rest_framework as filters
from polls.models import News


class NewsFilter(filters.FilterSet):
    pagefrom = filters.CharFilter(lookup_expr='contains')
    title = filters.CharFilter(lookup_expr='contains')

    class Meta:
        model = News
        fields = ('pagefrom', 'title', )