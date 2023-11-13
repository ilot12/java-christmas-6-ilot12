package decemberdate;

public class DecemberDate {
    
    private int date;
    private boolean isWeekend;
    
    public DecemberDate(String dateText) {
        int validatedDate = validateDate(dateText);
        this.date = validatedDate;
        this.isWeekend = calculateIsWeekend(validatedDate);
    }
    
    private int validateDate(String dateText) throws IllegalArgumentException {
        if (dateText.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        if (!dateText.matches("[-0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        int date = Integer.parseInt(dateText);
        if (date <= 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return date;
    }
    
    private boolean calculateIsWeekend(int date) {
        if (date % 7 == 1 || date % 7 == 2) {
            return true;
        }
        return false;
    }
    
    public int getDate() {
        return this.date;
    }
    
    public boolean isWeekend() {
        return isWeekend;
    }
}
