package com.ykic;

import java.util.List;

public class SearchResult {
    private int initTime;
    private List<SearchItem> result;

    // Конструкторы, геттеры и сеттеры
    public SearchResult(int initTime, List<SearchItem> result) {
        this.initTime = initTime;
        this.result = result;
    }

    public int getInitTime() {
        return initTime;
    }

    public void setInitTime(int initTime) {
        this.initTime = initTime;
    }

    public List<SearchItem> getResult() {
        return result;
    }

    public void setResult(List<SearchItem> result) {
        this.result = result;
    }
}

class SearchItem {
    private String search;
    private List<Integer> result;
    private int time;

    // Конструкторы, геттеры и сеттеры
    public SearchItem(String search, List<Integer> result, int time) {
        this.search = search;
        this.result = result;
        this.time = time;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<Integer> getResult() {
        return result;
    }

    public void setResult(List<Integer> result) {
        this.result = result;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}