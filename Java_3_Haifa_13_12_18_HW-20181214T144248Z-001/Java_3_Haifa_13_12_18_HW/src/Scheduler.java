import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Scheduler {
	private List<Event> list;
	
	public Scheduler() {
		list = new ArrayList<>();
	}
	private boolean add(double price, MyDate start, MyDate end) {
		if(price <= 0 || start == null || end == null 
				|| !checkFormat(start) || !checkFormat(end) 
				|| getDiff(start, end) <= 0) {
			return false;
		}
		list.add(new Event(price, start, end));
		return true;
	}
	
	public Iterable<Report> getReport(){
		List<Report> res = new ArrayList<>();
		HashMap<Double,Double> map = new HashMap<>();
		for(Event e : list) {
			Double currH = map.get(e.getPrice());
			Double eventH = getDiff(e.getStart(),e.getEnd());
			if(currH == null) {
				map.put(e.getPrice(), eventH);
			}else {
				map.put(e.getPrice(), currH + eventH);
			}
		}
		Set<Entry<Double,Double>> entries = map.entrySet();
		for(Entry<Double,Double> entry : entries) {
			res.add(new Report(entry.getKey(),entry.getValue()));
		}
		return res;
	}
	
	private boolean checkFormat(MyDate date) {
		return date.getYear() >= 0 
				&& date.getMonth() >= 0
				&& date.getMonth() < 12
				&& date.getDay() > 0
				&& date.getDay() < 32
				&& date.getHour() >= 0
				&& date.getHour() < 24
				&& date.getMinutes() >= 0
				&& date.getMinutes() < 60;
	}
	
	private double getDiff(MyDate start, MyDate end) {
		double startH = start.getYear() * 12 * 31 * 24 
				+ start.getMonth() * 31 * 24 
				+ start.getDay() * 24 
				+ (start.getHour() + start.getMinutes() / 60.0);
		
		double endH = end.getYear() * 12 * 31 * 24 
				+ end.getMonth() * 31 * 24 
				+ end.getDay() * 24 
				+ (end.getHour() + end.getMinutes() / 60.0);
		return endH - startH;
	}
}
