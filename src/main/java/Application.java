import virew.InputView;
import virew.outPutView;

public class Application {

    public static void main(String[] args) {


        outPutView outPutView=new outPutView();
        // 구입 금액 출력
        outPutView.MymoneyPrint();

        //로또 개수 출력
        outPutView.countLotto();
    }
}
