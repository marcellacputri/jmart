package MarcellaJmartKD;

import java.util.HashMap;
import java.util.Map;
/**
 * Write a description of class Complaint here.
 *
 * @author (Marcella Cinninthya Putri)
 * @version (27/09/2021)
 */

public class Serializable implements Comparable<Serializable> {
	public final int id;
	public int inc;
    private static Map<Class<?>, Integer> mapCounter = new HashMap<>();
    
	protected Serializable() {
		Class gotClass = getClass();
        if(mapCounter.get(gotClass) == null){
            mapCounter.put(gotClass, 0);
        }
        else{
            mapCounter.put(gotClass, mapCounter.get(gotClass) + 1);
        }
        this.id = mapCounter.get(gotClass);
	}

	
	public boolean equals(Object o) {
		 if (o instanceof Serializable){
	            Serializable r = (Serializable) o;
	            if (r.id == this.id){
	                return true;
	            }
	            else{
	                return false;
	            }
	        }
	        return false;
	}

	public boolean equals(Serializable r) {
		if (r.id == this.id) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Serializable other) {
		return (this.id < other.id) ? -1 : ((this.id == other.id) ? 0 : 1);
	}

	public static <T extends Serializable> int getClosingId(Class<T> clazz) {
		return mapCounter.get(clazz);
	}

	public static <T extends Serializable> int setClosingId(Class<T> clazz, int id) {
		return mapCounter.put(clazz, id);
	}
}
