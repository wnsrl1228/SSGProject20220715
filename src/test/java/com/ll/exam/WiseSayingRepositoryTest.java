package com.ll.exam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WiseSayingRepositoryTest {


    @BeforeEach
    public void beforeEach(){
        Util.file.deleteDir("data_test");
    }
    @Test
    public void 파일_생기는지_테스트() {
        Scanner sc = new Scanner(System.in);
        WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    }
    @Test
    public void 파일_생성_테스트() {
        Scanner sc = new Scanner(System.in);
        WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
        wiseSayingRepository.write("안녕하세요","김김김");

    }
    @Test
    public void 파일_여러개_생성_테스트() {
        Scanner sc = new Scanner(System.in);
        WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
        wiseSayingRepository.write("안녕하세요","김김김");
        wiseSayingRepository.write("잘가세요","김2");
        wiseSayingRepository.write("방가방가","김3");
    }
    @Test
    public void id로_파일_조회() {
        Scanner sc = new Scanner(System.in);
        WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
        wiseSayingRepository.write("안녕하세요","김김김");
        wiseSayingRepository.write("잘가세요","김2");
        WiseSaying wiseSaying = wiseSayingRepository.findById(2);
        assertEquals("잘가세요",wiseSaying.content);
    }
    @Test
    public void 해당id의_파일_삭제() {
        Scanner sc = new Scanner(System.in);
        WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
        wiseSayingRepository.write("안녕하세요","김김김");
        wiseSayingRepository.write("잘가세요","김2");
        wiseSayingRepository.remove(1);
    }
    @Test
    public void 해당id의_파일_수정() {
        Scanner sc = new Scanner(System.in);
        WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
        wiseSayingRepository.write("안녕하세요", "김김김");
        wiseSayingRepository.write("잘가세요", "김2");
        wiseSayingRepository.modify(1, "아이고", "김선생");
    }
    @Test
    public void 목록_출력() {
        Scanner sc = new Scanner(System.in);
        WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
        wiseSayingRepository.write("안녕하세요", "김김김");
        wiseSayingRepository.write("잘가세요", "김2");
        wiseSayingRepository.list();
    }



}


