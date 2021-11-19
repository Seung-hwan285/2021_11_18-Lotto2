package virew;

import com.sun.source.tree.LiteralTree;
import domain.Lotto;
import domain.LottoGenerator;
import domain.Lottos;
import domain.PurchasePrice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class outPutView {

    static InputView inputView;

   static String money=inputView.moneyInput();

   static int count =new PurchasePrice(money).myMoneyCount();
    public static void MymoneyPrint(){

        System.out.println(new PurchasePrice(money).getMyMoney()+"원 입니다.");

    }

    public static void countLotto(){
        System.out.println("로또 개수 : " +count);


    }

    private static void printLottoNumbers(Lotto lotto){
        System.out.println("로또생성");

        StringBuilder sb=new StringBuilder();
        List<Integer> oneLotto=lotto.getLottoList();
        for(Integer i: oneLotto){
            sb.append(i+" ");
        }

        System.out.println(sb.toString());


    }
    public static void TotalLottoPrint(Lottos lottos){
        List<Lotto> lottosLine=lottos.getLottosList();

        for(Lotto lotto: lottosLine){
            printLottoNumbers(lotto);
        }
    }
}

