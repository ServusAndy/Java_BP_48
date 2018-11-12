
public class Car implements Comparable<Car>{
	private String model;
	private int year;
	private int sn;
	
	public Car(String model, int year, int sn) {
		super();
		this.model = model;
		this.year = year;
		this.sn = sn;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public int getSn() {
		return sn;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", year=" + year + ", sn=" + sn + "]";
	}

	
	public int compareTo(Car o) {
		
		return Integer.compare(sn, o.sn);
	}
	
	
	
	
}
