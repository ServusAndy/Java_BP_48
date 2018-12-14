
public class Report {
	private double price;
	private double totalHours;
	
	
	public Report() {
		super();
	}


	public Report(double price, double totalHours) {
		super();
		this.price = price;
		this.totalHours = totalHours;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getTotalHours() {
		return totalHours;
	}


	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}
	
	
}
