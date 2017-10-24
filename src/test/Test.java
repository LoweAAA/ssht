package test;
import dao.CustomerDao;
import po.Customer;


public class Test {
	public static void main(String[] args) {
		CustomerDao d1=new CustomerDao();
		Customer c1= d1.getCustomerByAccount("2");
		System.out.println(c1.getCname());
		d1.insertCustomer("44", "2", "込込込込");
	}
	
}
