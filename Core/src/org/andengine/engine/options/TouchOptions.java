package org.andengine.engine.options;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 23:18:06 - 22.11.2011
 */
public class TouchOptions {

	private static final long TOUCHEVENT_INTERVAL_MILLISECONDS_DEFAULT = 20;

	private boolean mNeedsMultiTouch;
	private long mTouchEventIntervalMilliseconds = TouchOptions.TOUCHEVENT_INTERVAL_MILLISECONDS_DEFAULT;


	public boolean needsMultiTouch() {
		return this.mNeedsMultiTouch;
	}

	public TouchOptions setNeedsMultiTouch(final boolean pNeedsMultiTouch) {
		this.mNeedsMultiTouch = pNeedsMultiTouch;
		return this;
	}

	public long getTouchEventIntervalMilliseconds() {
		return this.mTouchEventIntervalMilliseconds;
	}

	public void setTouchEventIntervalMilliseconds(final long pTouchEventIntervalMilliseconds) {
		this.mTouchEventIntervalMilliseconds = pTouchEventIntervalMilliseconds;
	}

}
