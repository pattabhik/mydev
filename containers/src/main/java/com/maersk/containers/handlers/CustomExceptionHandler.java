package com.maersk.containers.handlers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.maersk.containers.beans.response.ErrorResponseBean;
import com.maersk.containers.exception.DAOException;
import com.maersk.containers.log.LoggerUtil;

/**
 * Controller advice class for handling global exceptions
 * 
 * @author Pattabhi
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(value = WebExchangeBindException.class)
	public ResponseEntity<ErrorResponseBean> bindingErrorsHandler(WebExchangeBindException webExp) {
		ErrorResponseBean errBean = getErrorResponseBean(webExp.getFieldErrors());
		LoggerUtil.error(LOG, webExp, errBean.toString());
		return new ResponseEntity<ErrorResponseBean>(errBean, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorResponseBean> runtimeExceptionHandler(RuntimeException rntmExp) {
		ErrorResponseBean errBean = getErrorResponseBean(null);
		errBean.getErrors().add(rntmExp.getMessage());
		LoggerUtil.error(LOG, rntmExp, errBean.toString());
		return new ResponseEntity<ErrorResponseBean>(errBean, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = DAOException.class)
	public ResponseEntity<ErrorResponseBean> daoExceptionHandler(DAOException daoExp) {
		ErrorResponseBean errBean = getErrorResponseBean(null);
		errBean.getErrors().add(daoExp.getMessage());
		// will not log this as it will be logged already at service layer
		return new ResponseEntity<ErrorResponseBean>(errBean, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ErrorResponseBean getErrorResponseBean(List<FieldError> fldErrors) {
		ErrorResponseBean errBean = new ErrorResponseBean(LocalDateTime.now());
		if (!CollectionUtils.isEmpty(fldErrors)) {
			final List<String> errorList = fldErrors.stream().map(fldError -> fldError.getDefaultMessage())
					.collect(Collectors.toList());
			errBean.setErrors(errorList);
		}
		return errBean;
	}

}
