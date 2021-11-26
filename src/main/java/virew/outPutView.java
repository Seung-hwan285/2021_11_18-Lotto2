package virew;
import domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class outPutView {

    /**
     *    [] 모든 로또 출력
     *    [] 로또 한줄씩 출력
     *    [] 당첨번호 출력
     *    [] 수익률 출력
     */
    static InputView inputView;
    private static Lotto lotto;
    private static WinnerGenerator winnerGenerator;





    // [] 로또 한줄씩 출력
    private static void printLottoNumbers(Lotto lotto){

        List<Integer> lottoList=lotto.getLottoList();

        String result =lottoList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        StringBuilder sb=new StringBuilder();
        sb.append("[")
                .append(result)
                .append("]");
        System.out.println(sb.toString());

    }

    // [] 모든 로또 출력
    public static void TotalLottoPrint(Lottos lottos){
        List<Lotto> lottosLine=lottos.getLottosList();

        for(Lotto lotto: lottosLine){
            printLottoNumbers(lotto);
        }
    }


    public static void printMatchtReal(LottoResult lottoResult,PurchasePrice purchasePrice){
        printMatchResults(lottoResult.getLottoList());
        printEarn(lottoResult.calculateEngin(purchasePrice));
    }




    public static void printMatchResults(Map<MatchResultEunm,Integer> maatchResult){

        MatchResultEunm matchResult[]=MatchResultEunm.values();

        for(MatchResultEunm result: matchResult){
            System.out.println(String.format("(%d원)- %d개 ",result.getPrice(),maatchResult.get(result)));
        }

    }

    // 당첨결과 출력
    public static void lottoResultPrint(MatchResultEunm result){
        if(result== MatchResultEunm.FIVE_BOUNSE_BALL){
            System.out.println(String.format("%d 개일치",result.getCountMatch()));
            return;
        }
        System.out.println(String.format("%d개 일치",result.getCountMatch()));
    }

    //수익률
    public static void printEarn(int money){
        System.out.println(String.format("축하합니다!",money));
    }

}
