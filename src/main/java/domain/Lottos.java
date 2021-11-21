package domain;

import javax.swing.plaf.BorderUIResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    /**
     * 구입한 모든 로또 관리
     * [] 로또 여러줄 과 당첨번호 비교
     * [] enum 값 미리 초기화해서 넣기
     * [] 로또 여러줄 당첨번호 비교
     * [] 로또 결과값 세팅
     */

    private List<Lotto> lottosList=new ArrayList<>();


    public Lottos(final List<Lotto> lottos){

        this.lottosList=lottos;

    }

    // [] 로또 여러줄 과 당첨번호 비교
    public Map<MatchResultEunm, Integer> createMatchResults(WinnerGenerator winningNumbers, BounsBall bonusNumber) {

        Map<MatchResultEunm, Integer> matchResults = setUpMatchResults();


        for (Lotto lotto : lottosList) {

            MatchResultEunm lottoMatchResult = lotto.findMatchResultNumber(winningNumbers, bonusNumber);
            int matchCount = matchResults.get(lottoMatchResult);
            matchResults.put(lottoMatchResult, ++matchCount);
        }
        return matchResults;
    }


    // [] 로또 결과값 세팅
    private Map<MatchResultEunm, Integer> setUpMatchResults() {
        Map<MatchResultEunm, Integer> matchResults = new HashMap<>();

        MatchResultEunm matchResultEunm[]=MatchResultEunm.values();
        for(MatchResultEunm m: matchResultEunm){

            // key : THREE_MATCH , value : 0
            // key : FOUNT_MATCH , value : 0
            matchResults.put(m,0);
        }
        return matchResults;
    }
    public List<Lotto> getLottosList() {


        return lottosList;
    }
}