package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    /**
     * 구입한 모든 로또 관리
     */

    private List<Lotto> lottosList=new ArrayList<>();


    public Lottos(final int count){

        for(int i=0; i<count; i++){
            lottosList.add(LottoGenerator.generate());
        }

    }

    public List<Lotto> getLottosList() {


        return lottosList;
    }
}
