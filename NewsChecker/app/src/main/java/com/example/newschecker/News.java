package com.example.newschecker;

public class News {
    String From="";
    String PictureURL="";
    String Title="";
    String ToUrl="";
    String SentimentAnalysis="";

    public News(String from, String pictureURL, String title, String toUrl, String sentimentAnalysis) {
        From = from;
        PictureURL = pictureURL;
        Title = title;
        ToUrl = toUrl;
        SentimentAnalysis = sentimentAnalysis;
    }


    public String getSentimentAnalysis() {
        return SentimentAnalysis;
    }

    public void setSentimentAnalysis(String sentimentAnalysis) {
        SentimentAnalysis = sentimentAnalysis;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getPictureURL() {
        return PictureURL;
    }

    public void setPictureURL(String pictureURL) {
        PictureURL = pictureURL;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getToUrl() {
        return ToUrl;
    }

    public void setToUrl(String toUrl) {
        ToUrl = toUrl;
    }
}
