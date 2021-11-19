package domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerGenerator {


    /**
     *   [] 입력받은 당첨 번호 split
     *      - null,isEmpty 예외
     *      - 구분자 분리 ","
     */

    private List<Integer> wiList=new ArrayList<>();


    public WinnerGenerator(String input){
      //  this.wiList=// 모든 예외 처리한 함수
        checkNull(input);
        checkSeparator(input);
    }

    //- null,isEmpty 예외
    public static void checkNull(String input){
        if(input==null || input.trim().isEmpty()){
            throw new IllegalArgumentException("당첨 번호를 입력하지 않으셨습니다.");
        }
    }

    // - 구분자 분리 ","
    public static void checkSeparator(String input){
        if(!input.contains(",")){
            throw new IllegalArgumentException("당첨번호는 나누어서 입력해주세요");
        }
    }



}
