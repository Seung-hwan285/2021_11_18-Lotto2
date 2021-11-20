import Controller.LottoController;
import domain.BounsBall;
import domain.Lottos;
import domain.PurchasePrice;
import domain.WinnerGenerator;
import virew.InputView;
import virew.outPutView;

public class Application {

    public static void main(String[] args) {

        LottoController lottoController=new LottoController();


        int lottoCount= PurchasePrice.myMoneyCount();

        lottoController.run();

        // 모든 로또 출력
        Lottos lottos=new Lottos(lottoCount);
        outPutView.TotalLottoPrint(lottos);

        // 당첨번호 입력
        String userInput=new InputView().userInput();

        // 당첨번호 입력
        outPutView.WinnerPrint(userInput);
        WinnerGenerator winnerGenerator=new WinnerGenerator(userInput);

        //보너스볼
        String bouns=InputView.bonusBall();
        BounsBall bounsBall=new BounsBall(bouns);

        outPutView.BounsBall(bouns);


        outPutView.oneLineResult(winnerGenerator);


    }
}
