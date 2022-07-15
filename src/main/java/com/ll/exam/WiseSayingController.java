package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    Scanner sc;
    int lastIndex;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    WiseSayingController(Scanner sc){
        this.sc =sc;
        lastIndex = 0;
    }

    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        int id = ++lastIndex;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        System.out.println(lastIndex+"번 명언이 등록되었습니다.");
    }

    public void remove(Rq rq) {
        int paramId = rq.getIntParam("id",0);
        if (paramId == 0){
            System.out.println("id가 존재하지 않습니다.");
        }
        for (WiseSaying saying : wiseSayings) {
            if (saying.id == paramId){
                wiseSayings.remove(saying);
                System.out.println(paramId+"번 명언이 삭제되었습니다.");
                continue ;
            }
        }
        System.out.println(paramId+"번 명언은 존재하지 않습니다.");
    }


    public void modify(Rq rq) {
        int modifyId = rq.getIntParam("id",0);
        if (modifyId == 0){
            System.out.println("id가 존재하지 않습니다.");
        }
        for (WiseSaying saying : wiseSayings) {
            if (saying.id == modifyId){
                System.out.println("명언(기존) : " + saying.content);
                saying.content = sc.nextLine();
                System.out.println("작가(기존) : " + saying.author);
                saying.author = sc.nextLine();
                continue ;
            }
        }
        System.out.println(modifyId+"번 명언은 존재하지 않습니다.");
    }


    public void list() {
        for (WiseSaying saying : wiseSayings) {
            System.out.printf("%d / %s / %s\n",saying.id, saying.author, saying.content);
        }
    }


}
