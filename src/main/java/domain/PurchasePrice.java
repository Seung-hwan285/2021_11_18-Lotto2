package domain;

public class PurchasePrice {


    /**
     *  [] 사용자에게 구입 금앱 입력
     *      - 숫자가 아닌  다른 타입
     *      - 1000보다 작을때 에러
     *      - 빈값 에러
     *
     *  [] 모든 예외 처리하는 테스트 -> totalcheckError()
     *
     *  [] 문자열 -> 정수
     *
     *  [] 구입 금액으로 로또 개수 판별
     *
     */
    private static int myMoney;

    public PurchasePrice(final String input){

        this.myMoney=totalcheckError(input); // 모든 예외 처리하는 테스트
    }


    public static int totalcheckError(final String input){
        int monye;
        checkLimit(input);
        monye=checkOtherType(input);
        monye=checkLimit(input);

        return monye;
    }

    // - 빈값 에러
    public static void checkIsEmpty(final String input){
        if(input.isEmpty() || null==input){
            throw new IllegalArgumentException("null");
        }

    }


    // - 1000보다 작을때 에러
    public static int checkLimit(final String input){
        int num;

        num=changeInt(input);

        if(num < 1000){
            throw new IllegalArgumentException("1000원 이상만 지불하세요");
        }
        return num;
    }

    // [] 문자열 -> 정수
    public static int changeInt(final String input){
        return Integer.parseInt(input);
    }

    // - 숫자가 아닌  다른 타입
    public static int checkOtherType(final String input){
        try{
            return changeInt(input);
        }catch(IllegalArgumentException e){
            throw  new IllegalArgumentException("숫자만 입력해주세요");
        }

    }

    // [] 구입 금액으로 로또 개수 판별
    public static int myMoney(){
        return myMoney/1000;
    }
}
