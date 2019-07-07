import time

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from webdriver_manager.chrome import ChromeDriverManager
from bs4 import BeautifulSoup as soup
from urllib.request import urlopen


browser = webdriver.Chrome(ChromeDriverManager().install())

browser.get("https://www.nur.kz/latest/")
time.sleep(1)

elem = browser.find_element_by_tag_name("body")

no_of_pagedowns = 30

while no_of_pagedowns:
    elem.send_keys(Keys.PAGE_DOWN)
    time.sleep(0.2)
    no_of_pagedowns-=1

# post_elems = browser.find_elements_by_class_name("news-inline-item-title")

my_url = 'https://www.nur.kz/latest/'
urlopen(my_url)
uClient = urlopen(my_url)
page_html = uClient.read()
uClient.close()

page_soup = soup(page_html, "html.parser")
containers = page_soup.findAll("article", {"class":"block-infinite__item"})
with open('nur.csv', 'w', encoding='utf-16') as f:
	for c in containers:
	    news_title = c.a.div.div.img["alt"]
	    from_link = c.a["href"]
	    f.write(news_title + "#" + from_link + "#")
        