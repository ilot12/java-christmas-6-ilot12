package charge;

import decemberdate.DecemberDate;
import menu.MenuItem;
import menu.Menus;

public class Charge {
    
    private final int DISCOUNT_PER_MENU = 2023;
    private final int DISCOUNT_STAR_DAY = 1000;
    private final int CHAMPAGNE_FREE_MINIMUM = 120000;
    private final int DISCOUNT_MINUMUN = 10000;
    private Menus menus;
    private DecemberDate decemberDate;
    private int totalChargeBeforeDiscount;
    private boolean isChampagneFree = false;
    private int dDayDiscount = 0;
    private int weekDiscount = 0;
    private int starDayDiscount = 0;
    private int totalDiscount = 0;
    private int totalDiscountPlusChampagne = 0;
    private int totalChargeAfterDiscount;
    private Badge badge;
    
    public Charge(DecemberDate decemberDate, Menus menus) {
        this.menus = menus;
        this.decemberDate = decemberDate;
        calculateTotalChargeBeforeDiscount();
        if (doesDiscountApply()) {
            calculateIsChampagneFree();
            calculateDDayDiscount();
            calculateWeekDiscount();
            calculateStarDayDiscount();            
        }
        calculateTotalDiscount();
        calcluateTotalChargeAfterDiscount();
        badge = new Badge(totalDiscountPlusChampagne);
    }
    
    private void calculateTotalChargeBeforeDiscount() {
        int sum = 0;
        for (MenuItem menuItem : menus.getMenus().keySet()) {
            int temporarySum = menuItem.getPrice() * menus.getMenus().get(menuItem);
            sum += temporarySum;
        }
        totalChargeBeforeDiscount = sum;
    }
    
    private boolean doesDiscountApply() {
        if (totalChargeBeforeDiscount >= DISCOUNT_MINUMUN) {
            return true;
        }
        return false;
    }
    
    private void calculateDDayDiscount() {
        int date = decemberDate.getDate();
        dDayDiscount = 1000;
        if (date > 25) {
            dDayDiscount = 0;
            return;
        }
        dDayDiscount += (100 * (date - 1));
    }
    
    private void calculateWeekDiscount() {
        boolean isWeekend = decemberDate.isWeekend();
        if (!isWeekend) {
            weekDiscount = (menus.getCategoryCount().get("디저트") * DISCOUNT_PER_MENU);
        }
        if (isWeekend) {
            weekDiscount = (menus.getCategoryCount().get("메인") * DISCOUNT_PER_MENU);
        }
    }
    
    private void calculateStarDayDiscount() {
        if (decemberDate.isStarDay()) {
            starDayDiscount = DISCOUNT_STAR_DAY;
        }
    }
    
    private void calculateTotalDiscount() {
        totalDiscount = dDayDiscount + weekDiscount + starDayDiscount;
        totalDiscountPlusChampagne = totalDiscount;
        if (isChampagneFree) {
            totalDiscountPlusChampagne += 25000;
        }
    }
    
    private void calcluateTotalChargeAfterDiscount() {
        totalChargeAfterDiscount = totalChargeBeforeDiscount - totalDiscount;
    }
    
    private void calculateIsChampagneFree() {
        if (totalChargeBeforeDiscount > CHAMPAGNE_FREE_MINIMUM) {
            isChampagneFree = true;
            return;
        }
        isChampagneFree = false;
    }
    
    public int getTotalChargeBeforeDiscount() {
        return this.totalChargeBeforeDiscount;
    }
    
    public boolean isChampagneFree() {
        return this.isChampagneFree;
    }
    
    public int getDDayDiscount() {
        return this.dDayDiscount;
    }
    
    public int getWeekDiscount() {
        return this.weekDiscount;
    }
    
    public int getStarDayDiscount() {
        return this.starDayDiscount;
    }
    
    public int getTotalDiscount() {
        return this.totalDiscount;
    }
    
    public int getTotalDiscountPlusChampagne() {
        return this.totalDiscountPlusChampagne;
    }
    
    public int getTotalChargeAfterDiscount() {
        return this.totalChargeAfterDiscount;
    }
    
    public Badge getBadge() {
        return this.badge;
    }
    
}
