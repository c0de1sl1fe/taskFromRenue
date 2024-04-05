package com.ykic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReaderCSV {
    private String path;
    private int targetId;
    private ArrayList<Couple> data;

    public ReaderCSV(String path, int targetId) {
        this.path = path;
        this.targetId = targetId;
        this.data = new ArrayList<>();
    }

    public void readData() {
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {
                // используем запятую в качестве разделителя
                String[] tmp = line.split(cvsSplitBy);
                data.add(new Couple(Integer.parseInt(tmp[0]), tmp[targetId-1]));
                System.out.println(Arrays.toString(line.split(cvsSplitBy)));
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

    public ArrayList<Couple> getData() {
        return data;
    }
}