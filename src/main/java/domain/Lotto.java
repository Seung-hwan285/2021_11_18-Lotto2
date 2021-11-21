package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.MatchResult;

public class Lotto {

    /**
     *    로또 한줄씩 관리
     *    [] 로또 한줄  당첨번호 비교
     *    [] 일치하는 당첨번호 몇개인지 찾기
     *
     *
     */


    private static final int FIVE_MATCH=5;
    private static final int LOTTO_NUMBERS_COUNT =6;
    private static final int WINNING_NUMBERS_COUNT=6;
    private static List<Integer> lottoList=new ArrayList<>();


    public Lotto(List<Integer> lottoOneLine){
        this.lottoList=lottoOneLine;
    }


    public List<Integer> getLottoList() {
        return lottoList;
    }


    // [] 일치하는 당첨번호 몇개인지 찾기
    public MatchResultEunm findMatchResult (WinnerGenerator winnerGenerator,BounsBall bounsBall){

        int sameCount=calculateSameNumberCount(winnerGenerator);
        // 5개 맞추거나 , 보너스볼이 생성된 로또에 있으면 -> FIVE_MATC_BOUNUSBALL
        if(sameCount ==FIVE_MATCH && bounsBall.isIncluded(lottoList)){
            return MatchResultEunm.FIVE_MATC_BOUNUSBALL;
        }

        return MatchResultEunm.of(sameCount);
    }


    // [] 로또 한줄  당첨번호 비교
    public static int calculateSameNumberCount(WinnerGenerator winnerGenerator){
        // 생성된 로또 한줄 중복제거
        Set<Integer> numbers = new HashSet<>(lottoList);

        // 로또 한줄 + 당첨번호
        numbers.addAll(winnerGenerator.getWinngNumbers());


        int diffrentSize=numbers.size();




        return LOTTO_NUMBERS_COUNT+WINNING_NUMBERS_COUNT-diffrentSize;
    }



    public static List<Integer> getResult() {
        return lottoList;
    }
}
