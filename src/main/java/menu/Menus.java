package menu;

import java.util.Map;

public class Menus {
    
    private Map<MenuItem, Integer> menus;
    private MenusInfo menusInfo = new MenusInfo();
    
    public Menus(String menusText) throws IllegalArgumentException {
        validateMenusTextNotEmpty(menusText);
        String[] eachMenus = menusText.split(",");
        for (String eachMenu : eachMenus) {
            updateEachMenuText(eachMenu);
        }
    }
    
    private void validateMenusTextNotEmpty(String menusText) throws IllegalArgumentException {
        if (menusText.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    
    private void updateEachMenuText(String eachMenu) throws IllegalArgumentException {
        String eachMenuName = validateEachMenuName(eachMenu);
        int eachMenuQuantity = validateEachMenuQuantity(eachMenu);
        MenuItem menuItem = menusInfo.getMenu(eachMenuName);
        //메뉴 없음
        if (menuItem == null) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        //메뉴 중복
        if (menus.containsKey(menuItem)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        menus.put(menuItem, eachMenuQuantity);
    }
    
    private String validateEachMenuName(String eachMenu) throws IllegalArgumentException {
        //쉼표(,)로 구분된 각 메뉴에 아무 입력이 없는 경우
        if (eachMenu.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        String[] eachMenuInfo = eachMenu.split("-");
        //쉼표(,)로 구분된 각 메뉴가 '-'로 구분했을 때 2개로 나뉘지 않은 경우(형식 오류)
        if (eachMenuInfo.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        String eachMenuName = eachMenuInfo[0];
        if (eachMenuName.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return eachMenuName;
    }
    
    private int validateEachMenuQuantity(String eachMenu) throws IllegalArgumentException {
        String[] eachMenuInfo = eachMenu.split("-");
        String eachMenuQuantity = eachMenuInfo[1];
        if (eachMenuQuantity.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        if (!eachMenuQuantity.matches("[-0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return Integer.parseInt(eachMenuQuantity);
    }
    
    public Map<MenuItem, Integer> getMenus() {
        return this.menus;
    }
}
