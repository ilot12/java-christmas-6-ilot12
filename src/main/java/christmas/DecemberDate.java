package christmas;

public class DecemberDate {
    
    private int date;
    private boolean isWeekend;
    
    DecemberDate(int date) {
        int validatedDate = validateDate(date);
        this.date = validatedDate;
        this.isWeekend = calculateIsWeekend(validatedDate);
    }
    
    private int validateDate(int date) throws IllegalArgumentException{
        if (date <= 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요. ");
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
