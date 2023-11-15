package chargeTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import charge.Charge;
import decemberdate.DecemberDate;
import menu.Menus;

public class chargeTest {
    
    @Test
    void firstTest() {
        DecemberDate decemberDate = new DecemberDate("26");
        Menus menus = new Menus("타파스-1,제로콜라-1");
        Charge charge = new Charge(decemberDate, menus);
        
        assertEquals(8500, charge.getTotalChargeBeforeDiscount());
        assertEquals(false, charge.isChampagneFree());
        
        assertEquals(0, charge.getDDayDiscount());
        assertEquals(0, charge.getWeekDiscount());
        assertEquals(0, charge.getStarDayDiscount());
        assertEquals(false, charge.isChampagneFree());
        
        assertEquals(0, charge.getTotalDiscountPlusChampagne());
        assertEquals(8500,charge.getTotalChargeAfterDiscount());
        assertEquals("없음", charge.getBadge().getSymbol());
        
    }
    
    @Test
    void secondTest() {
        DecemberDate decemberDate = new DecemberDate("3");
        Menus menus = new Menus("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Charge charge = new Charge(decemberDate, menus);
        assertEquals(142000, charge.getTotalChargeBeforeDiscount());
        assertEquals(true, charge.isChampagneFree());
        
        assertEquals(1200, charge.getDDayDiscount());
        assertEquals(4046, charge.getWeekDiscount());
        assertEquals(1000, charge.getStarDayDiscount());
        assertEquals(true, charge.isChampagneFree());
        
        assertEquals(31246, charge.getTotalDiscountPlusChampagne());
        assertEquals(135754,charge.getTotalChargeAfterDiscount());
        assertEquals("산타", charge.getBadge().getSymbol());
    }
    
    @Test
    void thirdTest() {
        DecemberDate decemberDate = new DecemberDate("25");
        Menus menus = new Menus("양송이수프-2,티본스테이크-1,해산물파스타-1,아이스크림-1,제로콜라-2");
        Charge charge = new Charge(decemberDate, menus);
        assertEquals(113000, charge.getTotalChargeBeforeDiscount());
        assertEquals(false, charge.isChampagneFree());
        
        assertEquals(3400, charge.getDDayDiscount());
        assertEquals(2023, charge.getWeekDiscount());
        assertEquals(1000, charge.getStarDayDiscount());
        assertEquals(false, charge.isChampagneFree());
        
        assertEquals(6423, charge.getTotalDiscountPlusChampagne());
        assertEquals(106577,charge.getTotalChargeAfterDiscount());
        assertEquals("별", charge.getBadge().getSymbol());
    }
    
}
