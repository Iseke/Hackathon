from django.db import models


class News(models.Model):
    pagefrom = models.CharField(max_length=1024)
    title = models.CharField(max_length=1024)
    description = models.CharField(max_length=1024)
    sentanalyze = models.IntegerField()
    photolink = models.CharField(max_length=1024,default='')
    newslink = models.CharField(max_length=1024,default='')

    class Meta:
        ordering = ('id',)
        verbose_name = 'News'
        verbose_name_plural = 'News'


class NewsNew(models.Model):
    pagefrom = models.CharField(max_length=1024)
    title = models.CharField(max_length=1024)
    description = models.CharField(max_length=1024)
    sentanalyze = models.IntegerField()
    photolink = models.CharField(max_length=1024,default='')
    newslink = models.CharField(max_length=1024,default='')

    class Meta:
        ordering = ('id',)
        verbose_name = 'NEWNEW'
        verbose_name_plural = 'NEWNEW'

class FilterData(models.Model):
    sitename = models.CharField(max_length=1024)
    titlecontent = models.CharField(max_length=1024)