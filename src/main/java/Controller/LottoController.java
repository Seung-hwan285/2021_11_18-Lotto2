package Controller;

import domain.*;
import virew.InputView;
import virew.outPutView;

import java.util.List;

public class LottoController {

    outPutView outPutView;
    public void run(){

        outPutView=new outPutView();
        outPutView.MymoneyPrint();
        outPutView.countLotto();
        // 모든 로또 출력
        int lottoCount=PurchasePrice.myMoneyCount();
        List<Lotto> randomLotto= LottoGenerator.generate(lottoCount);
        Lottos lottos=new Lottos(randomLotto);

        outPutView.TotalLottoPrint(lottos);
        // 당첨번호 입력
        String userInput= InputView.userInput();

        WinnerGenerator winnerGenerator=new WinnerGenerator(userInput);

        String bounsBall=InputView.bonusBall();
        // 보너스볼 입력
        BounsBall bounsBall1=new BounsBall(bounsBall);
    }

}
