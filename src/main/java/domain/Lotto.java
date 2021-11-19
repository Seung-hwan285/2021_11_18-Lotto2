package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    /**
     * 로또 한줄씩 관리
     */

    private List<Integer> lottoList=new ArrayList<>();


    public Lotto(List<Integer> lottoOneLine){
        this.lottoList=lottoOneLine;
    }


    public List<Integer> getLottoList() {
        return lottoList;
    }
}
