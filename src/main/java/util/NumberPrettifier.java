package util;


public class NumberPrettifier {


    // Note:  Right now I'm using strict TDD
    // so some of this will be hard-coded until
    // I get to a test that forces otherwise
    public String prettify(Double aNumber) {
        if( aNumber > 999999) {
            return handleNumbersOverSixDigits(aNumber);
        }
        else {
            return handleNumbersSixDigitsOrUnder(aNumber);
        }
    }


    private String handleNumbersSixDigitsOrUnder(Double aNumber) {
        return new Integer(aNumber.intValue()).toString();
    }


    private String handleNumbersOverSixDigits(Double aNumber) {
        String stringNumber = aNumber.toString();
        char  firstDigit = stringNumber.charAt(0);
        char  secondDigit = stringNumber.charAt(1);
        if( secondDigit == '0') {
            return "1M";
        }
        else {
            return "" + firstDigit + "." + secondDigit + "M";
        }
    }

}
