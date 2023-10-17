

public class UserDontExistException extends Exception
{
    public UserDontExistException(){
        super();
    }
    
    public UserDontExistException(String e){
        super(e);
    }
}
