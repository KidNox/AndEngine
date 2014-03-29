package org.andengine.opengl.shader.exception;

import org.andengine.util.exception.AndEngineRuntimeException;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 02:33:27 - 07.08.2011
 */
public class ShaderProgramException extends AndEngineRuntimeException {
	private static final long serialVersionUID = 2377158902169370516L;


	public ShaderProgramException(final String pMessage) {
		super(pMessage);
	}

	public ShaderProgramException(final String pMessage, final ShaderProgramException pShaderProgramException) {
		super(pMessage, pShaderProgramException);
	}

}