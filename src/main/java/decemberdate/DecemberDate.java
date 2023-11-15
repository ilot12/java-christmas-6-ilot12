package decemberdate;

public class DecemberDate {
    
    private int date;
    private boolean isWeekend;
    private boolean isStarDay = false;
    
    public DecemberDate(String dateText) {
        this.date = validateDate(dateText);
        calculateIsWeekend(date);
        calculateStarDay();
    }
    
    private int validateDate(String dateText) throws IllegalArgumentException {
        if (dateText.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        if (!dateText.matches("[-0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        int date = Integer.parseInt(dateText);
        if (date <= 0 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return date;
    }
    
    private void calculateIsWeekend(int date) {
        if (date % 7 == 1 || date % 7 == 2) {
            isWeekend = true;
        }
        isWeekend = false;
    }
    
    private void calculateStarDay() {
        if (date % 7 == 3) {
            isStarDay = true;
        }
        if (date == 25) {
            isStarDay = true;
        }
    }
    
    public int getDate() {
        return this.date;
    }
    
    public boolean isWeekend() {
        return this.isWeekend;
    }
    
    public boolean isStarDay() {
        return this.isStarDay;
    }
}
