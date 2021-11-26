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






    }
}