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

	public static void displayMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(message);
		FacesContext context = FacesContext.getCurrentInstance();
		String clientId = "messages";
		context.addMessage(clientId, facesMessage);
	}

	public static void popupMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(message);
		FacesContext context = FacesContext.getCurrentInstance();
		String clientId = "growl";
		context.addMessage(clientId, facesMessage);
	}

	public static void displayMessage(String clientId, String summary,
			String detail) {
		FacesMessage facesMessage = new FacesMessage(summary, detail);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(clientId, facesMessage);
	}

	public static void displayError(String clientId, String summary,
			String detail) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(clientId, facesMessage);
	}

}
