import domain.*;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;
import java.util.regex.MatchResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


public class MatchTest {

    private List<Lotto> lottos;
    private WinnerGenerator winnerGenerator;
    private BounsBall bounsBall;
    @BeforeEach
    void 초기(){

        lottos=new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)));



        winnerGenerator = new WinnerGenerator("1,2,3,4,5,7");

        bounsBall=new BounsBall("15");

    }

    @DisplayName("로또 한줄 당첨번호와 비교해서 결과를 반환하는 테스트")
    @Test
    void findMatchResultTest(){
        assertThat(lottos.get(0).findMatchResultNumber(winnerGenerator,bounsBall)).isEqualTo(MatchResultEunm.THREE_MATCH);
    }



    @DisplayName("생성된 로또들 당첨번호 비교했을때 결과를 반환하는 테스트")
    @Test
    void createMatchResultTest(){
        Lottos lottos=new Lottos(this.lottos);
        Map<MatchResultEunm,Integer> integerMap=lottos.createMatchResults(winnerGenerator,bounsBall);

        Map<MatchResultEunm,Integer> expected=new HashMap<>();


        expected.put(MatchResultEunm.THREE_MATCH,1);
        expected.put(MatchResultEunm.FOUR_MATCH, 0);
        expected.put(MatchResultEunm.FIVE_MATCH, 0);
        expected.put(MatchResultEunm.FIVE_BOUNSE_BALL, 0);
        expected.put(MatchResultEunm.SIX_MATCH, 0);


        assertThat(expected).isEqualTo(integerMap);
    }

}
