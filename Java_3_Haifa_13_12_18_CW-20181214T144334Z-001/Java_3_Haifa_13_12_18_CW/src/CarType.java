
public enum CarType {
	TRUCK("Truck"),
	REGULAR("Legkovoi avtomobil"){
		public int getMaxSpeed() {
			return 160;
		}
	},
	SUPER_TRUCK("Super truck");
	private String name;
	
	CarType(String name){
		this.name = name;
	}
	
	public int getMaxSpeed() {
		return getMaxSpeed();
	}
	public String toString() {
		return name;
	}
}
