package order;


import java.util.Map;
import charge.Charge;
import decemberdate.DecemberDate;
import menu.MenuItem;
import menu.Menus;
import view.InputView;
import view.OutputView;

public class Order {
    
    DecemberDate decemberDate;
    Menus menus;
    Charge charge;
    
    public Order(){
        OutputView.initialMessage();
        while(true) {
            try {
                decemberDate = new DecemberDate(InputView.readDate());
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        while(true) {
            try {
                menus = new Menus(InputView.readMenuItems());
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        charge = new Charge(decemberDate, menus);
    }
    
    public void printOrder() {
        OutputView.benefitMessage(decemberDate, menus, charge);
    }
    
    public DecemberDate getDecemberDate() {
        return this.decemberDate;
    }
    
    public Map<MenuItem, Integer> getMenus() {
        return this.menus.getMenus();
    }
    
    public Charge getCharge() {
        return this.charge;
    }
}
