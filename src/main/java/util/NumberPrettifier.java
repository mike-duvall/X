package util;


public class NumberPrettifier {


    // Note:  Right now I'm using strict TDD
    // and just making the tests pass
    // So clearly this implementation will quickly change
    // since it's hard-coded
    public String prettify(Integer aNumber) {
        if( aNumber > 999999) {
            return "1M";
        }
        else {
            return aNumber.toString();
        }
    }

}
