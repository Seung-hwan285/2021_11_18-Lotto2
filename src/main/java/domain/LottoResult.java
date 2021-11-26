package domain;

import java.util.Map;

public class LottoResult {
    /**
     *  [] 수익률 계산
     *      -공식 ( 모든 로또 당첨금약 / 금액 *100)
     */

    private final Map<MatchResultEunm,Integer> lottoList;


    public LottoResult(Map<MatchResultEunm,Integer> lottoList){
        this.lottoList=lottoList;
    }


    // [] 수익률 계산
    public  int calculateEngin(PurchasePrice purchasePrice){
        double total=0;
        // enum 모든 값 가지고옴
        MatchResultEunm []matchResultEunms=MatchResultEunm.values();

        for(MatchResultEunm matchResultEunm : matchResultEunms){
            // 모든 당첨금액 계산
            total+= matchResultEunm.getPrice();
        }
        // -공식 ( 모든 로또 당첨금약 / 금액 *100)
        int money=(int) Math.round(total/purchasePrice.getMyMoney() *100);

        return money;
    }

}