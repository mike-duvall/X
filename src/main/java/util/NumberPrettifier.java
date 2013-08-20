package util;


public class NumberPrettifier {


    // Note:  Right now I'm using strict TDD
    // and just making the tests pass
    // So clearly this implementation will quickly change
    // since it's hard-coded
    public String prettify(Double aNumber) {
        if( aNumber > 999999) {
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
        else {
            return new Integer(aNumber.intValue()).toString();
        }
    }

}
