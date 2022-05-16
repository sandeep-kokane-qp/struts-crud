package com.proj.action;

import com.proj.dao.UserDAO;
import com.proj.model.User;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ReadAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("ReadAction.execute");

        List<User> userList = UserDAO.readAllUsers();
        System.out.println("List of users::");
        userList.forEach(System.out::println);
        request.setAttribute("userList", userList);

        return mapping.findForward("success");
    }
}
