import Controller.LottoController;
import domain.Lottos;
import domain.PurchasePrice;
import virew.InputView;
import virew.outPutView;

public class Application {

    public static void main(String[] args) {

        LottoController lottoController=new LottoController();


        int lottoCount= PurchasePrice.myMoneyCount();

        lottoController.run();

        Lottos lottos=new Lottos(lottoCount);
        outPutView.TotalLottoPrint(lottos);
    }
}
