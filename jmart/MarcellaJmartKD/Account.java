package MarcellaJmartKD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable implements FileParser
{
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&_~]+(\\.[a-zA-Z0-9&_~]+)@[a-zA-Z0-9][a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)$";
    public static final String REGEX_PASSWORD = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public String name;
    public String email;
    public String password;

    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean read(String content)
    {
        return false;
    }

    @Override
    public Object write()
    {
        return null;
    }

    public static Object newInstance(String cont)
    {
        return null;
    }

    public String toString(){
        return(
            "name: " + this.name +"\n" +
            "email: " + this.email + "\n" +
            "password: " + this.password + "\n"
        );
    }
    
     public boolean validate()
    {
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Matcher emailMatcher = emailPattern.matcher(this.email);
        Pattern sandiPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher sandiMatcher = sandiPattern.matcher(this.password);
        boolean sandiMatch = sandiMatcher.find();
        boolean emailMatch = emailMatcher.find();
        
        if(sandiMatch == true && emailMatch == true)
        {
            return true;
        }
        return false;
    }
}

