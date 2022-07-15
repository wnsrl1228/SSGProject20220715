package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingRepository {
    private int lastIndex;
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private Scanner sc;
    WiseSayingRepository(Scanner sc){
        this.sc = sc;
        lastIndex = 0;
    }

    public WiseSaying write(String content, String author) {
        int id = ++lastIndex;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public void remove(int paramId) {
        WiseSaying foundWiseSaying =  findById(paramId);
        wiseSayings.remove(foundWiseSaying);
    }

    public void modify(int paramId, String content, String author) {
        WiseSaying foundWiseSaying =  findById(paramId);
        foundWiseSaying.content = content;
        foundWiseSaying.author = author;
    }

    public void list() {
        for (WiseSaying saying : wiseSayings) {
            System.out.printf("%d / %s / %s\n",saying.id, saying.author, saying.content);
        }
    }

    public WiseSaying findById(int paramId) {
        for (WiseSaying saying : wiseSayings) {
            if (saying.id == paramId){
                return saying;
            }
        }
        return null;
    }


}
