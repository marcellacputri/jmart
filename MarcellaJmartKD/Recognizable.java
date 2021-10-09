package MarcellaJmartKD;

public class Recognizable implements Comparable<Recognizable> {
	public final int id;

	
	protected Recognizable(int id) {
		this.id = id;
	}

	public boolean equals(Object o) {
		if (o instanceof Recognizable) {
			Recognizable r = (Recognizable) o;
			return (r.id == this.id);
		}
		return false;
	}

	public boolean equals(Recognizable r) {
		if (r.id == this.id) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Recognizable other) {
		return (this.id < other.id) ? -1 : ((this.id == other.id) ? 0 : 1);
	}

	public static <T extends Recognizable> int getClosingId(Class<T> clazz) {
		return 0;
	}

	public static <T extends Recognizable> int setClosingId(Class<T> clazz, int id) {
		return 0;
	}
}
