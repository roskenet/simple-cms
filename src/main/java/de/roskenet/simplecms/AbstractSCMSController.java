package de.roskenet.simplecms;

import java.util.Map;

import javax.annotation.Resource;

public abstract class AbstractSCMSController {
	@Resource
	private Map<String, String> staticValues;
	
	protected Map<String, String> getStaticValues() {
		return staticValues;
	}
}
