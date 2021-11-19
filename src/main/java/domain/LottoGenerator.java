package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LottoGenerator {


    /**
     *   [] 구입한 로또 개수만큼 lotto 객체 생성
     *      - 1~45로 로또 초기화
     *   [] 로또 한줄씩 출력
     *      - 6개씩 뽑기
     *      - 로또 번호 섞기
     */

    private static final  int MIN=1;
    private static final  int MAX=45;


    private static List<Integer> lottoList=new ArrayList<Integer>();

    // 1~45 초기화
    static {
        lottoList=lotto();
    }

    // [] 로또 한줄씩 출력
    public  static List<Integer>lottoOneLine(){

        List<Integer> resultLotto=new ArrayList<>();

        List<Integer> result=new ArrayList<>();


            for (int i = 0; i < lottoList.size(); i++) {
                resultLotto.add(lottoList.get(i));
            }

        shuffleLotto(resultLotto);
        result=sixNumbers(resultLotto);

        return result;
    }
    // - 로또 번호 섞기
    public static void shuffleLotto(List<Integer> lottoList){

        Collections.shuffle(lottoList);

    }

    // - 6개씩 뽑기
    public static List<Integer> sixNumbers(List<Integer> lottoList){
        List<Integer> six=new ArrayList<>();
        for(int i=0; i<6; i++){
            six.add(lottoList.get(i));
        }
        return six;

    }

    // - 1~45로 로또 초기화
    public static List<Integer> lotto(){

        for(int i=MIN; i<= MAX; i++){
            lottoList.add(i);
        }
        return lottoList;
    }


    public static List<Integer> getLottoList() {
        return lottoList;
    }
}
