package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingService {
    int lastIndex;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    Scanner sc;
    WiseSayingService(Scanner sc) {
        this.sc = sc;
        lastIndex = 0;
    }

    public WiseSaying write(String content, String author) {
        int id = ++lastIndex;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public boolean remove(int paramId) {
        for (WiseSaying saying : wiseSayings) {
            if (saying.id == paramId){
                wiseSayings.remove(saying);
                return true;
            }
        }
        return false;
    }

    public boolean modify(int paramId) {
        for (WiseSaying saying : wiseSayings) {
            if (saying.id == paramId){
                System.out.println("명언(기존) : " + saying.content);
                saying.content = sc.nextLine();
                System.out.println("작가(기존) : " + saying.author);
                saying.author = sc.nextLine();
                return true;
            }
        }
        return false;
    }

    public void list() {
        for (WiseSaying saying : wiseSayings) {
            System.out.printf("%d / %s / %s\n",saying.id, saying.author, saying.content);
        }
    }
}
