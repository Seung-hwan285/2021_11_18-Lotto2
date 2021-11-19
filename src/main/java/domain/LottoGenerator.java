package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {


    /**
     *   [] 구입한 로또 개수만큼 lotto 객체 생성
     *      - 1~45로 로또 초기화
     */

    private static final  int MIN=1;
    private static final  int MAX=45;


    private static List<Integer> lottoList=new ArrayList<Integer>();

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
