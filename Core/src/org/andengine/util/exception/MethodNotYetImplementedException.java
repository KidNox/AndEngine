package org.andengine.util.exception;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 12:25:52 - 03.11.2011
 */
public class MethodNotYetImplementedException extends AndEngineRuntimeException {
	private static final long serialVersionUID = -4308430823868086531L;

	public MethodNotYetImplementedException() {

	}

	public MethodNotYetImplementedException(final String pMessage) {
		super(pMessage);
	}

	public MethodNotYetImplementedException(final Throwable pThrowable) {
		super(pThrowable);
	}

	public MethodNotYetImplementedException(final String pMessage, final Throwable pThrowable) {
		super(pMessage, pThrowable);
	}

}