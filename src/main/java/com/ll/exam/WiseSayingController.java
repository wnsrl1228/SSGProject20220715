package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    Scanner sc;

    WiseSayingService wiseSayingService;
    WiseSayingController(Scanner sc){
        this.sc =sc;
        wiseSayingService = new WiseSayingService(sc);
    }

    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.println(wiseSaying.id+"번 명언이 등록되었습니다.");
    }

    public void remove(Rq rq) {
        int paramId = rq.getIntParam("id",0);

        if (paramId == 0){
            System.out.println("id가 존재하지 않습니다.");
        }
        boolean check = wiseSayingService.remove(paramId);
        if(check){
            System.out.println(paramId+"번 명언이 삭제되었습니다.");
            return;
        }

        System.out.println(paramId+"번 명언은 존재하지 않습니다.");
    }


    public void modify(Rq rq) {
        int paramId = rq.getIntParam("id",0);
        if (paramId == 0){
            System.out.println("id가 존재하지 않습니다.");
        }
        boolean check = wiseSayingService.modify(paramId);
        if(!check) {
            System.out.println(paramId+"번 명언은 존재하지 않습니다.");
        }
    }


    public void list() {
        wiseSayingService.list();
    }


}
