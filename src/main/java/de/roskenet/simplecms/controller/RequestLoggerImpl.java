package de.roskenet.simplecms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;

import de.roskenet.simplecms.entity.Logging;
import de.roskenet.simplecms.repository.LoggingRepository;

@Component
public class RequestLoggerImpl implements RequestLogger {

	@Autowired
	private LoggingRepository loggingRepository;
	
	/* (non-Javadoc)
	 * @see de.roskenet.simplecms.controller.RequestLogger#writeLog(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void writeLog(final HttpServletRequest request) {
		Logging logging = mapRequestToLogging(request);
		loggingRepository.save(logging);
	}

	private static Logging mapRequestToLogging(HttpServletRequest request) {
		Logging logging = new Logging();
		logging.setMethod(request.getMethod());
		logging.setUrl((String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
		logging.setAgent((String) request.getHeader("User-Agent"));
		logging.setIp(request.getRemoteAddr());
		return logging;
	}
}
