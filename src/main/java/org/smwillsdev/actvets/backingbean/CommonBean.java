package org.smwillsdev.actvets.backingbean;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.smwillsdev.actvets.view.util.FacesUtils;

@Named
@SessionScoped
public class CommonBean implements Serializable {

	private static final String HOME = "home";

	private static final String HISTORIC_EVENTS = "historicEvents";

	private static final String FUTURE_EVENTS = "futureEvents";

	private static final String ADMIN_REGISTER_XHTML = "/adminRegister.xhtml";

	private static final String ADMIN_LOGIN_XHTML = "/adminLogin.xhtml";

	private static final String ADMIN_XHTML = "/admin.xhtml";

	private static final long serialVersionUID = 1L;

	private String currentPage;

	private boolean futureEventsExpanded;

	private boolean historicEventsExpanded;

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

	public boolean showShrink(String blockId) {
		if (FUTURE_EVENTS.equals(blockId)) {
			return futureEventsExpanded;
		} else if (HISTORIC_EVENTS.equals(blockId)) {
			return historicEventsExpanded;
		} else {
			return false;
		}
	}

	public boolean showExpand(String blockId) {
		if (FUTURE_EVENTS.equals(blockId)) {
			return !futureEventsExpanded;
		} else if (HISTORIC_EVENTS.equals(blockId)) {
			return !historicEventsExpanded;
		} else {
			return false;
		}
	}

	public boolean isShowClose() {
		return ADMIN_XHTML.equals(currentPage)
				|| ADMIN_REGISTER_XHTML.equals(currentPage)
				|| ADMIN_LOGIN_XHTML.equals(currentPage);
	}

	public void doExpand(String blockId) {
		if (FUTURE_EVENTS.equals(blockId)) {
			futureEventsExpanded = true;
		} else if (HISTORIC_EVENTS.equals(blockId)) {
			historicEventsExpanded = true;
		}
	}

	public String doClose(String blockId) {
		return HOME;
	}

	public void doShrink(String blockId) {
		if (FUTURE_EVENTS.equals(blockId)) {
			futureEventsExpanded = false;
		} else if (HISTORIC_EVENTS.equals(blockId)) {
			historicEventsExpanded = false;
		}

	}

	public void showGrowl(String msg) {
		FacesUtils.displayMessage(msg);
	}
}
