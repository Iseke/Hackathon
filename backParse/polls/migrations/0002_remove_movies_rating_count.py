# Generated by Django 2.2.3 on 2019-07-06 13:19

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('polls', '0001_initial'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='movies',
            name='rating_count',
        ),
    ]
