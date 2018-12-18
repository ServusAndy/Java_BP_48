
public enum Week {
	SUN, MON, TUE, WED, THU, FRI, SAT;
	
	public Week plus(int days) {
		Week[] weeks = values();
		int curr = ordinal();
		return weeks[(curr + days) % weeks.length];
	}
}
