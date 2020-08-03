package exceptions;

public class MyArraySizeException extends IllegalArgumentException {

    public MyArraySizeException() {
        super();
    }

    public MyArraySizeException(String s) {
        super(s);
    }

}
