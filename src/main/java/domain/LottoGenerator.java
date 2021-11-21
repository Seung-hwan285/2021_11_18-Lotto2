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


    // - 로또 번호 섞고 한줄씩 출력
    public static List<Integer> shuffleLottoSixNumberLotto(){
        List<Integer> clneAllottoList=new ArrayList<>(lottoList);
        Collections.shuffle(clneAllottoList);

        List<Integer> oneLotto=new ArrayList<>();
        oneLotto=sixNumbers(clneAllottoList);
        return oneLotto;
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



    // Lotto 리스트 변환
    public static List<Lotto> generate(int count) {
        List<Lotto> ranmdomLotto =new ArrayList<>();

        for(int i=0; i< count; i++){
            System.out.println("로또 생성");
            ranmdomLotto.add(new Lotto(shuffleLottoSixNumberLotto()));
        }
        return ranmdomLotto;
    }
}