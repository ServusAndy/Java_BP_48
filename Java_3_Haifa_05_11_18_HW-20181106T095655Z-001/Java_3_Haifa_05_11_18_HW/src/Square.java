
public class Square  extends Shape{

	public Square(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcArea() {
		return Math.pow(getLength(), 2);
	}

	@Override
	public double calcPerimitr() {
		return 4 * getLength();
	}
	
	public String toString() {
		return "Square " + getLength();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Square)) {
			return false;
		}
		Square other = (Square) obj;
		if(getLength() != other.getLength()) {
			return false;
		}
		return true;
	}
	
	

}
