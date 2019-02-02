
public interface ICompany {
	boolean addEmployee(Employee employee);
	Employee removeEmployee(int id);
	double totalSalary();
	int size();
	double totalSales();
	Employee getEmployeeById(int id);
	void printCompany();
	default double avgSalary() {
		return totalSalary() / size();
	}
}
