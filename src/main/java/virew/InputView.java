package virew;

import java.util.Scanner;

public class InputView {

    private final static Scanner sc=new Scanner(System.in);

    public static String moneyInput(){
        System.out.println("구입 금액을 입력하세요");
        return sc.nextLine();
    }
}
