package com.phone.erp.base.exception.bussiness;

/**
 * [断言失败异常]
 * 
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class AssertFailedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AssertFailedException() {
		super();
	}

	public AssertFailedException(String errorMsg) {
		super(errorMsg);
	}

	public AssertFailedException(String errorMsg, Throwable t) {
		super(errorMsg, t);
	}

}
