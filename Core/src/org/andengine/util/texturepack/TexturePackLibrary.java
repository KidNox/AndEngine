package org.andengine.util.texturepack;

import java.util.HashMap;

/**
 * (c) Zynga 2012
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 17:29:37 - 03.05.2012
 */
public class TexturePackLibrary {

	private final HashMap<String, TexturePack> mTexturePackMapping = new HashMap<String, TexturePack>();
	private final HashMap<String, TexturePackTextureRegion> mTexturePackTextureRegionSourceMapping = new HashMap<String, TexturePackTextureRegion>();


	public void put(final String pID, final TexturePack pTexturePack) {
		this.mTexturePackMapping.put(pID, pTexturePack);
		this.mTexturePackTextureRegionSourceMapping.putAll(pTexturePack.getTexturePackTextureRegionLibrary().getSourceMapping());
	}

	public TexturePackTextureRegion getTexturePackTextureRegion(final String pTexturePackTextureRegionSource) {
		return this.mTexturePackTextureRegionSourceMapping.get(pTexturePackTextureRegionSource);
	}

}