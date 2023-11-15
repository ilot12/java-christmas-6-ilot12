package menu;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class MenusTest {
    
    @Test
    void menusInputEmpty() {
        assertThatThrownBy(() -> new Menus(""))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void menusWrongFormat1() {
        assertThatThrownBy(() -> new Menus("티본스테이크-1-1"))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void menusWrongFormat2() {
        assertThatThrownBy(() -> new Menus("티본스테이크"))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void menusNotExist() {
        assertThatThrownBy(() -> new Menus("삼각김밥-1"))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void menusQuantityNotNumber() {
        assertThatThrownBy(() -> new Menus("티본스테이크-a"))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void menusQuantityNotValidNumber() {
        assertThatThrownBy(() -> new Menus("티본스테이크-0"))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void menusDuplication() {
        assertThatThrownBy(() -> new Menus("티본스테이크-1,티본스테이크-2"))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void menusOver20() {
        assertThatThrownBy(() -> new Menus("티본스테이크-12,티본스테이크-9"))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void meunsOnlyDrink() {
        assertThatThrownBy(() -> new Menus("제로콜라-1,샴페인-3"))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void menusNoException() {
        MenusInfo menusInfo = new MenusInfo();
        Menus menus = new Menus("티본스테이크-2,제로콜라-1");
        assertEquals(2, menus.getMenus().get(menusInfo.getMenu("티본스테이크")));
        assertEquals(1, menus.getMenus().get(menusInfo.getMenu("제로콜라")));
        assertEquals(3, menus.getMenusCount());
    }
}
