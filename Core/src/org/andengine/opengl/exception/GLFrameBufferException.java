package org.andengine.opengl.exception;


/**
 * (c) Zynga 2012
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 10:47:22 - 13.02.2012
 */
public class GLFrameBufferException extends GLException {
	private static final long serialVersionUID = -8910272713633644676L;

	public GLFrameBufferException(final int pError) {
		super(pError);
	}

	public GLFrameBufferException(final int pError, final String pString) {
		super(pError, pString);
	}

}
