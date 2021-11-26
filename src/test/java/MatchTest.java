import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class MatchTest {

    private List<Lotto> lottos;
    private WinnerGenerator winnerGenerator;
    private BounsBall bounsBall;
    private Map<MatchResultEunm,Integer> ex;
    @BeforeEach
    void 초기(){

        lottos=new ArrayList<>();

        lottos.add(new Lotto(Arrays.asList(1,2,3,8,9,20)));
//        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));

        winnerGenerator=new WinnerGenerator("1,2,3,8,9,10");
        bounsBall=new BounsBall("43");

        ex=new HashMap<>();


        // 가격 1로 초기화 0으로하면 곱할수없음
        ex.put(MatchResultEunm.THREE_MATCH,1);
        ex.put(MatchResultEunm.FOUR_MATCH,1);
        ex.put(MatchResultEunm.FIVE_MATCH,1);
        ex.put(MatchResultEunm.FIVE_BOUNSE_BALL,1);
        ex.put(MatchResultEunm.SIX_MATCH,1);




    }

    @DisplayName("로또 한줄 당첨번호와 비교해서 결과를 반환하는 테스트")
    @Test
    void findMatchResultTest(){
        //assertThat(lottos.get(0).findMatchResultNumber(winnerGenerator,bounsBall)).isEqualTo(MatchResultEunm.THREE_MATCH);
        assertThat(lottos.get(0).findMatchResultNumber(winnerGenerator,bounsBall)).isEqualTo(MatchResultEunm.FIVE_MATCH);
    }



    @DisplayName("생성된 로또들 당첨번호 비교했을때 결과를 반환하는 테스트")
    @Test
    void createMatchResultTest(){
        Lottos lottos1=new Lottos(this.lottos);

        Map<MatchResultEunm,Integer> matchResultEunm=lottos1.createMatchResults(winnerGenerator,bounsBall);



        ex.put(MatchResultEunm.THREE_MATCH,1);
        ex.put(MatchResultEunm.FOUR_MATCH,0);
        ex.put(MatchResultEunm.FIVE_MATCH,0);
        ex.put(MatchResultEunm.FIVE_BOUNSE_BALL,0);
        ex.put(MatchResultEunm.SIX_MATCH,0);


        assertThat(matchResultEunm).isEqualTo(ex);
    }

    @DisplayName("로또 올바른 수익률 반환하는지")
    @Test
    void calculateEarning(){

        LottoResult lottoResult=new LottoResult(ex);
        int earn= lottoResult.calculateEngin(new PurchasePrice("5000"));
        assertThat(earn).isEqualTo(40_631_100);

    }


}
