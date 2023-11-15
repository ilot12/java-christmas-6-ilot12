package charge;

public class Badge {

    private String symbol;
    
    private final int SANTA_MINIMUM = 20000;
    private final int TREE_MINIMUM = 10000;
    private final int STAR_MINIMUM = 5000;
    
    Badge(int totalDiscount){
        updateSymbol(totalDiscount);
    }

    private void updateSymbol(int totalDiscount) {
        if(totalDiscount >= SANTA_MINIMUM) {
            symbol = "산타";
            return;
        }
        if(totalDiscount >= TREE_MINIMUM) {
            symbol = "트리";
            return;
        }
        if(totalDiscount >= STAR_MINIMUM) {
            symbol = "별";
            return;
        }
        symbol = "없음";
    }
    
    public String getSymbol() {
        return this.symbol;
    }
}
