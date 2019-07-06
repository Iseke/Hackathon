from bs4 import BeautifulSoup
import requests
import json


def crawl_vlast(url):
    result = []
    req = requests.get(url)
    soup = BeautifulSoup(req.text, "lxml")

    # find paging page
    paging = soup.find_all("div", {'class': 'last-inline'})
    paging_link = paging[0].find_all('a')
    last_page = int([item.get('href').split('/')[-1] for item in paging_link][-1])

    # looping through paging
    for i in range(1, last_page):
        print
        url + str(i)

        # find article link
        req = requests.get(url + str(i))
        soup = BeautifulSoup(req.text, "lxml")
        news_links = soup.find_all("div", {'class': 'news-inline-item media'})

        # looping through article link
        for idx, news in enumerate(news_links):
            news_dict = {}

            # find news title
            title_news = news.find('div', {'class': 'news-inline-item-title'}).text

            # find url news
            url_news = news.find('a', {'class': 'news-inline-item-title'}).get('href')

            # find news content in url
            req_news = requests.get(url_news)
            soup_news = BeautifulSoup(req_news.text, "lxml")

            # find news content
            news_content = soup_news.find("div", {'class': 'default-item-in js-editor js-img-caption js-mediator-article font-edit'})

            # find paragraph in news content
            p = news_content.find_all('p')
            content = ' '.join(item.text for item in p)
            news_content = content.encode('utf8', 'replace')

            # wrap in dictionary
            news_dict['id'] = idx
            news_dict['url'] = url_news
            news_dict['title'] = title_news
            news_dict['content'] = news_content
            result.append(news_dict)

    return result


url = 'https://vlast.kz/novosti/'
crawl = crawl_vlast(url)
with open("vlast.json", "w") as f:
    json.dump(crawl, f)