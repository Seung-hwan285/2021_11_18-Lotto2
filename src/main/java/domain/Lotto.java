package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {


    private List<Integer> lottoList=new ArrayList<>();


    public Lotto(){
        this.lottoList=new LottoGenerator().lottoOneLine();
    }


    public List<Integer> getLottoList() {
        return lottoList;
    }
}
