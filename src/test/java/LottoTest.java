import domain.LottoGenerator;
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

public class LottoTest {


    private List<Integer> makeTestList(){
        List<Integer> test=new ArrayList<>();
        for(int i=1; i<=45; i++){
            test.add(i);
        }
        return test;
    }
    private List<Integer>makeTestList2(){
        List<Integer> test=new ArrayList<>();
        for(int i=1; i<=6; i++)
        {
            test.add(i);
        }
        return test;
    }

    @DisplayName("로또 초기화 1~45")
    @Test
    void lottoGeneratorTest(){

        List<Integer> lottoList=new LottoGenerator().lotto();
        List<Integer> test=makeTestList();
        Assertions.assertEquals(test,lottoList);
    }

    @DisplayName("로또 6개 값")
    @Test
    void sixNumberTest(){
        List<Integer> test=makeTestList2();
//        Assertions.assertEquals(test,new LottoGenerator().lottoOneLine());
    }
}
