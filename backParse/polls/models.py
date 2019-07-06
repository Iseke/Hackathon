from django.db import models
from django.core.validators import MinValueValidator, MaxValueValidator


class Movies(models.Model):
    title = models.CharField(max_length=255)
    director = models.CharField(max_length=255)
    producer = models.CharField(max_length=255)
    rating = models.FloatField(default=1, validators=[MinValueValidator(0), MaxValueValidator(10)])
    rating_count = models.IntegerField(default=1)

    class Meta:
        ordering = ('title',)
        verbose_name = 'Movie'
        verbose_name_plural = 'Movies'