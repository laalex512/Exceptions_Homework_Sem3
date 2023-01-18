package Homework3.Exceptions;

public class OverSizeMessageException extends RuntimeException{
	public OverSizeMessageException(String message){
		super (message);
	}
}
