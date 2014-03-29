package org.andengine.engine.options.resolutionpolicy;

import org.andengine.opengl.view.RenderSurfaceView;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 11:23:00 - 29.03.2010
 */
public class FixedResolutionPolicy extends BaseResolutionPolicy {

	private final int mWidth;
	private final int mHeight;

	public FixedResolutionPolicy(final int pWidth, final int pHeight) {
		this.mWidth = pWidth;
		this.mHeight = pHeight;
	}


	@Override
	public void onMeasure(final RenderSurfaceView pRenderSurfaceView, final int pWidthMeasureSpec, final int pHeightMeasureSpec) {
		pRenderSurfaceView.setMeasuredDimensionProxy(this.mWidth, this.mHeight);
	}

}
