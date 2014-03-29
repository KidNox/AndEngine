package org.andengine.engine.options;

import android.os.PowerManager;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 19:45:23 - 10.07.2010
 */
public enum WakeLockOptions {

	/** Screen is on at full brightness. Keyboard backlight is on at full brightness. Requires <b>WAKE_LOCK</b> permission! */
	BRIGHT(PowerManager.FULL_WAKE_LOCK),
	/** Screen is on at full brightness. Keyboard backlight will be allowed to go off. Requires <b>WAKE_LOCK</b> permission!*/
    @SuppressWarnings("deprecation")SCREEN_BRIGHT(PowerManager.SCREEN_BRIGHT_WAKE_LOCK),
	/** Screen is on but may be dimmed. Keyboard backlight will be allowed to go off. Requires <b>WAKE_LOCK</b> permission!*/
	SCREEN_DIM(PowerManager.SCREEN_DIM_WAKE_LOCK),
	/** Screen is on at full brightness. Does <b>not</b> require <b>WAKE_LOCK</b> permission! */
	SCREEN_ON(-1);

	private final int mFlag;

	private WakeLockOptions(final int pFlag) {
		this.mFlag = pFlag;
	}

	public int getFlag() {
		return this.mFlag;
	}

}
