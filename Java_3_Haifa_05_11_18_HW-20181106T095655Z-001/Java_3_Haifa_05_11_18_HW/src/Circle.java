
public class Circle extends Shape {

	public Circle(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcArea() {
		
		return Math.PI * Math.pow(getLength(), 2);
	}

	@Override
	public double calcPerimitr() {
		
		return 2 * Math.PI * getLength();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Circle)) {
			return false;
		}
		Circle other = (Circle) obj;
		if(getLength() != other.getLength()) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return "Circle " + getLength();
	}

}
