
public abstract class Shape {
	private int length;
	
	public Shape(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}

	public abstract double calcArea();
	public abstract double calcPerimitr();
}
