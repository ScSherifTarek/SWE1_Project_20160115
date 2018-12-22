import java.util.ArrayList;
import java.util.Date;

public class testMain {

	public static Account login(String email,String password)
	{
		return Account_DB_Interface.getAccount(email, password);
	}
	public static void main(String[] args) {
		
		Account acc = login("sherift1552@gmail.com","01158789888");
		if(acc == null)
		{
			System.out.println("Wrong Email or Password");
		}
		else
		{
			System.out.println("Logged in:");
			System.out.println(acc);
		}
	}

}
