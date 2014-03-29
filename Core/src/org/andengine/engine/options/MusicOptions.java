package org.andengine.engine.options;


/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 23:13:07 - 22.11.2011
 */
public class MusicOptions {

	private boolean mNeedsMusic;

	public boolean needsMusic() {
		return this.mNeedsMusic;
	}

	public MusicOptions setNeedsMusic(final boolean pNeedsMusic) {
		this.mNeedsMusic = pNeedsMusic;
		return this;
	}

}
