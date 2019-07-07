from rest_framework import serializers

from polls.models import News, FilterData




class NewsSerializer(serializers.ModelSerializer):
    pagefrom = serializers.CharField(required=False)
    title = serializers.CharField(required=False)
    description = serializers.CharField(required=False)
    sentanalyze = serializers.IntegerField(required=False)
    photolink = serializers.CharField(required=False)
    newslink = serializers.CharField(required=False)

    class Meta:
        model = News
        fields = ['id', 'pagefrom', 'title', 'description', 'sentanalyze', 'photolink', 'newslink']



class FilterDataSerializer(serializers.ModelSerializer):
    sitename = serializers.CharField(required=False)
    titlecontent = serializers.CharField(required=False)

    class Meta:
        model= FilterData
        fields = ['sitename', 'titlecontent']