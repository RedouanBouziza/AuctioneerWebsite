package app.exceptions;

public class PreConditionFailed extends RuntimeException{
    public PreConditionFailed(String message){
        super(message);
    }
}
