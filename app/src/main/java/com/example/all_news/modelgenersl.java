package com.example.all_news;

import java.util.ArrayList;
import java.util.List;

public class modelgenersl {
    String status,totalresults;
    ArrayList<modelarticles>articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(String totalresults) {
        this.totalresults = totalresults;
    }

    public ArrayList<modelarticles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<modelarticles> articles) {
        this.articles = articles;
    }
}
