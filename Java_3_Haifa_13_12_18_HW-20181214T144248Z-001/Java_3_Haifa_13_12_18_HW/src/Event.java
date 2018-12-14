
public class Event {
	private double price;
	private MyDate start;
	private MyDate end;
	
	public Event(double price, MyDate start, MyDate end) {
		super();
		this.price = price;
		this.start = start;
		this.end = end;
	}

	public double getPrice() {
		return price;
	}

	public MyDate getStart() {
		return start;
	}

	public MyDate getEnd() {
		return end;
	}
	
	
}
