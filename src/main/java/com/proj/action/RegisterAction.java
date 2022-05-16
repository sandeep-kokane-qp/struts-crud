package com.proj.action;

import com.proj.dao.UserDAO;
import com.proj.form.UserForm;
import com.proj.model.User;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("RegisterAction.execute");
        UserForm userForm = (UserForm) form;
        User user = new User();
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setCity(userForm.getCity());

        UserDAO userDAO = new UserDAO();
        int insert = userDAO.insert(user);
        if (insert > 0) {
            request.setAttribute("res", "Inserted into DB");
            return mapping.findForward("success");
        }
        return mapping.findForward("failure");
    }
}
