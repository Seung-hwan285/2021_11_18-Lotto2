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
     *   [] null,","구분자 예외 메소드 분리
     *   [] otherType , LengthLimit 예외 메소드 분리
     *   [] spliteNumber<String> 메소드 분리
     *   [] 문자열 list -> Integer List 메소드 분리
     *   [] 보너스볼 추가
     *   *

     */

    private static List<Integer>winngNumbers=new ArrayList<>();

    public WinnerGenerator(final String input){

        winngNumbers=totalCheckException(input);
    }

    // [] 보너스볼 추가
    public static List<Integer> bounusBall(final int bouns){
        winngNumbers.add(bouns);

        return winngNumbers;
    }


    // [] 문자열 list -> Integer List 메소드 분리
    public static List<Integer> changeIntegerList(final List<String> splitNumber){
        List<Integer> changeList=new ArrayList<>();
        changeList=splitNumber.stream()
                .map(Integer::new)
                .collect(Collectors.toList());

        return changeList;
    }

    public static List<Integer> getWinngNumbers() {

        return winngNumbers;
    }

    // [] null,","구분자 예외 메소드 분리
    public static void checkNullAndSeparator(final String input){
        checkNull(input);
        checkSeparator(input);
    }

    // [] otherType , LengthLimit 예외 메소드 분리
    public static void checkSixLimitAndOtherType(final List<String> splitNumber){
        checkOhtherType(splitNumber);
        checkLengthSix(splitNumber);
    }

    // [] spliteNumber<String> 메소드 분리
    public static List<String> changeSplitNumber(final String input){
        List<String> splitNumber=changeSplit(input);
        return splitNumber;
    }


    // [] 예외처리 한번에 처리하는 메서드로 분리
    public static List<Integer> totalCheckException(final String input){

        checkNullAndSeparator(input);

        List<String> splitNumber=changeSplitNumber(input);
        checkSixLimitAndOtherType(splitNumber);

        // 문자열 리스트 -> 정수형 리스트로 변경
        List<Integer> winngNumbers=changeIntegerList(splitNumber);

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
