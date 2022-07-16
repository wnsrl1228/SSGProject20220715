package com.ll.exam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WiseSayingRepository {
    private int lastIndex;
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private Scanner sc;
    private String path;
    private String lastIdFilePath;
    WiseSayingRepository(Scanner sc){
        this.sc = sc;
        lastIndex = 0;
        path="data_test/wiseSaying";
        lastIdFilePath = path+"/last_id.txt";
        Util.file.mkdir(path);

        int lastId = Integer.parseInt(Util.file.readFromFile(lastIdFilePath,"-1"));
        if (lastId == -1){
            Util.file.saveToFile(lastIdFilePath,"0");
        }
    }

    public WiseSaying write(String content, String author) {
        int lastId = Integer.parseInt(Util.file.readFromFile(lastIdFilePath,"-1"));
        String a = Util.file.readFromFile(lastIdFilePath,"-1");

        if (lastId == -1){
            return null;
        }
        int paramId = lastId +1;
        WiseSaying wiseSaying = new WiseSaying(paramId, content, author);

        Util.file.saveToFile(path+"/%d.json".formatted(paramId), wiseSaying.toJson());
        Util.file.saveToFile(lastIdFilePath, Integer.toString(paramId));

        return wiseSaying;
    }

    public void remove(int paramId) {
        String paramIdPath = path+"/"+paramId+".json";
        Util.file.deleteDir(paramIdPath);
    }

    public void modify(int paramId, String content, String author) {
        String paramIdPath = path+"/"+paramId+".json";
        WiseSaying wiseSaying = new WiseSaying(paramId, content, author);
        Util.file.saveToFile(paramIdPath, wiseSaying.toJson());
    }

    public void list() {
        int lastId = Integer.parseInt(Util.file.readFromFile(lastIdFilePath,"-1"));
        if (lastId == -1){
            return;
        }
        for (int i = 1; i <= lastId; i++) {
            Map<String, Object> map = Util.json.jsonToMapFromFile(path+"/"+i+".json");

            if (map == null) {
                continue;
            }

            int id = (int)map.get("id");
            String content = (String)map.get("content");
            String author = (String)map.get("author");

            System.out.println( id + " : " +  content + " : " + author);
        }
    }

    public WiseSaying findById(int paramId) {
        String paramIdPath = path+"/"+paramId+".json";

        if (new File(path).exists() == false) {
            return null;
        }

        Map<String,Object> map = Util.json.jsonToMapFromFile(paramIdPath);

        if (map == null) {
            return null;
        }
        return new WiseSaying((int) map.get("id"), (String) map.get("content"), (String) map.get("author"));
    }


}
