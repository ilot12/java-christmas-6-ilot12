package menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MenuTest {
    
    @Test
    void menuItemEquals() {
        MenuItem menu1 = new MenuItem("1", "name1", 1);
        MenuItem menu2 = new MenuItem("2", "name1", 2);
        MenuItem menu3 = new MenuItem("3", "name3", 3);
        assertThat(menu1.equals(menu2)).isTrue();
        assertThat(menu1.equals(menu3)).isFalse();
    }
    
    @Test
    void menuInfoConstruct() {
        MenusInfo menusInfo = new MenusInfo();
        boolean doesExistMushroomSoup = false;
        boolean doesExistTBoneSteak = false;
        for (MenuItem menuItem : menusInfo.getAllMenus()) {
            if (menuItem.getCategory().equals("에피타이저") 
                    && menuItem.getName().equals("양송이수프")
                    && menuItem.getPrice() == 6000) {
                doesExistMushroomSoup = true;
                continue;
            }
            if (menuItem.getCategory().equals("메인") 
                    && menuItem.getName().equals("티본스테이크")
                    && menuItem.getPrice() == 55000) {
                doesExistTBoneSteak = true;
                continue;
            }
        }
        assertThat(doesExistMushroomSoup).isTrue();
        assertThat(doesExistTBoneSteak).isTrue();
    }
    
    @Test
    void menusInfoGetMenu() {
        MenusInfo menusInfo = new MenusInfo();
        assertThat(menusInfo.getMenu("양송이수프").getCategory().equals("에피타이저")).isTrue();
        assertThat(menusInfo.getMenu("양송이수프").getName().equals("양송이수프")).isTrue();
        assertThat(menusInfo.getMenu("양송이수프").getPrice() == 6000).isTrue();
        assertThat(menusInfo.getMenu("시저샐러드").getCategory().equals("에피타이저")).isTrue();
        assertThat(menusInfo.getMenu("시저샐러드").getName().equals("시저샐러드")).isTrue();
        assertThat(menusInfo.getMenu("시저샐러드").getPrice() == 8000).isTrue();
        assertThat(menusInfo.getMenu("초코케이크").getCategory().equals("디저트")).isTrue();
        assertThat(menusInfo.getMenu("초코케이크").getName().equals("초코케이크")).isTrue();
        assertThat(menusInfo.getMenu("초코케이크").getPrice() == 15000).isTrue();
        assertThat(menusInfo.getMenu("샴페인").getCategory().equals("음료")).isTrue();
        assertThat(menusInfo.getMenu("샴페인").getName().equals("샴페인")).isTrue();
        assertThat(menusInfo.getMenu("샴페인").getPrice() == 25000).isTrue();
    }
    
    @Test
    void menusInfoGetMenuFail() {
        MenusInfo menusInfo = new MenusInfo();
        assertThat(menusInfo.getMenu("삼각김밥") == null).isTrue();
    }
    
    
}
