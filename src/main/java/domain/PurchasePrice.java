package domain;

public class PurchasePrice {


    /**
     *  [] 사용자에게 구입 금앱 입력
     *      - 숫자가 아닌  다른 타입
     *      - 1000보다 작을때 에러
     *      - 빈값 에러
     *  [] 모든 예외 처리하는 테스트 -> totalcheckError()
     *  [] 문자열 -> 정수
     *
     */
    private static int myMoney;

    public PurchasePrice(final String input){

        this.myMoney=totalcheckError(input); // 모든 예외 처리하는 테스트
    }


    public static int totalcheckError(final String input){

        myMoney=checkOtherType(input);

        return myMoney;
    }


    public static int changeInt(final String input){
        return Integer.parseInt(input);
    }

    // - 숫자가 아닌  다른 타입
    public static int checkOtherType(final String input){
        int num;
        try{
             num =changeInt(input);
        }catch(IllegalArgumentException e){
            throw  new IllegalArgumentException("숫자만 입력해주세요");
        }
        return num;
    }
}
