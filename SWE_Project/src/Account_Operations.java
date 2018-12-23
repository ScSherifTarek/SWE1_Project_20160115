
public class Account_Operations {
	public static Account login(String email,String password)
	{
		return Account_DB_Interface.getAccount(email, password);
	}
	public static Account createAccount(String name, String password, String email, String phoneNumber)
	{
		Account acc = new Account(name, password, email, phoneNumber);
		acc.setId(Account_DB_Interface.addAccount(acc));
		if(acc.getId() == -1)
			return null;
		return acc;
	}
}
