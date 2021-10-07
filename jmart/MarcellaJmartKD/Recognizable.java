package MarcellaJmartKD;

public abstract class Recognizable
{
    public final int id;
    
    protected Recognizable(int id){
        this.id = id;
    }
    
    public boolean equals (Object o){
        if (o instanceof Recognizable){
            Recognizable r= (Recognizable) o;
            return (r.id == this.id);
        }
        return false;
    }
    
    public boolean equals (Recognizable r){
        if (r.id == this.id){
            return true;
        }
        else{
            return false;
        }
    }
}

