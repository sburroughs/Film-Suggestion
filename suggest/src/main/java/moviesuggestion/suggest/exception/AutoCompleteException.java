package moviesuggestion.suggest.exception;


public class AutoCompleteException extends Throwable {

    public AutoCompleteException(String s) {
        super(s);
    }

    public AutoCompleteException(String s, Throwable e) {
        super(s, e);
    }
}
