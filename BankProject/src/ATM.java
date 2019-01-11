public class ATM {

	private Bank bank;
	private String currentId = null;

	public ATM(Bank bank) {
		this.bank = bank;
	}

	public void inputPin(String id, String pin) {
		try {
			bank.tryToLogin(id, pin);
			currentId = id;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getMoney(int volume) {
		bank.getMoney(currentId, volume);
	}
}
