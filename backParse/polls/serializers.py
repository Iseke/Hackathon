from rest_framework import serializers

from polls.models import News




class NewsSerializer(serializers.ModelSerializer):
    pagefrom = serializers.CharField(required=False)
    title = serializers.CharField(required=False)
    description = serializers.CharField(required=False)
    sentanalyze = serializers.IntegerField(required=False)

    class Meta:
        model = News
        fields = ['id', 'pagefrom', 'title', 'description', 'sentanalyze']