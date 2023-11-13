package decemberdate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
