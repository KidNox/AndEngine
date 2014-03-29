package org.andengine.opengl.vbo.attribute;


/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 14:22:06 - 15.08.2011
 */
public class VertexBufferObjectAttributes {

	private final int mStride;
	private final VertexBufferObjectAttribute[] mVertexBufferObjectAttributes;

	public VertexBufferObjectAttributes(final int pStride, final VertexBufferObjectAttribute ... pVertexBufferObjectAttributes) {
		this.mVertexBufferObjectAttributes = pVertexBufferObjectAttributes;
		this.mStride = pStride;
	}

	public void glVertexAttribPointers() {
		final VertexBufferObjectAttribute[] vertexBufferObjectAttributes = this.mVertexBufferObjectAttributes;

		final int stride = this.mStride;

		final int vertexBufferObjectAttributeCount = vertexBufferObjectAttributes.length;
		for(int i = 0; i < vertexBufferObjectAttributeCount; i++) {
			vertexBufferObjectAttributes[i].glVertexAttribPointer(stride);
		}
	}

}