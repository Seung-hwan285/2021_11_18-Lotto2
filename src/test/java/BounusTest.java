import domain.BounsBall;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;
import java.util.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.Assertions.*;

public class BounusTest {


    @DisplayName("숫자가 아닌 다른타입")
    @ParameterizedTest
    @ValueSource(strings = {"a,~,!"})
    void otherTypeTest(String input){
        assertThatThrownBy(()->new BounsBall(input))
                .hasMessage("숫자가 아닌 다른 타입입니다.");
    }

    @DisplayName("1~45")
    @ParameterizedTest
    @ValueSource(strings = {"0","46"})
    void numberLimitTest(String input){
        assertThatThrownBy(() -> new BounsBall(input))
                .hasMessage("1~45숫자만 입력해주세요");
    }


}
