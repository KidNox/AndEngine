package org.andengine.opengl.font.exception;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 12:19:24 - 03.11.2011
 */
public class LetterNotFoundException extends FontException {
	private static final long serialVersionUID = 5260601170771253529L;

	public LetterNotFoundException() {
		super();
	}

	public LetterNotFoundException(final String pMessage) {
		super(pMessage);
	}

	public LetterNotFoundException(final Throwable pThrowable) {
		super(pThrowable);
	}

	public LetterNotFoundException(final String pMessage, final Throwable pThrowable) {
		super(pMessage, pThrowable);
	}

}
