package org.andengine.util.exception;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 18:13:32 - 26.12.2011
 */
public class MethodNotSupportedException extends AndEngineRuntimeException {
	private static final long serialVersionUID = 1248621152476879759L;

	public MethodNotSupportedException() {

	}

	public MethodNotSupportedException(final String pMessage) {
		super(pMessage);
	}

	public MethodNotSupportedException(final Throwable pThrowable) {
		super(pThrowable);
	}

	public MethodNotSupportedException(final String pMessage, final Throwable pThrowable) {
		super(pMessage, pThrowable);
	}

}
