package org.andengine.opengl.shader.source;

import org.andengine.opengl.util.GLState;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 16:26:08 - 10.10.2011
 */
public class StringShaderSource implements IShaderSource {
	private final String mShaderSource;

	public StringShaderSource(final String pShaderSource) {
		this.mShaderSource = pShaderSource;
	}

	@Override
	public String getShaderSource(final GLState pGLState) {
		return this.mShaderSource;
	}

}
