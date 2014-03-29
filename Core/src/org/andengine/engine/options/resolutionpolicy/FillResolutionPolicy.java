package org.andengine.engine.options.resolutionpolicy;

import org.andengine.opengl.view.RenderSurfaceView;

import android.view.View.MeasureSpec;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 11:22:48 - 29.03.2010
 */
public class FillResolutionPolicy extends BaseResolutionPolicy {

	@Override
	public void onMeasure(final RenderSurfaceView pRenderSurfaceView, final int pWidthMeasureSpec, final int pHeightMeasureSpec) {
		BaseResolutionPolicy.throwOnNotMeasureSpecEXACTLY(pWidthMeasureSpec, pHeightMeasureSpec);

		final int measuredWidth = MeasureSpec.getSize(pWidthMeasureSpec);
		final int measuredHeight = MeasureSpec.getSize(pHeightMeasureSpec);

		pRenderSurfaceView.setMeasuredDimensionProxy(measuredWidth, measuredHeight);
	}
}
