package MarcellaJmartKD;

public class Recognizable
{
    public final int id;
    
    protected Recognizable(int id){
        this.id = id;
    }
    
    public boolean equals (Object a){
        if (a instanceof Recognizable){
            Recognizable b = (Recognizable) a;
            return (b.id == this.id);
        }
        return false;
    }
    
    public boolean equals (Recognizable b){
        if (b.id == this.id){
            return true;
        }
        else{
            return false;
        }
    }
}

