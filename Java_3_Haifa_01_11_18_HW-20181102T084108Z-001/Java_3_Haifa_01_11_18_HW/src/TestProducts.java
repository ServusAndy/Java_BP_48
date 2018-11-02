
public class TestProducts {

	public static void main(String[] args) {
		Product[] arr = new Product[10];
		arr[0] = new Leptop("Samsung",123,4000,"35x35x0.7","Intel");
		arr[1] = new Leptop("LG",234,3000,"40x30x10","AMD");
		arr[2] = new TV("Toshiba",345,1500,"120x60x30",false);
		arr[3] = new TV("Philips",456,1700,"140x80x25",true);
		arr[4] = new Phone("Samsung",567,4000,"11\"","Android");
		arr[5] = new Phone("IPhoneXX",765,10000,"6\"","iOS");

		print(arr,"All");
		System.out.println("-----------");
		print(arr,"tv");
		System.out.println("-----------");
		print(arr,"phone");
		System.out.println("-----------");
		print(arr,"Leptop");
		
	}
	
	public static void print(Product[] products, String type) {
		for(int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				switch(type.toLowerCase()) {
				case "all":
					System.out.println(products[i]);
					break;
				case "tv":
					if(products[i] instanceof TV) {
						System.out.println(products[i]);
					}
					break;
				case "leptop":
					if(products[i] instanceof Leptop) {
						System.out.println(products[i]);
					}
					break;
				case "phone":
					if(products[i] instanceof Phone) {
						System.out.println(products[i]);
					}
					break;
					default:
						System.out.println("Wrong type");
						return;
				}
			}
		}
	}

}
