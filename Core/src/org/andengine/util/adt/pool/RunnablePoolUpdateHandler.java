package org.andengine.util.adt.pool;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 * 
 * @author Valentin Milea
 * @author Nicolas Gramlich
 * 
 * @since 23:03:58 - 21.08.2010
 */
public abstract class RunnablePoolUpdateHandler<T extends RunnablePoolItem> extends PoolUpdateHandler<T> {

	public RunnablePoolUpdateHandler() {

	}

	public RunnablePoolUpdateHandler(final int pInitialPoolSize) {
		super(pInitialPoolSize);
	}

	public RunnablePoolUpdateHandler(final int pInitialPoolSize, final int pGrowth) {
		super(pInitialPoolSize, pGrowth);
	}

	public RunnablePoolUpdateHandler(final int pInitialPoolSize, final int pGrowth, final int pAvailableItemCountMaximum) {
		super(pInitialPoolSize, pGrowth, pAvailableItemCountMaximum);
	}

	@Override
	protected abstract T onAllocatePoolItem();

	@Override
	protected void onHandlePoolItem(final T pRunnablePoolItem) {
		pRunnablePoolItem.run();
	}

}
