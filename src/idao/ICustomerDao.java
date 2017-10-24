package idao;

import po.Customer;

public interface ICustomerDao {
	public Customer getCustomerByAccount(String account);
	public void insertCustomer(String account,String password,String cname);
}
