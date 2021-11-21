package domain;

import java.util.Arrays;

public enum MatchResultEunm {


    THREE_MATCH(3,5_000),
    FOUR_MATCH(4,50_000),
    FIVE_MATCH(5,1_500_000),
    FIVE_BOUNSE_BALL(6,30_000_000),
    SIX_MATCH(6,2_000_000_000);


    private int countMatch;
    private int price;

    MatchResultEunm(int countMatch, int price) {
        this.countMatch = countMatch;
        this.price = price;
    }

    static MatchResultEunm of(int countMatch){
        return Arrays.stream(values())
                .filter(v-> countMatch==v.countMatch)
                .findAny()
                .orElseThrow(()->new IllegalStateException("당첨번호와 같은 값이 없습니다."));

    }

    public int getCountMatch() {
        return countMatch;
    }

    public int getPrice() {
        return price;
    }
}
