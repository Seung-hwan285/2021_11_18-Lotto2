package virew;

import java.util.Scanner;

public class InputView {

    private final static Scanner sc=new Scanner(System.in);

    public static String moneyInput(){
        System.out.println("구입 금액을 입력하세요");
        return sc.nextLine();
    }
    public static String userInput(){
        System.out.println("당첨 번호를 입력해주세요");
        return sc.nextLine();
    }

    public static String bonusBall(){
        System.out.println("보너스 볼 입력해주세요");
        return sc.nextLine();
    }
}
