from rest_framework import serializers

from polls.models import Movies

class MovieSerializer(serializers.ModelSerializer):
    title = serializers.CharField(required=False)
    director = serializers.CharField(required=False)
    producer = serializers.CharField(required=False)
    rating = serializers.FloatField(required=False)

    class Meta:
        model = Movies
        fields = ['id', 'title', 'director', 'producer', 'rating']