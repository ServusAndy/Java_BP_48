
public class Triangle extends Shape{

	public Triangle(int length) {
		super(length);
	}

	@Override
	public double calcArea() {
		return (Math.pow(getLength(), 2) * Math.sqrt(3))/4;
	}

	@Override
	public double calcPerimitr() {
		return 3 * getLength();
	}
	
	public String toString() {
		return "Triangle " + getLength();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Triangle)) {
			return false;
		}
		
		Triangle other = (Triangle) obj;
		if(getLength() != other.getLength()) {
			return false;
		}
		
		return true;
	}

}
