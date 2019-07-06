from django.db import models


class News(models.Model):
    pagefrom = models.CharField(max_length=1024)
    title = models.CharField(max_length=1024)
    description = models.CharField(max_length=1024)
    sentanalyze = models.IntegerField()

    class Meta:
        ordering = ('id',)
        verbose_name = 'News'
        verbose_name_plural = 'News'