
public class Main {

	public static void main(String[] args) {
		
		Bank creditAgricole = new Bank(10000);
		try {
			creditAgricole.addAcount(new Account("Ivan","4214123123","1111"));
			creditAgricole.addAcount(new Account("Nastya","HD327878","1234"));
			creditAgricole.addAcount(new Account("Anastasija","HD327878","1234"));
			creditAgricole.addAcount(new Account("Sarah","9865656","0000"));			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println(creditAgricole.getAccountStr("4214123123"));
		System.out.println(creditAgricole.getAccountStr("9865656"));
		System.out.println(creditAgricole.getAccountStr("121233124235234"));
		
		creditAgricole.putMoney("4214123123", 30000);
		creditAgricole.putMoney("HD327878", 3000);
		creditAgricole.putMoney("9865656", 50000);
		System.out.println(creditAgricole.getAccountStr("HD327878"));
		
		ATM atmHaifa = new ATM(creditAgricole);
		
		atmHaifa.inputPin("4214123123","1111");
		System.out.println(creditAgricole.getAccountStr("4214123123"));
		atmHaifa.getMoney(1000);
		System.out.println(creditAgricole.getAccountStr("4214123123"));
		
		atmHaifa.inputPin("421412315534534","1111");
		
		
		atmHaifa.inputPin("4214123123","1134");
		
		
	}
}