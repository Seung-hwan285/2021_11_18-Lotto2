package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    /**
     *    로또 한줄씩 관리
     *    [] 로또 한줄  == 당첨 번호 비교
     *    [] 결과 반환
     */

    private static List<Integer> lottoList=new ArrayList<>();


    public Lotto(List<Integer> lottoOneLine){
        this.lottoList=lottoOneLine;
    }


    public List<Integer> getLottoList() {
        return lottoList;
    }


    public static int calculateSameNumberCount(WinnerGenerator winnerGenerator){
        // 생성된 로또 한줄 중복제거
        Set<Integer> numbers = new HashSet<>(lottoList);

        // 로또 한줄 + 당첨번호
        numbers.addAll(winnerGenerator.getWinngNumbers());


        int diffrentSize=numbers.size();

        return diffrentSize;
    }



    public static List<Integer> getResult() {
        return lottoList;
    }
}
