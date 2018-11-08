
public interface IAvg {
	public int size();
	public double total();
	
	default double avg() {
		return total()/size();
	}

}
