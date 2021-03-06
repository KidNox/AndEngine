package org.andengine.util.algorithm.path.astar;

import org.andengine.util.algorithm.path.IPathFinderMap;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 22:58:01 - 16.08.2010
 */
public class NullHeuristic<T> implements IAStarHeuristic<T> {

	@Override
	public float getExpectedRestCost(final IPathFinderMap<T> pPathFinderMap, final T pEntity, final int pFromX, final int pFromY, final int pToX, final int pToY) {
		return 0;
	}

}
