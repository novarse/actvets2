package org.smwillsdev.actvets.backingbean;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class CommonBean implements Serializable {

	private static final String ADMIN_REGISTER_XHTML = "/adminRegister.xhtml";

	private static final String ADMIN_LOGIN_XHTML = "/adminLogin.xhtml";

	private static final String ADMIN_XHTML = "/admin.xhtml";

	private static final long serialVersionUID = 1L;

	private String currentPage;

	public void pageLoad() throws IOException {
		if (!FacesContext.getCurrentInstance().isPostback()) {

			setCurrentPage(getPageName());

		}
	}

	/**
	 * Returns name of currently selected page with preceding "/", e.g.
	 * "/residency.html".
	 * 
	 * @return
	 */
	private String getPageName() {
		return FacesContext.getCurrentInstance().getViewRoot().getViewId();
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isShowShrink() {
		return false;
	}

	public boolean isShowExpand() {
		return false;
	}

	public boolean isShowClose() {
		return ADMIN_XHTML.equals(currentPage)
				|| ADMIN_REGISTER_XHTML.equals(currentPage)
				|| ADMIN_LOGIN_XHTML.equals(currentPage);
	}

}
