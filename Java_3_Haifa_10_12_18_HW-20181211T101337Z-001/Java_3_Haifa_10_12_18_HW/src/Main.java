import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Integer d = null;
//		HashMap<String, Integer> map = new HashMap<>();
//		int d1 = map.get("key");
//		System.out.println(d1);
		Shop shop = new Shop();
		int count = shop.getItemCount("12345");
		System.out.println(count);

	}

}
