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
public class PurchaseTest {


    @DisplayName("숫자가아닌 다른 타입")
    @ParameterizedTest
    @ValueSource(strings = {"d","#"})
    void TyepTest(String input){
        AssertionsForClassTypes.assertThatThrownBy(()-> new PurchasePrice(input))
                .hasMessage("숫자만 입력해주세요");



    }
}
