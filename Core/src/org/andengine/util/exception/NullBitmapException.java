package org.andengine.util.exception;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 14:52:38 - 16.09.2011
 */
public class NullBitmapException extends AndEngineRuntimeException {
	private static final long serialVersionUID = -2183655622078988389L;

	public NullBitmapException() {

	}

	public NullBitmapException(final String pMessage) {
		super(pMessage);
	}

	public NullBitmapException(final Throwable pThrowable) {
		super(pThrowable);
	}

	public NullBitmapException(final String pMessage, final Throwable pThrowable) {
		super(pMessage, pThrowable);
	}

}
