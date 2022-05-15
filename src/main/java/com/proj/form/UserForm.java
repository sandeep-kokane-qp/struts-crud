package com.proj.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
public class UserForm extends ActionForm {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String city;

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors actionErrors = new ActionErrors();
        if (firstName.trim().equals("")) {
            actionErrors.add("firstName_e", new ActionMessage("msg.error.firstName"));
        }
        if (lastName.trim().equals("")) {
            actionErrors.add("lastName_e", new ActionMessage("msg.error.lastName"));
        }
        if (email.trim().equals("")) {
            actionErrors.add("email_e", new ActionMessage("msg.error.email"));
        }
        if (city.trim().equals("")) {
            actionErrors.add("city_e", new ActionMessage("msg.error.city"));
        }

        return actionErrors;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }
}
