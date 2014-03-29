package org.andengine.opengl.texture.region;

import org.andengine.opengl.texture.ITexture;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 14:29:59 - 08.03.2010
 */
public abstract class BaseTextureRegion implements ITextureRegion {
	protected final ITexture mTexture;

	public BaseTextureRegion(final ITexture pTexture) {
		this.mTexture = pTexture;
	}
	
	@Override
	public abstract ITextureRegion deepCopy();

	@Override
	public ITexture getTexture() {
		return this.mTexture;
	}

}
