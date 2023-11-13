package menu;

import java.util.ArrayList;
import java.util.List;

public class MenusInfo {
    
    private List<MenuItem> menusInfo = new ArrayList<MenuItem>();
    
    public MenusInfo() {
        menusInfo.add(new MenuItem("에피타이저", "양송이수프", 6000));
        menusInfo.add(new MenuItem("에피타이저", "타파스", 5500));
        menusInfo.add(new MenuItem("에피타이저", "시저샐러드", 8000));
        menusInfo.add(new MenuItem("메인", "티본스테이크", 55000));
        menusInfo.add(new MenuItem("메인", "바비큐립", 54000));
        menusInfo.add(new MenuItem("메인", "해산물파스타", 35000));
        menusInfo.add(new MenuItem("메인", "크리스마스파스타", 25000));
        menusInfo.add(new MenuItem("디저트", "초코케이크", 15000));
        menusInfo.add(new MenuItem("디저트", "아이스크림", 5000));
        menusInfo.add(new MenuItem("음료", "제로콜라", 3000));
        menusInfo.add(new MenuItem("음료", "레드와인", 60000));
        menusInfo.add(new MenuItem("음료", "샴페인", 25000));
    }
    
    public MenuItem getMenu(String menuName) {
        MenuItem menuItem = new MenuItem("category", menuName, 1);
        if (menusInfo.contains(menuItem)) {
            menuItem = menusInfo.get(menusInfo.indexOf(menuItem));
            return menuItem;
        }
        return null;
    }
    
    public List<MenuItem> getAllMenus() {
        return this.menusInfo;
    }
}
