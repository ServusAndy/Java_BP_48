

public class TestShop {

	public static void main(String[] args) {
		Shop shop = new Shop();
		shop.add("Item 1", 1,15.5);
//		Shop.Item i = new Shop.Item("", 123,445);
		for(Shop.Item i : shop) {
			System.out.println(i);
		}
	}

}
