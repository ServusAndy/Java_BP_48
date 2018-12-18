
public enum Month {
	JAN(31), 
	FEB(28), 
	MAR(31), 
	APR(30), 
	MAY(31), 
	JUN(30), 
	JUL(31), 
	AUG(31), 
	SEP(30), 
	OCT(31), 
	NOV(30), 
	DEC(31);
	private int maxDay;
	private int currentDate;

	Month(int maxDay) {
		this.maxDay = maxDay;
	}

	public int getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(int currentDate) {
		this.currentDate = Math.abs(currentDate);
	}

	public Month plus(int days) {
		Month[] arr = values();
		int totalDays = 0;
		for (Month m : arr) {
			totalDays += m.maxDay;
		}

		int pureDays = days % (totalDays);
		if (pureDays == 0) {
			return this;
		}
		if(pureDays + currentDate <= maxDay) {
			currentDate = pureDays + currentDate;
			return this;
		}
		int next = ordinal() + 1;
		pureDays = pureDays - (maxDay - currentDate);
		
		while (true) {
			Month curr = arr[next % arr.length];
			if (pureDays <= curr.maxDay) {
				curr.currentDate = pureDays;
				return curr;
			}
			pureDays -= curr.maxDay;
			next++;
		}
	}

}
