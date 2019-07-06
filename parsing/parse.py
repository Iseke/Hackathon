from __future__ import with_statement
from bs4 import BeautifulSoup as soup
from urllib.request import urlopen
import codecs

my_url = 'https://www.nur.kz/latest/'
urlopen(my_url)
uClient = urlopen(my_url)
page_html = uClient.read()
uClient.close()

page_soup = soup(page_html, "html.parser")

containers = page_soup.findAll("a", {"class":"post-preview-mixed"})

with open('nur.csv', 'w', encoding='utf-16') as f:
    for c in containers:
        news_title = c.div.div.img["alt"]
        f.write(news_title + "#")

print(len(containers))

# for c in containers:
#     news_title = c.findAll("header", {"class":"post-preview-mixed__title post-preview-mixed__title--fixed"})
#     print(news_title[0].text)
#
