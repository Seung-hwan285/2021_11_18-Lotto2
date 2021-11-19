package domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerGenerator {


    /**
     *   [] 입력받은 당첨 번호 split
     *      - null,isEmpty 예외
     *      - 구분자 분리 ","
     *      - 숫자 6개 예외

     */

    public WinnerGenerator(String input){

        checkNull(input);
        checkSeparator(input);

        List<String> splitNumber=changeSplit(input);

        checkLengthSix(splitNumber);
    }


    // [] 입력받은 당첨 번호 split
    public static List<String> changeSplit(String input){
        String splitNum[]=input.split(",");
        List<String> inputSplitList=new ArrayList<>();

        for(int i=0; i<splitNum.length; i++){
            inputSplitList.add(splitNum[i]);
        }
        return inputSplitList;

    }


    // 숫자 6개 예외
    public static void checkLengthSix(List<String> inputSplitLitst){
        if(!(inputSplitLitst.size()==6)){
            throw new IllegalArgumentException("숫자 6개 입력해주세요");
        }
    }

    // - null,isEmpty 예외
    public static void checkNull(String input){
        if(input==null || input.isEmpty()){
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
