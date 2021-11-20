package virew;

import com.sun.source.tree.LiteralTree;
import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class outPutView {

    /**
     *    [] 모든 로또 출력
     *    [] 로또 한줄씩 출력
     *    [] 당첨번호 출력
     */
    static InputView inputView;
    private static Lotto lotto;
    private static WinnerGenerator winnerGenerator;
   static String money=inputView.moneyInput();

   static int count =new PurchasePrice(money).myMoneyCount();


    public static void MymoneyPrint(){

        System.out.println(new PurchasePrice(money).getMyMoney()+"원 입니다.");

    }

    public static void countLotto(){
        System.out.println("로또 개수 : " +count);


    }


    // [] 로또 한줄씩 출력
    private static void printLottoNumbers(Lotto lotto){
        lotto=new LottoGenerator().generate();
        System.out.println("로또생성");

        StringBuilder sb=new StringBuilder();
        List<Integer> oneLotto=lotto.getLottoList();
        for(Integer i: oneLotto){
            sb.append(i+" ");
        }

        System.out.println(sb.toString());


    }
    // [] 모든 로또 출력
    public static void TotalLottoPrint(Lottos lottos){
        List<Lotto> lottosLine=lottos.getLottosList();

        for(Lotto lotto: lottosLine){
            printLottoNumbers(lotto);
        }
    }

     // [] 당첨번호 출력
    public static void WinnerPrint(String input){
        System.out.println(new WinnerGenerator(input).getWinngNumbers());
    }

    // [] 보너스 볼 출력
    public static void BounsBall(String input){
        int bounus=new BounsBall(input).getBounuNum();
        System.out.println(winnerGenerator.bounusBall(bounus));
    }

    // [] 당첨번호 비교 결과 출력
    public static void oneLineResult(WinnerGenerator winnerGenerator){
        System.out.println("맞춘 로또 입니다 :"+lotto.oneLineLottoeEulas(winnerGenerator));
    }
}

