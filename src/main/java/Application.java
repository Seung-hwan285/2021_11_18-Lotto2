import Controller.LottoController;
import domain.*;
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



    }
}