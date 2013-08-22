package util;

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class NumberPrettifierTest {


    private void validatePrettifiedNumber(double aNumber, String expectedPrettifiedValue) {
        // Given
        NumberPrettifier numberPrettifier = new NumberPrettifier();

        // When
        String prettifiedNumber = numberPrettifier.prettify(aNumber);

        // Then
        assertThat(prettifiedNumber).isEqualTo(expectedPrettifiedValue);

    }


    @Test
    public void shouldPrettify1000000() {
        validatePrettifiedNumber(1000000, "1M");
    }


    @Test
    public void shouldPrettify2500000point34() {
        validatePrettifiedNumber(2500000.34, "2.5M");
    }

    @Test
    public void shouldPrettifySmallNumber() {
        validatePrettifiedNumber(532, "532");
    }



    @Test
    public void shouldPrettify1123456789() {
        validatePrettifiedNumber(1123456789, "1.1B");
    }


    @Test
    public void shouldPrettify2000000() {
        validatePrettifiedNumber(2000000, "2M");
    }

    @Test
    public void shouldPrettify1000000000() {
        validatePrettifiedNumber(1000000000, "1B");
    }


    @Test
    public void shouldPrettifyOneTrillion() {
        validatePrettifiedNumber(1000000000000D, "1T");

    }

    @Test
    public void shouldPrettifyOnePointTwoTrillion() {
        validatePrettifiedNumber(1200000000000D, "1.2T");
    }

    @Test
    public void shouldPrettify0() {
        validatePrettifiedNumber(0, "0");
    }

    @Test
    public void shouldPrettify999999() {
        validatePrettifiedNumber(999999, "999999");
    }

    @Test
    public void shouldPrettify999999999() {
        validatePrettifiedNumber(999999999, "9.9M");
    }

    @Test
    public void shouldPrettify999999999999() {
        validatePrettifiedNumber(999999999999D, "9.9B");
    }

    @Test
    public void shouldPrettify999999999999999() {
        validatePrettifiedNumber(999999999999999D, "9.9T");
    }

    @Test
    public void shouldPrettifyLargeDecimalComponent() {
        validatePrettifiedNumber(1234556.892834323, "1.2M");
    }

    @Test(expected = NumberPrettifier.NumberTooLargeException.class)
    public void shouldThrowExceptionForNumbers1QuadrillionAndOver() {
        // Given
        NumberPrettifier numberPrettifier = new NumberPrettifier();

        // When
        numberPrettifier.prettify(1000000000000000D);
    }

    @Test(expected = NumberPrettifier.NumberTooSmallException.class)
    public void shouldThrowExceptionForNegativeNumbers() {
        // Given
        NumberPrettifier numberPrettifier = new NumberPrettifier();

        // When
        numberPrettifier.prettify(-1D);
    }



}




