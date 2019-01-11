import java.util.HashSet;

public class Bank {

	public static final int TRANSACTION_LIMIT = 2000;
	
	private long totalVolume;
	private HashSet<Account> accounts;
	
	public Bank(long totalVolume) {
		this.totalVolume = totalVolume;
		accounts = new HashSet<>();
	}

	public String getAccountStr(String id) {
		try {
			Account acc = getAccount(id);
			return acc.toString();
		} catch (Exception e) {
			return e.getMessage();
		} 
		
	}
	
	private Account getAccount(String id) throws Exception {
		for (Account acc:accounts)
			if (acc.getId().equals(id))
				return acc;
		
		throw new Exception("Account with id "+id+" didn't find");
	}
	
	public void addAcount(Account account) throws Exception {
		if (accounts.contains(account))
			throw new Exception("We already have this id - "+account.getId());

		accounts.add(account);
	}
	
	public void tryToLogin(String id, String pin) throws Exception {
		Account acc = getAccount(id);
		
		boolean isEquals = acc.getPin().equals(pin);
		
		if (!isEquals) 
			throw new Exception("Wrong pin for id - "+id);
		
		acc.setLogin(isEquals);
	}
	
	public void putMoney(String id, int money) {
		try {
			Account acc = getAccount(id);
			acc.addVolume(money);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void getMoney(String id, int money) {
		putMoney(id, -money);
	}
}
