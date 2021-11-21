package domain;

import java.util.Arrays;

public enum MatchResultEunm {


    THREE_MATCH(3,5_000),
    FOUR_MATCH(4,50_000),
    FIVE_MATCH(5,1_500_500),
    FIVE_MATC_BOUNUSBALL(6,30_000_000),
    SIX_MATCH(6,2_000_000_000);


    private int matchCount;
    private int price;

    MatchResultEunm(int matchCount,int price){
        this.matchCount=matchCount;
        this.price=price;
    }

    static MatchResultEunm of(int matchCount){
        return Arrays.stream(values())
                .filter(v -> matchCount ==v.matchCount)
                .findFirst()
                .orElseThrow(()->new IllegalStateException("일치하는 당첨결과 없습니다."));
    }

    public int getMatchCount() {
        return matchCount;
    }
    public int getPrice(){
        return getPrice();
    }

}
