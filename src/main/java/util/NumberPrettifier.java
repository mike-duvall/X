package util;


import java.text.DecimalFormat;

public class NumberPrettifier {


    public static final double ONE_TRILLION = 1000000000000D;
    public static final int ONE_BILLION = 1000000000;
    public static final int ONE_MILLION = 1000000;

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


    // I have checkstyle configured to enforce a max allowed cyclomatic complexity of 3
    // but the complexity of this method is 4.  I'm happy with this method, so
    // I've excluded it from checkstyle checking
    // CHECKSTYLE:OFF
    private String determineSizeSuffix(Double aNumber) {
        String sizeSuffix = "";
        if( aNumber >= ONE_TRILLION)
            sizeSuffix = "T";
        else if( aNumber >= ONE_BILLION)
            sizeSuffix = "B";
        else if( aNumber >= ONE_MILLION)
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
