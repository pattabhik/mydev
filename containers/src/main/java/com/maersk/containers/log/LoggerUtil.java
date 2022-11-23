package com.maersk.containers.log;

import org.slf4j.Logger;

/**
 * @author Pattabhi
 *
 */
public class LoggerUtil {

	public static void debug(final Logger log, final Object excp, final String mesage) {
		if (log.isDebugEnabled()) {
			log.debug(mesage, excp);
		}
	}

	public static void debug(final Logger log, final String mesage) {
		if (log.isDebugEnabled()) {
			log.debug(mesage);
		}
	}

	public static void info(final Logger log, final String mesage) {
		if (log.isInfoEnabled()) {
			log.info(mesage);
		}
	}

	public static void info(final Logger log, final Object excp, final String mesage) {
		if (log.isInfoEnabled()) {
			log.info(mesage, excp);
		}
	}

	public static void error(final Logger log, final String mesage) {
		if (log.isErrorEnabled()) {
			log.error(mesage);
		}
	}

	public static void error(final Logger log, final Object excp, final String mesage) {
		if (log.isErrorEnabled()) {
			log.error(mesage, excp);
		}
	}

}
