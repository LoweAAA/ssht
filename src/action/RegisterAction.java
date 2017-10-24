package action;

import idao.ICustomerDao;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.RegisterForm;
import javax.servlet.http.*;

import org.apache.struts.action.*;

public class RegisterAction extends Action {
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
		RegisterForm registerform = (RegisterForm)form;
		String account=registerform.getAccount();
		String password=registerform.getPassword();
		String cname=registerform.getCname();
		icdao.insertCustomer(account, password, cname);
		System.out.println(cname);
		return new ActionForward("/register.jsp");
	}
}
