package com.fcvscodemvn.gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

public class GsonDemo {
    private static class User {
        private int id;
        private String name;
        private transient String nationality;

        public User(int id, String name, String nationality) {
            this.id = id;
            this.name = name;
            this.nationality = nationality;
        }

        public User(int id, String name) {
            this(id, name, null);
        }
    }

    private static void writeObjectToJsonFile() throws IOException {
        String outPath = "/Users/xiefengchang/test/d/hell.json";
        try (Writer writer = new FileWriter(outPath)) {
            // 原始版
            Gson gson = new GsonBuilder().create();
            // 格式美化版
            // Gson gson = new GsonBuilder().setPrettyPrinting().create();
            User user = new User(1, "Tom Smith", "American");
            gson.toJson(user, writer);
        }
    }

    public static void main(String[] args) throws JsonIOException, IOException {
        writeObjectToJsonFile();
    }
}