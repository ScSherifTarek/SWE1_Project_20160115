import java.util.ArrayList;
import java.util.Date;

public class Program_Interface {
	public static Account login(String email,String password)
	{
		return Account_DB_Interface.getAccount(email, password);
	}
	public static void main(String[] args) {
		Account acc1 = Account_DB_Interface.getAccount(1);
		Account acc2 = Account_DB_Interface.getAccount(4);
		Contact_Message m = new Contact_Message(acc1,acc2);

//		Account acc = login("sherift1552@gmail.com","01158789888");
//		if(acc == null)
//		{
//			System.out.println("Wrong Email or Password");
//		}
//		else
//		{
//			System.out.println("Logged in:");
//			System.out.println(acc);
//		}
	}

}
