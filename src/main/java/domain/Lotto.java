package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    /**
     *    로또 한줄씩 관리
     *    [] 로또 한줄  당첨번호 몇개가 같은지 비교
     *    [] 일치하는 당첨번호 몇개인지 찾기
     *
     *
     */


    private static final int FIVE_MATCH=5;
    private static final int LOTTO_NUMBERS_COUNT =6;
    private static final int WINNING_NUMBERS_COUNT=6;

    private static final int TOTAL_COUNT= LOTTO_NUMBERS_COUNT+WINNING_NUMBERS_COUNT;


    private final List<Integer> lottoList;


    public Lotto(List<Integer> lottoOneLine){
        lottoList=lottoOneLine;
    }


    public List<Integer> getLottoList() {
        return lottoList;
    }


    // [] 일치하는 당첨번호 몇개인지 찾기
    public MatchResultEunm findMatchResultNumber(WinnerGenerator winnerGenerator,BounsBall bounsBall){

        int sameCountNumber=sameCountLotto(winnerGenerator);

        if(sameCountNumber==FIVE_MATCH && bounsBall.checkisInclude(lottoList)){
            return MatchResultEunm.FIVE_BOUNSE_BALL;
        }

        return MatchResultEunm.of(sameCountNumber);
    }


    // [] 로또 한줄  당첨번호 몇개가 같은지 비교
    private int sameCountLotto(WinnerGenerator winnerGenerator){
        Set<Integer> oneLineLotto=new HashSet<>(this.lottoList);

        // 중첩제거한 한줄 로또 + 당첨번호
        oneLineLotto.addAll(winnerGenerator.getWinngNumbers());

        return TOTAL_COUNT-oneLineLotto.size();
    }

    public List<Integer> getResult() {
        return  lottoList;
    }
}