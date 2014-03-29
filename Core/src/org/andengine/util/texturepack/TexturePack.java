package org.andengine.util.texturepack;

import org.andengine.opengl.texture.ITexture;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 23:23:47 - 30.07.2011
 */
public class TexturePack {

	private final ITexture mTexture;
	private final TexturePackTextureRegionLibrary mTexturePackTextureRegionLibrary;

	public TexturePack(final ITexture pTexture, final TexturePackTextureRegionLibrary pTexturePackTextureRegionLibrary) {
		this.mTexture = pTexture;
		this.mTexturePackTextureRegionLibrary = pTexturePackTextureRegionLibrary;
	}

	public ITexture getTexture() {
		return this.mTexture;
	}

	public TexturePackTextureRegionLibrary getTexturePackTextureRegionLibrary() {
		return this.mTexturePackTextureRegionLibrary;
	}

	public void loadTexture() {
		this.mTexture.load();
	}

	public void unloadTexture() {
		this.mTexture.unload();
	}

}