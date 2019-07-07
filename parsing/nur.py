from bs4 import BeautifulSoup as soup

import requests


url = 'https://www.nur.kz/latest?page={page}'


def parse_titles(body):
    page_soup = soup(body, "html.parser")
    containers = page_soup.findAll("article", {"class":"block-infinite__item"})
    titles = [c.a.div.div.img["alt"] for c in containers]
    urls = [c.a["href"] for c in containers]
    return titles

def parse_urls(body):
    page_soup = soup(body, "html.parser")
    containers = page_soup.findAll("article", {"class":"block-infinite__item"})
    urls = [c.a["href"] for c in containers]
    return urls

def titles_to_csv(titles, urls):
    with open('nur.csv', 'w', encoding='utf-16') as f:
        for title in titles:
            f.write(title + '\n')
        for url in urls:
            f.write(url + '\n')

# def urls_to_csv(urls):



def run():
    page = 0
    while True:
        page += 1
        r = requests.get(url.format(page=page))
        titles = parse_titles(r.text)
        urls = parse_urls(r.text)
        if len(titles) == 0:
            break
        titles_to_csv(titles, urls)
        print('Succesfully parsed page: {}'.format(page))


if __name__ == '__main__':
    run()
