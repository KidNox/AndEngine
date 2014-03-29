package org.andengine.opengl.exception;

import org.andengine.util.exception.AndEngineRuntimeException;

/**
 * (c) Zynga 2012
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 11:59:45 AM - Feb 13, 2012
 */
public class RenderTextureInitializationException extends AndEngineRuntimeException {
	private static final long serialVersionUID = -7219303294648252076L;


	public RenderTextureInitializationException() {
		super();
	}

	public RenderTextureInitializationException(final String pMessage) {
		super(pMessage);
	}

	public RenderTextureInitializationException(final Throwable pThrowable) {
		super(pThrowable);
	}

	public RenderTextureInitializationException(final String pMessage, final Throwable pThrowable) {
		super(pMessage, pThrowable);
	}

}
