package com.ykic;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {
    public static boolean checkFileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static <T> void serializeObj(String filePath, T obj) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(obj, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
