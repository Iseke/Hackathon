import requests
from bs4 import BeautifulSoup

def drug_data():
    url = 'https://vlast.kz/novosti/'
    i = 0
    while url:
        print(url)
        r = requests.get(url)
        soup = BeautifulSoup(r.text ,"lxml")
        paging = soup.findAll("div", {'class': 'list-inline'})

        # if url:
        #     url = 'https://vlast.kz/novosti/' + url[0].get('href')
        # else:
        #     break

drug_data()