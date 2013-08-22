package util;


import java.text.DecimalFormat;

public class NumberPrettifier {


    public String prettify(Double aNumber) {
        validateNumberIsLegal(aNumber);
        return prettifyValidNumber(aNumber);
    }

    private void validateNumberIsLegal(Double aNumber) {
        if(aNumber < 0)
            throw new NumberTooSmallException("Number was too small:" + aNumber);
        else if( aNumber > 999999999999999D)
            throw new NumberTooLargeException("Number was too large:" + aNumber);
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
        String inputNumberAsString = convertDoubleToFlatString(aNumber);
        if( needsDecimalPoint(inputNumberAsString))
            return formatStringWithDecimalPoint(inputNumberAsString, sizeSuffix);
        else
            return formatStringWithoutDecimalPoint(inputNumberAsString, sizeSuffix);
    }


    private boolean needsDecimalPoint(String numberAsString) {
        char  secondDigit = numberAsString.charAt(1);
        return  secondDigit != '0';
    }

    private String formatStringWithoutDecimalPoint(String inputNumberAsString, String sizeSuffix) {
        char  firstDigit = inputNumberAsString.charAt(0);
        return firstDigit + sizeSuffix;
    }

    private String formatStringWithDecimalPoint(String inputNumberAsString, String sizeSuffix) {
        char  firstDigit = inputNumberAsString.charAt(0);
        char  secondDigit = inputNumberAsString.charAt(1);
        return firstDigit + "." + secondDigit + sizeSuffix;
    }


    private String convertDoubleToFlatString(Double aNumber) {
        return new DecimalFormat("#").format(aNumber);
    }


    // CHECKSTYLE:OFF
    private String determineSizeSuffix(Double aNumber) {
        String sizeSuffix = "";
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
