package com.ykic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderTXT {
    private ArrayList<String> data;
    private String path;

    public ReaderTXT(String path) {
        data = new ArrayList<>();
        this.path = path;
    }

    public void readData() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.err.println("Reading error: " + e.getMessage());
        }
    }

    public ArrayList<String> getData() {
        return data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        readData();
    }
}
