package org.andengine.opengl.util;

import java.nio.ByteBuffer;

import org.andengine.util.debug.Debug;
import org.andengine.util.system.SystemUtils;

import android.os.Build;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 23:06:51 - 11.08.2011
 * @see http://code.google.com/p/android/issues/detail?id=11078 //fixed in gingerbread
 * @see http://code.google.com/p/android/issues/detail?id=16941 //fixed in ics
 */
public class BufferUtils {//TODO kidnox check it

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * @param pCapacity the capacity of the returned {@link ByteBuffer} in bytes.
	 * @return
	 */
	public static ByteBuffer allocateDirectByteBuffer(final int pCapacity) {
        return ByteBuffer.allocateDirect(pCapacity);
	}

	public static void freeDirectByteBuffer(final ByteBuffer pByteBuffer) {//TODO check it
//		if(BufferUtils.WORKAROUND_BYTEBUFFER_ALLOCATE_DIRECT) {
//			BufferUtils.jniFreeDirect(pByteBuffer);
//		}
	}


	/**
	 * @param pByteBuffer must be a direct Buffer.
	 * @param pSource
	 * @param pLength to copy in pSource.
	 * @param pOffset in pSource.
	 */
	public static void put(final ByteBuffer pByteBuffer, final float[] pSource, final int pLength, final int pOffset) {
        for(int i = pOffset; i < (pOffset + pLength); i++) {
            pByteBuffer.putFloat(pSource[i]);
        }
		pByteBuffer.position(0);
		pByteBuffer.limit(pLength << 2);
	}

}
