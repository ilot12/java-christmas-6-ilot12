package view;

import java.text.NumberFormat;

import charge.Badge;
import charge.Charge;
import decemberdate.DecemberDate;
import menu.MenuItem;
import menu.Menus;
public class OutputView {
    
    public static void initialMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    
    public static void benefitMessage(DecemberDate decemberDate, Menus menus, Charge charge) {
        System.out.print("12월 ");
        System.out.print(decemberDate.getDate());
        System.out.println("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        
        System.out.println();
        printMenus(menus);
        
        System.out.println();
        printChargeBeforeDiscount(charge.getTotalChargeBeforeDiscount());

        System.out.println();
        printGiftChampagne(charge.isChampagneFree());

        System.out.println();
        printEachDiscount(decemberDate, charge);

        System.out.println();
        printTotalDiscountPlusChampagne(charge.getTotalDiscountPlusChampagne());
        
        System.out.println();
        printTotalChargeAfterDiscount(charge.getTotalChargeAfterDiscount());
        
        System.out.println();
        printBadge(charge.getBadge());
    }
    
    private static void printMenus(Menus menus) {
        System.out.println("<주문 메뉴>");
        for (MenuItem menuItem : menus.getMenus().keySet()) {
            int count = menus.getMenus().get(menuItem);
            printOneMenu(menuItem, count);
        }
    }
    
    private static void printOneMenu(MenuItem menuItem, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(menuItem.getName());
        sb.append(" ");
        sb.append(count);
        sb.append("개");
        System.out.println(sb.toString());
    }
    
    private static String formatCharge(int charge) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(charge);
    }
    
    private static void printChargeBeforeDiscount(int totalChargeBeforeDiscount) {
        System.out.println("<할인 전 총주문 금액>");
        StringBuilder sb = new StringBuilder();
        sb.append(formatCharge(totalChargeBeforeDiscount));
        sb.append("원");
        System.out.println(sb.toString());
    }
    
    private static void printGiftChampagne(boolean isChampagneFree) {
        System.out.println("<증정 메뉴>");
        if (isChampagneFree) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }
    
    private static void printEachDiscount(DecemberDate decemberDate, Charge charge) {
        System.out.println("<혜택 내역>");
        printDDayDiscount(charge.getDDayDiscount());
        printWeekDiscount(decemberDate, charge);
        printStarDayDiscount(charge.getStarDayDiscount());
        printGiftChampagneDiscount(charge.isChampagneFree());
        if (charge.getTotalDiscount() == 0) {
            System.out.println("없음");
        }
    }
    
    private static void printDDayDiscount(int dDayDiscount) {
        if (dDayDiscount == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("크리스마스 디데이 할인: ");
        sb.append(formatCharge(-dDayDiscount));
        sb.append("원");
        System.out.println(sb.toString());
    }
    
    private static void printWeekDiscount(DecemberDate decemberDate, Charge charge) {
        if (charge.getWeekDiscount() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (decemberDate.isWeekend()) {
            sb.append("주말 할인: ");            
        }
        if (!decemberDate.isWeekend()) {
            sb.append("평일 할인: ");            
        }
        sb.append(formatCharge(-charge.getWeekDiscount()));
        sb.append("원");
        System.out.println(sb.toString());
    }
    
    private static void printStarDayDiscount(int starDayDiscount) {
        if (starDayDiscount == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("특별 할인: ");
        sb.append(formatCharge(-starDayDiscount));
        sb.append("원");
        System.out.println(sb.toString());
    }
    
    private static void printGiftChampagneDiscount(boolean isChampagneFree) {
        if (!isChampagneFree) {
            return;
        }
        System.out.println("증정 이벤트: -25,000원");
    }
    
    private static void printTotalDiscountPlusChampagne(int totalDiscountPlusChampagne) {
        System.out.println("<총혜택 금액>");
        StringBuilder sb = new StringBuilder();
        sb.append(formatCharge(-totalDiscountPlusChampagne));
        sb.append("원");
        System.out.println(sb.toString());
    }
    
    private static void printTotalChargeAfterDiscount(int totalChargeAfterDiscount) {
        System.out.println("<할인 후 예상 결제 금액>");
        StringBuilder sb = new StringBuilder();
        sb.append(formatCharge(totalChargeAfterDiscount));
        sb.append("원");
        System.out.println(sb.toString());
    }
    
    private static void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.getSymbol());
    }
}
