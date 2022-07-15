package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void 프로그램_시작시_등록하고_수정() {
        String rs = AppTestRunner.run("""
                등록
                나는 최고야
                홍길동
                목록
                수정?id=1
                나는 바보야
                홍철수
                목록
                종료
                """);
        assertTrue(rs.contains("1 / 홍길동 / 나는 최고야"));
        assertTrue(rs.contains("명언(기존) : 나는 최고야"));
        assertTrue(rs.contains("작가(기존) : 홍길동"));
        assertTrue(rs.contains("1 / 홍철수 / 나는 바보야"));
    }
    @Test
    public void 프로그램_시작시_등록하고_삭제() {
        String rs = AppTestRunner.run("""
                등록
                나는 최고야
                홍길동
                등록
                잘가잘가
                김김김
                삭제?id=1
                삭제?id=1
                목록
                종료
                """);
        assertTrue(rs.contains("1번 명언이 삭제되었습니다."));
        assertTrue(rs.contains("1번 명언은 존재하지 않습니다."));
    }
    @Test
    public void 프로그램_시작시_등록하고_목록() {
        String rs = AppTestRunner.run("""
                등록
                나는 최고야
                홍길동
                등록
                잘가
                김김
                목록
                종료
                """);

        assertTrue(rs.contains("1 / 홍길동 / 나는 최고야"));
        assertTrue(rs.contains("2 / 김김 / 잘가"));
    }
    @Test
    public void 프로그램_시작시_다중등록() {
        String rs = AppTestRunner.run("""
                등록
                나는 최고야
                홍길동
                등록
                잘가
                김김
                종료
                """);

        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
        assertTrue(rs.contains("2번 명언이 등록되었습니다."));
    }
    @Test
    public void 프로그램_시작시_단일등록() {
        String rs = AppTestRunner.run("""
                등록
                나는 최고야
                홍길동
                종료
                """);

        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
    }

    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_종료() {
        String rs = AppTestRunner.run("""
                종료
                """);

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령)"));
    }

    @Test
    public void 테스트(){
        assertTrue(1==1);
        assertEquals(1,1);
    }
}


