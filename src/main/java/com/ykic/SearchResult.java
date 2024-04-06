package com.ykic;

import java.util.List;

public class SearchResult {
    private long initTime;
    private List<SearchItem> result;

    public SearchResult() {
    }

    public long getInitTime() {
        return initTime;
    }

    public void setInitTime(long initTime) {
        this.initTime = initTime;
    }

    public List<SearchItem> getResult() {
        return result;
    }

    public void setResult(List<SearchItem> result) {
        this.result = result;
    }
}

