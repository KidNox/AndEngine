package org.andengine.util.adt.pool;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Valentin Milea
 * @author Nicolas Gramlich
 * 
 * @since 23:02:47 - 21.08.2010
 */
public abstract class PoolItem {

	Pool<? extends PoolItem> mParent;
	boolean mRecycled = true;

	public Pool<? extends PoolItem> getParent() {
		return this.mParent;
	}

	public boolean isRecycled() {
		return this.mRecycled;
	}

	public boolean isFromPool(final Pool<? extends PoolItem> pPool) {
		return pPool == this.mParent;
	}

	protected void onRecycle() {}

	protected void onObtain() {}

	public void recycle() {
		if(this.mParent == null) {
			throw new IllegalStateException("Item already recycled!");
		}

		this.mParent.recycle(this);
	}

}