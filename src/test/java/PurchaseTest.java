import domain.PurchasePrice;
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

public class PurchaseTest {


    @DisplayName("숫자가아닌 다른 타입")
    @ParameterizedTest
    @ValueSource(strings = {"d","#"})
    void TyepTest(String input){
        assertThatThrownBy(()-> new PurchasePrice(input))
                .hasMessage("숫자만 입력해주세요");
    }

    @DisplayName("1000원제한")
    @ParameterizedTest
    @ValueSource(strings = {"900"})
    void limitTest(String input)
    {
        assertThatThrownBy(()->new PurchasePrice(input))
                .hasMessage("1000원 이상만 지불하세요");
    }

    @DisplayName("입력값 안들어올때 ")
    @ParameterizedTest
    @NullSource
    void emptyNullTest(String input){
     assertThatThrownBy(()->new PurchasePrice(input))
     .hasMessage("null");
    }
}
