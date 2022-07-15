package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingService {

    Scanner sc;
    WiseSayingRepository wiseSayingRepository;
    WiseSayingService(Scanner sc) {
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository(sc);
    }

    public WiseSaying write(String content, String author) {
        return wiseSayingRepository.write(content,author);
    }

    public boolean remove(int paramId) {
        return wiseSayingRepository.remove(paramId);

    }

    public boolean modify(int paramId) {
        return wiseSayingRepository.modify(paramId);

    }

    public void list() {
        wiseSayingRepository.list();
    }
}
