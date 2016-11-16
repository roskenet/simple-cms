package de.roskenet.simplecms.controller;

import javax.servlet.http.HttpServletRequest;

public interface RequestLogger {

	void writeLog(HttpServletRequest request);

}