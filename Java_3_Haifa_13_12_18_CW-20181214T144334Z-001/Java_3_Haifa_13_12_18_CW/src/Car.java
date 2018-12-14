
public class Car {
	public static final int TRUCK = 1;
	public static final int REGULAR = 2;
	private String model;
	private String manuf;
//	private int type;
	private CarType type;
	public Car(String model, String manuf, CarType type) {
		super();
		this.model = model;
		this.manuf = manuf;
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManuf() {
		return manuf;
	}
	public void setManuf(String manuf) {
		this.manuf = manuf;
	}
	public CarType getType() {
		return type;
	}
	public void setType(CarType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", manuf=" + manuf + ", type=" + type + "]";
	}
	
	

}
