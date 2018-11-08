
public class Triangle implements IShape,IPrintable {
	private int a;

	public Triangle(int a) {
		this.a = a;
	}

	@Override
	public double calcArea() {
		return (Math.pow(a, 2) * Math.sqrt(3))/4;
	}

	@Override
	public double calcPerimitr() {
		return 3 * a;
	}

	@Override
	public void print() {
		System.out.println("Triangle " + calcArea() + " " + calcPerimitr());
		
	}
}
