package org.andengine.util.animationpack;

import org.andengine.util.texturepack.TexturePackLibrary;


/**
 * (c) Zynga 2012
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 16:58:15 - 03.05.2012
 */
public class AnimationPack {
	private final TexturePackLibrary mTexturePackLibrary;
	private final AnimationPackTiledTextureRegionLibrary mAnimationPackTiledTextureRegionLibrary;


	public AnimationPack(final TexturePackLibrary pTexturePackLibrary, final AnimationPackTiledTextureRegionLibrary pAnimationPackTiledTextureRegionLibrary) {
		this.mTexturePackLibrary = pTexturePackLibrary;
		this.mAnimationPackTiledTextureRegionLibrary = pAnimationPackTiledTextureRegionLibrary;
	}

	public TexturePackLibrary getTexturePackLibrary() {
		return this.mTexturePackLibrary;
	}

	public AnimationPackTiledTextureRegionLibrary getAnimationPackAnimationDataLibrary() {
		return this.mAnimationPackTiledTextureRegionLibrary;
	}

}
