package domain;

public class BounsBall {

    /**
     *   [] 보너스 볼 입력
     *      - 숫자가 아닌 다른 타입
     *      - 1~45 숫자
     *      - 당첨번호와 중첩 예외
     *
     */

    private static int bounuNum;
    public BounsBall(final String input){

        bounuNum= checkOtherType(input);
    }

    // - 숫자가 아닌 다른 타입
    public static int checkOtherType(final String input){
        try{

            return Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("숫자가 아닌 다른 타입입니다.");
        }
    }
}
