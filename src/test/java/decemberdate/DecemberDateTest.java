package decemberdate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import decemberdate.DecemberDate;

public class DecemberDateTest {
    
    @Test
    void inputEmptyTest() {
        String emptyString = "";
        assertThatThrownBy(() -> new DecemberDate(emptyString))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void inputNotNumberTest() {
        String notNumber = "abc";
        assertThatThrownBy(() -> new DecemberDate(notNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void inputNegativeNumberTest() {
        String negativeNumber = "-3";
        assertThatThrownBy(() -> new DecemberDate(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void weekendTest() {
        String date = "1";
        assertEquals(new DecemberDate(date).isWeekend(), true);
        date = "2";
        assertEquals(new DecemberDate(date).isWeekend(), true);
        date = "15";
        assertEquals(new DecemberDate(date).isWeekend(), true);
        date = "30";
        assertEquals(new DecemberDate(date).isWeekend(), true);
    }
    
    @Test
    void weekdayTest() {
        String date = "3";
        assertEquals(new DecemberDate(date).isWeekend(), false);
        date = "5";
        assertEquals(new DecemberDate(date).isWeekend(), false);
        date = "15";
        assertEquals(new DecemberDate(date).isWeekend(), false);
        date = "30";
        assertEquals(new DecemberDate(date).isWeekend(), false);
    }
    
    @Test
    void isStarDayTest() {
        String date = "4";
        assertEquals(new DecemberDate(date).isStarDay(), false);
        date = "10";
        assertEquals(new DecemberDate(date).isStarDay(), true);
        date = "13";
        assertEquals(new DecemberDate(date).isStarDay(), false);
        date = "25";
        assertEquals(new DecemberDate(date).isStarDay(), true);
    }
}
