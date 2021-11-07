package in.conceptarchitect.financeapp;

import in.conceptarchitect.finance.Bank;
import in.conceptarchitect.finance.jdbcAccountStore.JdbcAccountStore;
import in.conceptarchitect.finance.storage.AccountStorage;
import in.conceptarchitect.finance.storage.ArrayAccountStorage;
import in.conceptarchitect.finance.storage.HashmapAccountStorage;
import in.conceptarchitect.machines.ATM;
import in.conceptarchitect.finance.jdbcAccountStore.AccountStoreBo;
import in.conceptarchitect.finance.jdbcAccountStore.JdbcAccountStore;




public class App {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		var storage=new ArrayAccountStorage();
		//var storage= new HashmapAccountStorage();
		Bank icici=new Bank(storage,"ICICI",12);
		//lets create some dummy accounts
		icici.openAccount("savings","Akhil", "pass", 10000);
		icici.openAccount("current","Nag", "pass", 10000);
		icici.openAccount("od","chay", "pass", 10000);
		
		ATM atm=new ATM(icici);
		
		atm.start();
		
		
		
	}

}
