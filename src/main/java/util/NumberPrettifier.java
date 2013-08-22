package util;


import java.text.DecimalFormat;

public class NumberPrettifier {


    public String prettify(Double aNumber) {
        if(aNumber < 0)
            throw new NumberTooSmallException("Number was too small:" + aNumber);
        else if( aNumber > 999999999999999D)
            throw new NumberTooLargeException("Number was too large:" + aNumber);
        else
            return prettifyValidNumber(aNumber);
    }

    private String prettifyValidNumber(Double aNumber) {
        if( aNumber > 999999)
            return prettifyNumbersOverSixDigits(aNumber);
        else
            return prettifyNumbersSixDigitsOrUnder(aNumber);

    }


    private String prettifyNumbersSixDigitsOrUnder(Double aNumber) {
        return new Integer(aNumber.intValue()).toString();
    }


    private String prettifyNumbersOverSixDigits(Double aNumber) {
        String sizeSuffix = determineSizeSuffix(aNumber);
        String stringNumber = new DecimalFormat("#").format(aNumber);
        char  firstDigit = stringNumber.charAt(0);
        char  secondDigit = stringNumber.charAt(1);
        if( secondDigit == '0') {
            return firstDigit + sizeSuffix;
        }
        else {
            return "" + firstDigit + "." + secondDigit + sizeSuffix;
        }
    }


    // CHECKSTYLE:OFF
    private String determineSizeSuffix(Double aNumber) {
        String sizeSuffix = null;
        if( aNumber > 999999999999D)
            sizeSuffix = "T";
        else if( aNumber > 999999999)
            sizeSuffix = "B";
        else if( aNumber > 999999)
            sizeSuffix = "M";
        return sizeSuffix;
    }
    // CHECKSTYLE:ON

    public class NumberTooLargeException extends RuntimeException {

        public NumberTooLargeException(String message) {
            super(message);
        }
    }


    public class NumberTooSmallException extends RuntimeException {
        public NumberTooSmallException(String message) {
            super(message);
        }
    }
}
