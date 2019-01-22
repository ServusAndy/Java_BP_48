
public class Car implements Comparable<Car>{
	private String model, manufc;
	private int year, serialNumber;
	private double price;
	public Car(String model, String manufc, int year, int serialNumber, double price) {
		super();
		this.model = model;
		this.manufc = manufc;
		this.year = year;
		this.serialNumber = serialNumber;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public String getManufc() {
		return manufc;
	}
	public int getYear() {
		return year;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", manufc=" + manufc + ", year=" + year + ", serialNumber=" + serialNumber
				+ ", price=" + price + "]";
	}
	@Override
	public int compareTo(Car o) {
		return Integer.compare(serialNumber, o.serialNumber);
	}
	
	
}
