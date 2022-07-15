package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingService {

    private Scanner sc;
    private WiseSayingRepository wiseSayingRepository;
    WiseSayingService(Scanner sc) {
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository(sc);
    }

    public WiseSaying write(String content, String author) {
        return wiseSayingRepository.write(content,author);
    }

    public void remove(int paramId) {
        wiseSayingRepository.remove(paramId);

    }

    public void modify(int paramId, String content, String author) {
        wiseSayingRepository.modify(paramId, content, author);

    }

    public void list() {
        wiseSayingRepository.list();
    }

    public WiseSaying findById(int paramId) {
        return wiseSayingRepository.findById(paramId);
    }
}
