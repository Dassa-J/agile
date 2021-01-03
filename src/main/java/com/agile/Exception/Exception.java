package com.agile.Exception;

public class Exception extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message;


    public Exception(String message) {

        this.message = message;
    }


    public String getMessage() {
        return message;
    }

}
