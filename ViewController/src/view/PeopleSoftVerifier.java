package view;

import java.io.Serializable;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

public class PeopleSoftVerifier  {
    
    private String token;
    private String userName;


    private String resolveEl(String data) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, data, Object.class);
        String Message = valueExp.getValue(elContext).toString();
        return Message;
    }
    public PeopleSoftVerifier() {
    }
    
    public void verifyToken() {
        
        // String localPeopleSoftToken = "kokos"; // 
        String localPeopleSoftToken = resolveEl("#{pageFlowScope.token}");
        this.setToken(localPeopleSoftToken);
        System.out.println("authenticated "+localPeopleSoftToken);
        
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
