package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    /**
     * 구입한 모든 로또 관리
     */

    private List<Lotto> lottos=new ArrayList<>();

    public Lottos(final int count){

        for(int i=0; i<count; i++){
            lottos.add(LottoGenerator.generate());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
