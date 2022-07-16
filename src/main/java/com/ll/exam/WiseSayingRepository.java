package com.ll.exam;

import java.io.File;
import java.util.Map;


public class WiseSayingRepository {
    private String path;
    private String lastIdFilePath;
    WiseSayingRepository(){
        path="data_test/wiseSaying";
        lastIdFilePath = path+"/last_id.txt";
        Util.file.mkdir(path);

        // lastId 파일이 없는 경우 초기화 = 최초의 실행
        if (getLastIdFromFile() == -1){
            Util.file.saveToFile(lastIdFilePath,"0");
        }
    }

    public WiseSaying write(String content, String author) {

        //lastIdFilePath 값을 파일에서 가져온다.
        int lastId = getLastIdFromFile();

        if (lastId == -1){
            return null;
        }

        int newLastId = lastId +1;
        WiseSaying wiseSaying = new WiseSaying(newLastId, content, author);

        // 파일에 추가 + lastId 갱신
        Util.file.saveToFile(getFileNameFromId(newLastId), wiseSaying.toJson());
        Util.file.saveToFile(lastIdFilePath, Integer.toString(newLastId));

        return wiseSaying;
    }

    public void remove(int paramId) {
        Util.file.deleteDir(getFileNameFromId(paramId));
    }

    public void modify(int paramId, String content, String author) {
        // 파일을 덮어쓴다 = 수정
        WiseSaying wiseSaying = new WiseSaying(paramId, content, author);
        Util.file.saveToFile(getFileNameFromId(paramId), wiseSaying.toJson());
    }

    public void list() {

        // 파일에서 마지막 id가져옴
        int lastId = getLastIdFromFile();
        if (lastId == -1){
            return;
        }
        for (int i = 1; i <= lastId; i++) {
            Map<String, Object> map = Util.json.jsonToMapFromFile(getFileNameFromId(i));

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

        // 파일이 존재하지 않는 경우
        if (new File(path).exists() == false) {
            return null;
        }

        Map<String,Object> map = Util.json.jsonToMapFromFile(getFileNameFromId(paramId));

        if (map == null) {
            return null;
        }

        return new WiseSaying((int) map.get("id"), (String) map.get("content"), (String) map.get("author"));
    }

    public String getFileNameFromId(int paramId) {
        return path+"/"+paramId+".json";
    }

    public int getLastIdFromFile() {
        return Integer.parseInt(Util.file.readFromFile(lastIdFilePath,"-1"));
    }
}
