package MarcellaJmartKD;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Complaint extends Recognizable implements FileParser
{
    public Date date;
    public String desc;
    
    public Complaint(int id, String desc)
    {
        super(id);
        this.date = new Date();
        this.desc = desc;
    }
    
    @Override
    public boolean read(String content)
    {
        return true;
    }
    
    @Override
    public Object write()
    {
        return null;
    }
    
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(this.date);
        return
        "{date=" + formattedDate + "desc='" +this.desc+ "'}";
    }
    
    
} 