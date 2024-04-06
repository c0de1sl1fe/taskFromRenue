package com.ykic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderCSV {
    private String path;
    private int targetId;
    private Trie data1;

    public ReaderCSV(String path, int targetId) {
        this.path = path;
        this.targetId = targetId;
        this.data1 = new Trie();
    }

    public void readData() {
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {
                String[] tmp = line.split(cvsSplitBy);
                data1.insert(new Couple(Integer.parseInt(tmp[0]), tmp[targetId-1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setPath(String path) {
        this.path = path;
        readData();
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getPath() {
        return path;
    }

    public int getTargetId() {
        return targetId;
    }

    public Trie getData() {
        return data1;
    }
}