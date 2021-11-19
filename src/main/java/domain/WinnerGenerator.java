package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerGenerator {


    /**
     *   [] 입력받은 당첨 번호 split
     *      - null,isEmpty 예외
     *      - 구분자 분리 ","
     *      - 문자열 -> 정수형 리스트
     *      - 숫자 6개 예외
     *
     *   [] 모든 예외처리 및 리스트 정수형으로 변환 -> checkTotalThrowInteger()
     */

    private List<Integer> wiList=new ArrayList<>();


    public WinnerGenerator(String input){
        checkTotalThrowInteger(input);
        checkNull(input);
        checkSeparator(input);
    }

    // [] 모든 예외처리 및 리스트 정수형으로 변환
    public static void checkTotalThrowInteger(String input){
            checkNull(input);
            checkSeparator(input);

            //split 분리
            List<String> changeSplit=changeSplit(input);
            checkLengthSix(changeSplit);
            // - 문자열 -> 정수형 리스트

    }

    // - 숫자 6개 예외
    public static void checkLengthSix(List<String> changeSplit){

        if(!(changeSplit.size() ==6)){
            throw new IllegalArgumentException("숫자 6개 입력해주세요");
        }
    }


    // [] 입력받은 당첨 번호 split
    public static List<String> changeSplit(String input){
        String inputSplit[] = input.split(",");
        List<String> chagneList=new ArrayList<>();
        for(int i=0; i<inputSplit.length; i++){
            chagneList.add(inputSplit[i]);
        }
        return chagneList;
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
