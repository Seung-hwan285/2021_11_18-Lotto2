package domain;

import java.util.List;

public class BounsBall {

    /**
     *   [] 보너스 볼 입력
     *      - 숫자가 아닌 다른 타입
     *      - 1~45 숫자
     *
     *
     */

    private static int bounuNum;

    public BounsBall(final String input){
        bounuNum= checkOtherType(input);
        checkNumberLimit(bounuNum);
    }


    public static int getBounuNum() {
        return bounuNum;
    }


    public boolean isIncluded(List<Integer> numbers) {
        return numbers.stream()


                .anyMatch(integer -> integer == bounuNum);
    }


    // - 숫자가 아닌 다른 타입
    public static int checkOtherType(final String input){
        try{
            return Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("숫자가 아닌 다른 타입입니다.");
        }
    }

    // - 1~45 숫자
    public static void checkNumberLimit(final int num){

        if(num < 1 || num > 45){
            throw new IllegalArgumentException("1~45숫자만 입력해주세요");
        }
    }


}
