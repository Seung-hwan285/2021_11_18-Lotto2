import domain.PurchasePrice;
import domain.WinnerGenerator;
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

public class WinnerTest {


    @DisplayName("당첨번호 null")
    @ParameterizedTest
    @NullAndEmptySource
    void numberNullEmptyTest(String input){

        assertThatThrownBy(()->new WinnerGenerator(input))
                .hasMessage("당첨 번호를 입력하지 않으셨습니다.");

    }


    @DisplayName("당첨번호 구분자 예외")
    @ParameterizedTest
    @ValueSource(strings = {"1.2","1/3","1-3","123"})
    void separatorTest(String input){

        assertThatThrownBy(()->new WinnerGenerator(input))
                .hasMessage("당첨번호는 나누어서 입력해주세요");

    }


    @DisplayName("숫자 6개 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5","1,2,3"})
    void numberLengthTest(String input){
        assertThatThrownBy(()->new WinnerGenerator(input))
                .hasMessage("숫자 6개 입력해주세요");

        
    }
    @DisplayName("숫자가 아닌 다른 타입")
    @ParameterizedTest
    @ValueSource(strings = {"a,b","*,1"})
    void otherTypeTest(String input){
        assertThatThrownBy(()->new WinnerGenerator(input))
                .hasMessage("숫자가 아닌 다른 타입입니다.");
    }


    @DisplayName("숫자 1~45만 입력")
    @ParameterizedTest
    @ValueSource(strings = {"0,46,2,3,4,5"})
    void numbersLimit(String input){
        assertThatThrownBy(()->new WinnerGenerator(input))
                .hasMessage("1~45 만 입력해주세요");
    }


}
