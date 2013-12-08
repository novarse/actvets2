package org.smwillsdev.actvets.lookup;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.smwillsdev.actvets.type.AuState;

@Named
@ApplicationScoped
public class AuStateList implements Serializable {

	private static final long serialVersionUID = 1L;

	public AuState[] getStates() {
		return AuState.values();

	}
}
