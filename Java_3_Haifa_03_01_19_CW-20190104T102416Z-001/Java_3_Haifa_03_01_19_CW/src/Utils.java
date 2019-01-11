
public class Utils {
	public static void sort(Object[] arr, MyComparator comparator) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1;j++) {
				if(comparator.compare(arr[j],arr[j+1]) > 0){
					Object tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	public static void sort(Object[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1;j++) {
				MyComparable o1 = (MyComparable) arr[j];
				MyComparable o2 = (MyComparable) arr[j+1];
				if(o1.compareTo(o2) > 0){
					Object tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
}
