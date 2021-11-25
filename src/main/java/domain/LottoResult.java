package domain;

import java.util.Map;

public class LottoResult {
    /**
     *  [] 당첨 결과 반환
     *     - 수익률 계산
     */

    private final Map<MatchResultEunm,Integer> lottoList;


    public LottoResult(Map<MatchResultEunm,Integer> lottoList){
        this.lottoList=lottoList;
    }


    public  int calculateEngin(PurchasePrice purchasePrice){
        double total=0;
        MatchResultEunm []matchResultEunms=MatchResultEunm.values();

        for(MatchResultEunm matchResultEunm : matchResultEunms){
            // 요소 뽑아오고
            total+= matchResultEunm.getPrice();
        }

        return (int) Math.round(total/purchasePrice.getMyMoney() *100);
    }

    public  Map<MatchResultEunm,Integer> getlotto(){
        return lottoList;
    }
}
