package action;


import form.LoginForm;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import po.Customer;
/*import dao.CustomerDao;*/
import idao.ICustomerDao;

public class LoginAction extends Action {
	private ICustomerDao icdao;
	
	public ICustomerDao getIcdao() {
		return icdao;
	}

	public void setIcdao(ICustomerDao icdao) {
		this.icdao = icdao;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		LoginForm loginform=(LoginForm)form;
		String account=loginform.getAccount();
		String password=loginform.getPassword();
		/*CustomerDao cdao = new CustomerDao();
		Customer cus=cdao.getCustomerByAccount(account);*/
		Customer cus= icdao.getCustomerByAccount(account);
		if(cus!=null&&cus.getPassword().equals(password)){
			request.setAttribute("msg", cus.getCname());
		}else{
			request.setAttribute("msg", "µÇÂ¼Ê§°Ü");
		}
		return new ActionForward("/login.jsp");
		
	}
}
