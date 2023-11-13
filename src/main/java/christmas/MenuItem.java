package christmas;

public class MenuItem {
    
    private String category;
    private String name;
    private int price;
    
    MenuItem(String category, String name, int price){
        String validatedCategory = validateCategory(category);
        String validatedName = validateName(name);
        int validatedPrice = validatePrice(price);
        this.category = validatedCategory;
        this.name = validatedName;
        this.price = validatedPrice;
    }
    
    private String validateCategory(String category) throws IllegalArgumentException {
        if (category.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 메뉴 종류는 0자가 아니어야 합니다.");
        }
        if (category.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 메뉴 종류에 공백( )은 포함되면 안됩니다.");            
        }
        return category;
    }
    
    private String validateName(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 메뉴 이름은 0자가 아니어야 합니다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 메뉴 이름에 공백( )은 포함되면 안됩니다.");            
        }
        return name;
    }
    
    private int validatePrice(int price) throws IllegalArgumentException {
        if (price <= 0) {
            throw new IllegalAccessError("[ERROR] 메뉴 가격은 양수여야 합니다.");
        }
        return price;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPrice() {
        return this.price;
    }
}
