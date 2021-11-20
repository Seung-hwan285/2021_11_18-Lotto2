package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    /**
     *    로또 한줄씩 관리
     *    [] 로또 한줄  == 당첨 번호 비교
     *    [] 결과 반환
     */

    private static List<Integer> lottoList=new ArrayList<>();

    private static List<Integer> result=new ArrayList<>();

    public Lotto(List<Integer> lottoOneLine){
        this.lottoList=lottoOneLine;
    }


    public List<Integer> getLottoList() {
        return lottoList;
    }


    // [] 로또 한줄  == 당첨 번호 비교
    public static List<Integer> oneLineLottoeEulas(WinnerGenerator winnerGenerator){
        for(int lotto: lottoList){
            for(int winngerLotto: winnerGenerator.getWinngNumbers()){
                if(lotto == winngerLotto){
                    result.add(lotto);
                }
            }
        }
        return result;
    }

    public static List<Integer> getResult() {
        return result;
    }
}
