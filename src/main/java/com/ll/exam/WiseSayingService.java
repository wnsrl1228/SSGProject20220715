package com.ll.exam;

public class WiseSayingService {
    private WiseSayingRepository wiseSayingRepository;
    WiseSayingService() {

        wiseSayingRepository = new WiseSayingRepository();
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
