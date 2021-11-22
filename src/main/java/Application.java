import Controller.LottoController;
import domain.*;
import virew.InputView;
import virew.outPutView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Application {

    static final Logger log=Logger.getLogger(String.valueOf(Application.class));

    public static void main(String[] args) {

        LottoController lottoController=new LottoController();


        int lottoCount= PurchasePrice.myMoneyCount();

        lottoController.run();


        // 모든 로또 출력
        //
        //
        List<Lotto> randomLotto=LottoGenerator.generate(lottoCount);

        randomLotto.stream()
                .forEach(v-> System.out.println(v.getLottoList()));


//        Lottos lottos=new Lottos(randomLotajsto);
//
//
//        outPutView.TotalLottoPrint(lottos);

//        // 당첨번호 입력
//        String userInput=InputView.userInput();
//
//        WinnerGenerator winnerGenerator=new WinnerGenerator(userInput);
//
//        String bounsInput =InputView.bonusBall();
//        BounsBall bounsBall=new BounsBall(bounsInput);



    }
}