package org.smwillsdev.actvets.view.util;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {

	public static Object getManagedBean(String beanName) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elc = fc.getELContext();
		ExpressionFactory ef = fc.getApplication().getExpressionFactory();
		ValueExpression ve = ef.createValueExpression(elc, getJsfEl(beanName),
				Object.class);
		return ve.getValue(elc);

	}

	private static String getJsfEl(String value) {
		return "#{" + value + "}";
	}

	public static void addErrorMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(message);
		FacesContext context = FacesContext.getCurrentInstance();
		String clientId = null;
		context.addMessage(clientId, facesMessage);
	}

}
