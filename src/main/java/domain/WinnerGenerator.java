package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerGenerator {


    /**
     *   [] 입력받은 당첨 번호 split
     *      - null,isEmpty 예외
     *      - 구분자 분리 ","
     *      - 숫자 6개 예외
     *      - 숫자가 아닌 다른 타입
     *      - 1~45숫자 예외
     *      - 중복 예외
     *
     *   [] 예외처리 한번에 처리하는 메서드로 분리
     *

     */

    private static List<Integer>winngNumbers=new ArrayList<>();

    public WinnerGenerator(String input){

        winngNumbers=totalCheckException(input);
    }



    public static List<Integer> getWinngNumbers() {
        return winngNumbers;
    }

    // [] 예외처리 한번에 처리하는 메서드로 분리
    public static List<Integer> totalCheckException(String input){
        checkNull(input);
        checkSeparator(input);


        List<String> splitNumber=changeSplit(input);
        checkOhtherType(splitNumber);
        checkLengthSix(splitNumber);

        // 문자열 리스트 -> 정수형 리스트로 변경
        List<Integer> winngNumbers=splitNumber.stream()
                .map(Integer::new)
                .collect(Collectors.toList());

        numbersLimit(winngNumbers);
        isDuplicate(winngNumbers);

        return winngNumbers;
    }

    // - 중복 예외
    public static void isDuplicate(List<Integer> winngNumbers){
        Set<Integer> testSet=new HashSet<>(winngNumbers);

        if(testSet.size() != winngNumbers.size()){
            throw new IllegalArgumentException("중복 값이 있습니다.");
        }
    }

    // - 1~45숫자 예외
    public static void numbersLimit(List<Integer>splitNumber){

        for(int num: splitNumber){
            if(num < 1 || num >45){
                throw new IllegalArgumentException("1~45 만 입력해주세요");
            }
        }

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

    // - 숫자가 아닌 다른 타입
    public static void checkOhtherType(List<String> splitNumber){

        try {
            splitNumber.stream()
                    .map(Integer::new)
                    .collect(Collectors.toList());
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("숫자가 아닌 다른 타입입니다.");
        }

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
