package Controller;

import domain.*;
import virew.InputView;
import virew.outPutView;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LottoController {

    outPutView outPutView;
    public void run(){

        outPutView=new outPutView();
        String input=InputView.userInput();
        PurchasePrice purchasePrice=new PurchasePrice(input);

        int lottoCount= PurchasePrice.myMoneyCount();

        // 모든 로또 출력
        List<Lotto> randomLotto= LottoGenerator.generate(lottoCount);
        Lottos lottos=new Lottos(randomLotto);

        outPutView.TotalLottoPrint(lottos);
        // 당첨번호 입력
        String userInput= InputView.userInput();
        WinnerGenerator winnerGenerator=new WinnerGenerator(userInput);
        String bounsBall=InputView.bonusBall();


        // 보너스볼 입력
        BounsBall bounsBall1=new BounsBall(bounsBall);


        Map<MatchResultEunm,Integer> matchResult =lottos.createMatchResults(winnerGenerator,bounsBall1);

        LottoResult lottoResult=new LottoResult(matchResult);

        outPutView.printMatchtReal(lottoResult,purchasePrice);



    }

}
