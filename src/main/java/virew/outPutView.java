package virew;

import domain.Lotto;
import domain.LottoGenerator;
import domain.PurchasePrice;

public class outPutView {

    static InputView inputView;

   static String money=inputView.moneyInput();
    public static void MymoneyPrint(){

        System.out.println(new PurchasePrice(money).getMyMoney()+"원 입니다.");

    }

    public static void countLotto(){
        System.out.println("로또 개수 : " +new PurchasePrice(money).myMoneyCount());

        int count= new PurchasePrice(money).myMoneyCount();
        for (int i = 0; i < count; i++) {
            System.out.println(new LottoGenerator().lottoOneLine());
        }

    }


    public static void LottoPrint(){
        System.out.println("Lotto 클래스 출력"+new Lotto().getLottoList());
    }
}

