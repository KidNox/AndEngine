package org.andengine.util.exception;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 02:40:26 - 07.08.2011
 */
public class AndEngineException extends Exception {
	private static final long serialVersionUID = 6577340337732194722L;

	public AndEngineException() {
		super();
	}

	public AndEngineException(final String pMessage) {
		super(pMessage);
	}

	public AndEngineException(final Throwable pThrowable) {
		super(pThrowable);
	}

	public AndEngineException(final String pMessage, final Throwable pThrowable) {
		super(pMessage, pThrowable);
	}

}
