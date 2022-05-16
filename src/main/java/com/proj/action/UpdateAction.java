package com.proj.action;

import com.proj.dao.UserDAO;
import com.proj.model.User;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("UpdateAction.execute");
        String id = request.getParameter("id");
        User userById = UserDAO.getUserById(id);
        request.setAttribute("user", userById);

        return mapping.findForward("success");
    }
}
