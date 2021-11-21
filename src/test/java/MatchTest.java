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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
public class MatchTest {

    private List<Lotto> lotto;

    private WinnerGenerator winnerGenerator;
    private BounsBall bounsBall;
    @BeforeEach
    void 로또생성(){
        lotto=new ArrayList<>();
        lotto.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));


        winnerGenerator=new WinnerGenerator("1,2,3,9,8,7");
        bounsBall=new BounsBall("10");
    }


    @DisplayName("로또 한줄 당첨번호와 비교해서 결과를 반환하는 테스트")
    @Test
    void findMatchResultTest(){
        assertThat(lotto.get(0).findMatchResult(winnerGenerator,bounsBall)).isEqualTo(MatchResultEunm.THREE_MATCH);
    }
}
