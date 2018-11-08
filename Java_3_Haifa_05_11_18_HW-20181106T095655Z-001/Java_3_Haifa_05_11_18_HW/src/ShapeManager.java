
public class ShapeManager {
	private Shape[] arr;
	private int count;
	public ShapeManager() {
		arr = new Shape[10];
		count = 0;
	}
	
	public void add(Shape s) {
		int indx = indexOf(s);
//		if(indx < 0 && count < arr.length) {
//			arr[count++] = s;
//		}
		if(indx < 0) {
			if(count >= arr.length) {
				Shape[] tmp = new Shape[arr.length*2];
				for(int i = 0; i < arr.length; i++) {
					tmp[i] = arr[i];
				}
				arr = tmp;
			}
			arr[count++] = s;
		}
	}
	
	public void remove(Shape s) {
		int indx = indexOf(s);
		if(indx >= 0) {
			for(int i = indx; i < count-1;i++) {
				arr[i] = arr[i+1];
			}
			count--;
		}
	}
	
	public double getTotalArea() {
		double total = 0;
		for(int i = 0; i < count; i++) {
			total = total + arr[i].calcArea();
		}
		return total;
	}
	
	public double getTotalPerimitr(String type) {
		double total = 0;
		for(int i = 0; i < count; i++) {
			switch(type.toLowerCase()) {
			case "all":
				total = total + arr[i].calcPerimitr();
				break;
			case "triangle":
				if(arr[i] instanceof Triangle) {
					total = total + arr[i].calcPerimitr();
				}
				break;
			case "square":
				if(arr[i] instanceof Square) {
					total = total + arr[i].calcPerimitr();
				}
				break;
			case "circle":
				if(arr[i] instanceof Circle) {
					total = total + arr[i].calcPerimitr();
				}
				break;
			}
		}
		return total;
	}
	
	public void display(String type) {
		for(int i = 0; i < count; i++) {
			switch(type.toLowerCase()) {
			case "square":
				if(arr[i] instanceof Square) {
					System.out.println(arr[i]);
				}
				break;
			case "triangle":
				if(arr[i] instanceof Triangle) {
					System.out.println(arr[i]);
				}
				break;
			case "circle":
				if(arr[i] instanceof Circle) {
					System.out.println(arr[i]);
				}
				break;
			case "all":
				System.out.println(arr[i]);
				break;
			}
		}
	}
	
	private int indexOf(Shape s) {
		for(int i = 0; i < count; i++) {
			if(arr[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}
	
	
}
