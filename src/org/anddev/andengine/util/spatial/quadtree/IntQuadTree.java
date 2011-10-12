package org.anddev.andengine.util.spatial.quadtree;

import java.util.LinkedList;
import java.util.List;

import org.anddev.andengine.util.IMatcher;
import org.anddev.andengine.util.spatial.ISpatialItem;
import org.anddev.andengine.util.spatial.adt.bounds.BoundsSplit;
import org.anddev.andengine.util.spatial.adt.bounds.BoundsSplit.BoundsSplitException;
import org.anddev.andengine.util.spatial.adt.bounds.IIntBounds;
import org.anddev.andengine.util.spatial.adt.bounds.IntBounds;
import org.anddev.andengine.util.spatial.adt.bounds.util.IntBoundsUtils;


/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 20:22:18 - 10.10.2011
 */
public class IntQuadTree<T extends ISpatialItem<IIntBounds>> extends QuadTree<IIntBounds, T> {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private final IntBounds mQueryIntBounds = new IntBounds(0, 0, 0, 0);

	// ===========================================================
	// Constructors
	// ===========================================================

	public IntQuadTree(final IIntBounds pIntBounds) {
		super(pIntBounds);
	}

	public IntQuadTree(final IIntBounds pIntBounds, final int pMaxLevel) {
		super(pIntBounds, pMaxLevel);
	}

	@Override
	protected IntQuadTreeNode initRoot(final IIntBounds pIntBounds) {
		return new IntQuadTreeNode(QuadTree.LEVEL_ROOT, pIntBounds);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public synchronized List<T> query(final int pX, final int pY) {
		return this.query(pX, pY, new LinkedList<T>());
	}

	public synchronized List<T> query(final int pX, final int pY, final List<T> pResult) {
		this.mQueryIntBounds.set(pX, pY);
		return this.query(this.mQueryIntBounds, pResult);
	}

	public synchronized List<T> query(final int pX, final int pY, final IMatcher<T> pMatcher) {
		return this.query(pX, pY, pMatcher, new LinkedList<T>());
	}

	public synchronized List<T> query(final int pX, final int pY, final IMatcher<T> pMatcher, final List<T> pResult) {
		this.mQueryIntBounds.set(pX, pY);
		return this.query(this.mQueryIntBounds, pMatcher, pResult);
	}

	public synchronized List<T> query(final int pXMin, final int pYMin, final int pXMax, final int pYMax) {
		return this.query(pXMin, pYMin, pXMax, pYMax, new LinkedList<T>());
	}

	public synchronized List<T> query(final int pXMin, final int pYMin, final int pXMax, final int pYMax, final List<T> pResult) {
		this.mQueryIntBounds.set(pXMin, pYMin, pXMax, pYMax);
		return this.query(this.mQueryIntBounds, pResult);
	}

	public synchronized List<T> query(final int pXMin, final int pYMin, final int pXMax, final int pYMax, final IMatcher<T> pMatcher) {
		return this.query(pXMin, pYMin, pXMax, pYMax, pMatcher, new LinkedList<T>());
	}

	public synchronized List<T> query(final int pXMin, final int pYMin, final int pXMax, final int pYMax, final IMatcher<T> pMatcher, final List<T> pResult) {
		this.mQueryIntBounds.set(pXMin, pYMin, pXMax, pYMax);
		return this.query(this.mQueryIntBounds, pMatcher, pResult);
	}

	public synchronized boolean containsAny(final int pX, final int pY) {
		this.mQueryIntBounds.set(pX, pY);
		return this.containsAny(this.mQueryIntBounds);
	}

	public synchronized boolean containsAny(final int pXMin, final int pYMin, final int pXMax, final int pYMax) {
		this.mQueryIntBounds.set(pXMin, pYMin, pXMax, pYMax);
		return this.containsAny(this.mQueryIntBounds);
	}

	public synchronized boolean containsAny(final int pX, final int pY, final IMatcher<T> pMatcher) {
		this.mQueryIntBounds.set(pX, pY);
		return this.containsAny(this.mQueryIntBounds, pMatcher);
	}

	public synchronized boolean containsAny(final int pXMin, final int pYMin, final int pXMax, final int pYMax, final IMatcher<T> pMatcher) {
		this.mQueryIntBounds.set(pXMin, pYMin, pXMax, pYMax);
		return this.containsAny(this.mQueryIntBounds, pMatcher);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

	public class IntQuadTreeNode extends QuadTreeNode {
		// ===========================================================
		// Constants
		// ===========================================================

		// ===========================================================
		// Fields
		// ===========================================================

		private final int mXMin;
		private final int mYMin;
		private final int mXMax;
		private final int mYMax;

		// ===========================================================
		// Constructors
		// ===========================================================

		public IntQuadTreeNode(final int pLevel, final IIntBounds pIntBounds) {
			this(pLevel, pIntBounds.getXMin(), pIntBounds.getYMin(), pIntBounds.getXMax(), pIntBounds.getYMax());
		}

		public IntQuadTreeNode(final int pLevel, final int pXMin, final int pYMin, final int pXMax, final int pYMax) {
			super(pLevel);

			this.mXMin = pXMin;
			this.mYMin = pYMin;
			this.mXMax = pXMax;
			this.mYMax = pYMax;

			if(pXMin > pXMax) {
				throw new IllegalArgumentException("pXMin must be smaller or equal to pXMax.");
			}
			if(pYMin > pYMax) {
				throw new IllegalArgumentException("pYMin must be smaller or equal to pYMax.");
			}
		}

		// ===========================================================
		// Getter & Setter
		// ===========================================================

		public int getXMin() {
			return this.mXMin;
		}
		
		public int getYMin() {
			return this.mYMin;
		}

		public int getXMax() {
			return this.mXMax;
		}

		public int getYMax() {
			return this.mYMax;
		}

		public int getWidth() {
			return this.mXMax - this.mXMin + 1;
		}

		public int getHeight() {
			return this.mYMax - this.mYMin + 1;
		}

		// ===========================================================
		// Methods for/from SuperClass/Interfaces
		// ===========================================================

		@Override
		protected IntQuadTreeNode split(final BoundsSplit pBoundsSplit) {
			final int width = this.getWidth();
			final int height = this.getHeight();

			if(width <= 2 && height <= 2) {
				throw new BoundsSplitException();
			}

			final int xMin = this.getXMin(pBoundsSplit);
			final int yMin = this.getYMin(pBoundsSplit);
			final int xMax = this.getXMax(pBoundsSplit);
			final int yMax = this.getYMax(pBoundsSplit);

			return new IntQuadTreeNode(this.mLevel + 1, xMin, yMin, xMax, yMax);
		}

		@Override
		protected boolean contains(final IIntBounds pIntBounds) {
			return this.contains(pIntBounds.getXMin(), pIntBounds.getYMin(), pIntBounds.getXMax(), pIntBounds.getYMax());
		}

		@Override
		protected boolean contains(final BoundsSplit pBoundsSplit, final IIntBounds pIntBounds) {
			return IntBoundsUtils.contains(this.getXMin(pBoundsSplit), this.getYMin(pBoundsSplit), this.getXMax(pBoundsSplit), this.getYMax(pBoundsSplit), pIntBounds.getXMin(), pIntBounds.getYMin(), pIntBounds.getXMax(), pIntBounds.getYMax());
		}

		@Override
		protected boolean intersects(final IIntBounds pIntBounds) {
			return IntBoundsUtils.intersects(this.mXMin, this.mYMin, this.mXMax, this.mYMax, pIntBounds.getXMin(), pIntBounds.getYMin(), pIntBounds.getXMax(), pIntBounds.getYMax());
		}

		@Override
		protected boolean intersects(final IIntBounds pIntBoundsA, final IIntBounds pIntBoundsB) {
			return IntBoundsUtils.intersects(pIntBoundsA, pIntBoundsB);
		}

		@Override
		protected boolean containedBy(final IIntBounds pBounds) {
			return IntBoundsUtils.contains(pBounds.getXMin(), pBounds.getYMin(), pBounds.getXMax(), pBounds.getYMax(), this.mXMin, this.mYMin, this.mXMax, this.mYMax);
		}

		@Override
		protected void appendBoundsToString(final StringBuilder pStringBuilder) {
			pStringBuilder
				.append("[XMin: ")
				.append(this.mXMin)
				.append(", YMin: ")
				.append(this.mYMin)
				.append(", XMax: ")
				.append(this.mXMax)
				.append(", YMax: ")
				.append(this.mYMax)
				.append("]");
		}

		// ===========================================================
		// Methods
		// ===========================================================

		private int getXMin(final BoundsSplit pBoundsSplit) {
			final int width = this.getWidth();
			final int halfWidth = width / 2;

			if(width <= 2) {
				switch(pBoundsSplit) {
					case TOP_LEFT:
					case BOTTOM_LEFT:
						return this.mXMin;
					case BOTTOM_RIGHT:
					case TOP_RIGHT:
						throw new BoundsSplitException();
					default:
						throw new IllegalArgumentException("Unexpected " + BoundsSplit.class.getSimpleName() + ": '" + pBoundsSplit + "'.");
				}
			} else {
				switch(pBoundsSplit) {
					case TOP_LEFT:
						return this.mXMin;
					case TOP_RIGHT:
						return this.mXMin + halfWidth;
					case BOTTOM_LEFT:
						return this.mXMin;
					case BOTTOM_RIGHT:
						return this.mXMin + halfWidth;
					default:
						throw new IllegalArgumentException("Unexpected " + BoundsSplit.class.getSimpleName() + ": '" + pBoundsSplit + "'.");
				}
			}
		}
		
		private int getYMin(final BoundsSplit pBoundsSplit) {
			final int height = this.getHeight();
			final int halfHeight = height / 2;
			
			if(height <= 2) {
				switch(pBoundsSplit) {
					case TOP_LEFT:
					case TOP_RIGHT:
						return  this.mYMin;
					case BOTTOM_LEFT:
					case BOTTOM_RIGHT:
						throw new BoundsSplitException();
					default:
						throw new IllegalArgumentException("Unexpected " + BoundsSplit.class.getSimpleName() + ": '" + pBoundsSplit + "'.");
				}
			} else {
				switch(pBoundsSplit) {
					case TOP_LEFT:
						return  this.mYMin;
					case TOP_RIGHT:
						return this.mYMin;
					case BOTTOM_LEFT:
						return this.mYMin + halfHeight;
					case BOTTOM_RIGHT:
						return this.mYMin + halfHeight;
					default:
						throw new IllegalArgumentException("Unexpected " + BoundsSplit.class.getSimpleName() + ": '" + pBoundsSplit + "'.");
				}
			}
		}

		private int getXMax(final BoundsSplit pBoundsSplit) {
			final int width = this.getWidth();
			final int halfWidth = width / 2;

			if(width <= 2) {
				switch(pBoundsSplit) {
					case TOP_LEFT:
					case BOTTOM_LEFT:
						return this.mXMax;
					case BOTTOM_RIGHT:
					case TOP_RIGHT:
						throw new BoundsSplitException();
					default:
						throw new IllegalArgumentException("Unexpected " + BoundsSplit.class.getSimpleName() + ": '" + pBoundsSplit + "'.");
				}
			} else {
				switch(pBoundsSplit) {
					case TOP_LEFT:
						return this.mXMin + halfWidth;
					case TOP_RIGHT:
						return this.mXMax;
					case BOTTOM_LEFT:
						return this.mXMin + halfWidth;
					case BOTTOM_RIGHT:
						return this.mXMax;
					default:
						throw new IllegalArgumentException("Unexpected " + BoundsSplit.class.getSimpleName() + ": '" + pBoundsSplit + "'.");
				}
			}
		}

		private int getYMax(final BoundsSplit pBoundsSplit) {
			final int height = this.getHeight();
			final int halfHeight = height / 2;

			if(height <= 2) {
				switch(pBoundsSplit) {
					case TOP_LEFT:
					case TOP_RIGHT:
						return this.mYMax;
					case BOTTOM_LEFT:
					case BOTTOM_RIGHT:
						throw new BoundsSplitException();
					default:
						throw new IllegalArgumentException("Unexpected " + BoundsSplit.class.getSimpleName() + ": '" + pBoundsSplit + "'.");
				}
			} else {
				switch(pBoundsSplit) {
					case TOP_LEFT:
						return this.mYMin + halfHeight;
					case TOP_RIGHT:
						return this.mYMin + halfHeight;
					case BOTTOM_LEFT:
						return this.mYMax;
					case BOTTOM_RIGHT:
						return this.mYMax;
					default:
						throw new IllegalArgumentException("Unexpected " + BoundsSplit.class.getSimpleName() + ": '" + pBoundsSplit + "'.");
				}
			}
		}

		public boolean intersects(final int pXMin, final int pYMin, final int pXMax, final int pYMax) {
			return IntBoundsUtils.intersects(this.mXMin, this.mYMin, this.mXMax, this.mYMax, pXMin, pYMin, pXMax, pYMax);
		}

		public boolean contains(final int pXMin, final int pYMin, final int pXMax, final int pYMax) {
			return IntBoundsUtils.contains(this.mXMin, this.mYMin, this.mXMax, this.mYMax, pXMin, pYMin, pXMax, pYMax);
		}

		// ===========================================================
		// Inner and Anonymous Classes
		// ===========================================================
	}
}