package com.ll.exam;

import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;

    private WiseSayingService wiseSayingService;
    WiseSayingController(Scanner sc){
        this.sc =sc;
        wiseSayingService = new WiseSayingService();
    }

    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        if (wiseSaying == null) {
            System.out.println("마지막 id를 찾지 못하였습니다.");
            return;
        }

        System.out.println(wiseSaying.id+"번 명언이 등록되었습니다.");
    }

    public void remove(Rq rq) {
        int paramId = rq.getIntParam("id",0);

        if (paramId == 0){
            System.out.println("id가 존재하지 않습니다.");
            return;
        }
        WiseSaying foundWiseSaying = wiseSayingService.findById(paramId);

        if(foundWiseSaying == null){
            System.out.println(paramId+"번 명언은 존재하지 않습니다.");
            return;
        }
        wiseSayingService.remove(paramId);
        System.out.println(paramId+"번 명언이 삭제되었습니다.");

    }


    public void modify(Rq rq) {
        int paramId = rq.getIntParam("id",0);

        if (paramId == 0){
            System.out.println("id가 존재하지 않습니다.");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingService.findById(paramId);


        if(foundWiseSaying == null) {
            System.out.println(paramId+"번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + foundWiseSaying.content);
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.println("작가(기존) : " + foundWiseSaying.author);
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(paramId, content, author);
    }


    public void list() {
        wiseSayingService.list();
    }


}
