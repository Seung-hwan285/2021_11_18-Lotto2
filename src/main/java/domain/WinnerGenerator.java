package domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerGenerator {


    /**
     *   [] 입력받은 당첨 번호 split
     *      - 입력 null
     */

    private List<Integer> wiList=new ArrayList<>();


    public WinnerGenerator(String input){
      //  this.wiList=// 모든 예외 처리한 함수
        checkNull(input);
    }

    // - 입력 null
    public static void checkNull(String input){
        if(input==null){
            System.out.println("당첨번호 입력해주세요");
            throw new IllegalArgumentException("null");

        }
    }
}
