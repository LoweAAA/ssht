package dao;
import po.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import idao.ICustomerDao;

public class CustomerDao implements ICustomerDao{
	public Customer getCustomerByAccount(String account){
		Session session=util.HibernateSessionFactory.getSession();
		Customer cus=(Customer)session.get(Customer.class, account);
		util.HibernateSessionFactory.closeSession();
		return cus;
	}
	public void insertCustomer(String account,String password,String cname){
		Session session=util.HibernateSessionFactory.getSession();
		Customer cus=new Customer();
		cus.setAccount(account);
		cus.setPassword(password);
		cus.setCname(cname);
		Transaction tran=session.beginTransaction();
		session.save(cus);
		tran.commit();
		util.HibernateSessionFactory.closeSession();
	} 
}
