
public interface ICompany {
	public int count();
	public double totalSalary();
	default public double avg() {
		return totalSalary()/count();
	};
}
