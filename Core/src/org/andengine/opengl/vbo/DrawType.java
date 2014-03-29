package org.andengine.opengl.vbo;

import android.opengl.GLES20;

/**
 * (c) Zynga 2012
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 15:41:14 - 27.03.2012
 */
public enum DrawType {

	STATIC(GLES20.GL_STATIC_DRAW),
	DYNAMIC(GLES20.GL_DYNAMIC_DRAW),
	STREAM(GLES20.GL_STREAM_DRAW);

	private final int mUsage;

	private DrawType(final int pUsage) {
		this.mUsage = pUsage;
	}

	public int getUsage() {
		return this.mUsage;
	}

}