package domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerGenerator {


    /**
     *   [] 입력받은 당첨 번호 split
     *      - 입력 null
     *      - 6개 입력 x
     */

    private List<Integer> wiList=new ArrayList<>();


    public WinnerGenerator(String input){
      //  this.wiList=// 모든 예외 처리한 함수
        checkNull(input);

    }

    // - 입력 null
    public static void checkNull(String input){
        if(input==null || input.trim().isEmpty()){

            throw new IllegalArgumentException("당첨 번호를 입력하지 않으셨습니다.");

        }
    }



}
