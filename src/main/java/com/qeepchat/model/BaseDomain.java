package com.qeepchat.model;

import javax.persistence.Transient;



public class BaseDomain {
@Transient
public String errorMessage;
public String errorCode;
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}

}
