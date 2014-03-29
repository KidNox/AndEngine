package org.andengine.extension.physics.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.shape.IAreaShape;
import org.andengine.entity.shape.IShape;
import org.andengine.util.Constants;
import org.andengine.util.math.MathUtils;

import java.util.List;

import static org.andengine.extension.physics.box2d.util.constants.PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 13:59:03 - 15.07.2010
 */
public class PhysicsFactory {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	/**
	 * create FixtureDef based on parameters given
	 * @param pDensity
	 * @param pElasticity
	 * @param pFriction
	 * @return
	 */
	public static FixtureDef createFixtureDef(final float pDensity, final float pElasticity, final float pFriction) {
		return PhysicsFactory.createFixtureDef(pDensity, pElasticity, pFriction, false);
	}

	/**
	 * create FixtureDef based on parameters given
	 * @param pDensity
	 * @param pElasticity
	 * @param pFriction
	 * @param pSensor
	 * @return
	 */
	public static FixtureDef createFixtureDef(final float pDensity, final float pElasticity, final float pFriction, final boolean pSensor) {
		final FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.density = pDensity;
		fixtureDef.restitution = pElasticity;
		fixtureDef.friction = pFriction;
		fixtureDef.isSensor = pSensor;
		return fixtureDef;
	}

	/**
	 * create FixtureDef based on parameters given
	 * @param pDensity
	 * @param pElasticity
	 * @param pFriction
	 * @param pSensor
	 * @param pCategoryBits
	 * @param pMaskBits
	 * @param pGroupIndex
	 * @return
	 */
	public static FixtureDef createFixtureDef(final float pDensity, final float pElasticity, final float pFriction, final boolean pSensor, final short pCategoryBits, final short pMaskBits, final short pGroupIndex) {
		final FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.density = pDensity;
		fixtureDef.restitution = pElasticity;
		fixtureDef.friction = pFriction;
		fixtureDef.isSensor = pSensor;
		final Filter filter = fixtureDef.filter;
		filter.categoryBits = pCategoryBits;
		filter.maskBits = pMaskBits;
		filter.groupIndex = pGroupIndex;
		return fixtureDef;
	}

	/**
	 * create Body of box shape
	 * @param pPhysicsWorld
	 * @param pAreaShape
	 * @param pBodyType
	 * @param pFixtureDef
	 * @return
	 */
	public static Body createBoxBody(final PhysicsWorld pPhysicsWorld, final IAreaShape pAreaShape, final BodyType pBodyType, final FixtureDef pFixtureDef) {
		return PhysicsFactory.createBoxBody(pPhysicsWorld, pAreaShape, pBodyType, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	/**
	 * create Body of box shape
	 * @param pPhysicsWorld
	 * @param pAreaShape
	 * @param pBodyType
	 * @param pFixtureDef
	 * @param pPixelToMeterRatio
	 * @return
	 */
	public static Body createBoxBody(final PhysicsWorld pPhysicsWorld, final IAreaShape pAreaShape, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final float[] sceneCenterCoordinates = pAreaShape.getSceneCenterCoordinates();
		final float centerX = sceneCenterCoordinates[Constants.VERTEX_INDEX_X];
		final float centerY = sceneCenterCoordinates[Constants.VERTEX_INDEX_Y];
		return PhysicsFactory.createBoxBody(pPhysicsWorld, centerX, centerY, pAreaShape.getWidthScaled(), pAreaShape.getHeightScaled(), pAreaShape.getRotation(), pBodyType, pFixtureDef, pPixelToMeterRatio);
	}

	/**
	 * create Body of box shape
	 * @param pPhysicsWorld
	 * @param pCenterX
	 * @param pCenterY
	 * @param pWidth
	 * @param pHeight
	 * @param pBodyType
	 * @param pFixtureDef
	 * @return
	 */
	public static Body createBoxBody(final PhysicsWorld pPhysicsWorld, final float pCenterX, final float pCenterY, final float pWidth, final float pHeight, final BodyType pBodyType, final FixtureDef pFixtureDef) {
		return PhysicsFactory.createBoxBody(pPhysicsWorld, pCenterX, pCenterY, pWidth, pHeight, 0, pBodyType, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	/**
	 * create Body of box shape
	 * @param pPhysicsWorld
	 * @param pCenterX
	 * @param pCenterY
	 * @param pWidth
	 * @param pHeight
	 * @param pRotation
	 * @param pBodyType
	 * @param pFixtureDef
	 * @return
	 */
	public static Body createBoxBody(final PhysicsWorld pPhysicsWorld, final float pCenterX, final float pCenterY, final float pWidth, final float pHeight, final float pRotation, final BodyType pBodyType, final FixtureDef pFixtureDef) {
		return PhysicsFactory.createBoxBody(pPhysicsWorld, pCenterX, pCenterY, pWidth, pHeight, pRotation, pBodyType, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	/**
	 * create Body of box shape
	 * @param pPhysicsWorld
	 * @param pCenterX
	 * @param pCenterY
	 * @param pWidth
	 * @param pHeight
	 * @param pBodyType
	 * @param pFixtureDef
	 * @param pPixelToMeterRatio
	 * @return
	 */
	public static Body createBoxBody(final PhysicsWorld pPhysicsWorld, final float pCenterX, final float pCenterY, final float pWidth, final float pHeight, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		return PhysicsFactory.createBoxBody(pPhysicsWorld, pCenterX, pCenterY, pWidth, pHeight, 0, pBodyType, pFixtureDef, pPixelToMeterRatio);
	}

	/**
	 * create Body of box shape
	 * @param pPhysicsWorld
	 * @param pCenterX
	 * @param pCenterY
	 * @param pWidth
	 * @param pHeight
	 * @param pRotation
	 * @param pBodyType
	 * @param pFixtureDef
	 * @param pPixelToMeterRatio
	 * @return
	 */
	public static Body createBoxBody(final PhysicsWorld pPhysicsWorld, final float pCenterX, final float pCenterY, final float pWidth, final float pHeight, final float pRotation, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final BodyDef boxBodyDef = new BodyDef();
		boxBodyDef.type = pBodyType;

		boxBodyDef.position.x = pCenterX / pPixelToMeterRatio;
		boxBodyDef.position.y = pCenterY / pPixelToMeterRatio;

		final Body boxBody = pPhysicsWorld.createBody(boxBodyDef);

		final PolygonShape boxPoly = new PolygonShape();

		final float halfWidth = pWidth * 0.5f / pPixelToMeterRatio;
		final float halfHeight = pHeight * 0.5f / pPixelToMeterRatio;

		boxPoly.setAsBox(halfWidth, halfHeight);
		pFixtureDef.shape = boxPoly;

		boxBody.createFixture(pFixtureDef);

		boxPoly.dispose();

		boxBody.setTransform(boxBody.getWorldCenter(), MathUtils.degToRad(pRotation));

		return boxBody;
	}

	/**
	 * create Body of circle shape
	 * @param pPhysicsWorld
	 * @param pAreaShape
	 * @param pBodyType
	 * @param pFixtureDef
	 * @return
	 */
	public static Body createCircleBody(final PhysicsWorld pPhysicsWorld, final IAreaShape pAreaShape, final BodyType pBodyType, final FixtureDef pFixtureDef) {
		return PhysicsFactory.createCircleBody(pPhysicsWorld, pAreaShape, pBodyType, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	/**
	 * create Body of circle shape
	 * @param pPhysicsWorld
	 * @param pAreaShape
	 * @param pBodyType
	 * @param pFixtureDef
	 * @param pPixelToMeterRatio
	 * @return
	 */
	public static Body createCircleBody(final PhysicsWorld pPhysicsWorld, final IAreaShape pAreaShape, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final float[] sceneCenterCoordinates = pAreaShape.getSceneCenterCoordinates();
		final float centerX = sceneCenterCoordinates[Constants.VERTEX_INDEX_X];
		final float centerY = sceneCenterCoordinates[Constants.VERTEX_INDEX_Y];
		return PhysicsFactory.createCircleBody(pPhysicsWorld, centerX, centerY, pAreaShape.getWidthScaled() * 0.5f, pAreaShape.getRotation(), pBodyType, pFixtureDef, pPixelToMeterRatio);
	}

	/**
	 * create Body of circle shape
	 * @param pPhysicsWorld
	 * @param pCenterX
	 * @param pCenterY
	 * @param pRadius
	 * @param pBodyType
	 * @param pFixtureDef
	 * @return
	 */
	public static Body createCircleBody(final PhysicsWorld pPhysicsWorld, final float pCenterX, final float pCenterY, final float pRadius, final BodyType pBodyType, final FixtureDef pFixtureDef) {
		return createCircleBody(pPhysicsWorld, pCenterX, pCenterY, pRadius, 0, pBodyType, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	/**
	 * create Body of circle shape
	 * @param pPhysicsWorld
	 * @param pCenterX
	 * @param pCenterY
	 * @param pRadius
	 * @param pRotation
	 * @param pBodyType
	 * @param pFixtureDef
	 * @return
	 */
	public static Body createCircleBody(final PhysicsWorld pPhysicsWorld, final float pCenterX, final float pCenterY, final float pRadius, final float pRotation, final BodyType pBodyType, final FixtureDef pFixtureDef) {
		return createCircleBody(pPhysicsWorld, pCenterX, pCenterY, pRadius, pRotation, pBodyType, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	/**
	 * create Body of circle shape
	 * @param pPhysicsWorld
	 * @param pCenterX
	 * @param pCenterY
	 * @param pRadius
	 * @param pBodyType
	 * @param pFixtureDef
	 * @param pPixelToMeterRatio
	 * @return
	 */
	public static Body createCircleBody(final PhysicsWorld pPhysicsWorld, final float pCenterX, final float pCenterY, final float pRadius, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		return createCircleBody(pPhysicsWorld, pCenterX, pCenterY, pRadius, 0, pBodyType, pFixtureDef, pPixelToMeterRatio);
	}

	/**
	 * create Body of circle shape
	 * @param pPhysicsWorld
	 * @param pCenterX
	 * @param pCenterY
	 * @param pRadius
	 * @param pRotation
	 * @param pBodyType
	 * @param pFixtureDef
	 * @param pPixelToMeterRatio
	 * @return
	 */
	public static Body createCircleBody(final PhysicsWorld pPhysicsWorld, final float pCenterX, final float pCenterY, final float pRadius, final float pRotation, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final BodyDef circleBodyDef = new BodyDef();
		circleBodyDef.type = pBodyType;

		circleBodyDef.position.x = pCenterX / pPixelToMeterRatio;
		circleBodyDef.position.y = pCenterY / pPixelToMeterRatio;

		circleBodyDef.angle = MathUtils.degToRad(pRotation);

		final Body circleBody = pPhysicsWorld.createBody(circleBodyDef);

		final CircleShape circlePoly = new CircleShape();
		pFixtureDef.shape = circlePoly;

		final float radius = pRadius / pPixelToMeterRatio;
		circlePoly.setRadius(radius);

		circleBody.createFixture(pFixtureDef);

		circlePoly.dispose();

		return circleBody;
	}

	/**
	 * deprecated, left for backward compatibility
	 */
	public static Body createLineBody(final PhysicsWorld pPhysicsWorld, final Line pLine, final FixtureDef pFixtureDef) {
		return PhysicsFactory.createLineBody(pPhysicsWorld, pLine, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	/**
	 * deprecated, left for backward compatibility
	 */
	public static Body createLineBody(final PhysicsWorld pPhysicsWorld, final Line pLine, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final float[] sceneCoordinates = pLine.convertLocalToSceneCoordinates(0, 0);
		final float x1 = sceneCoordinates[Constants.VERTEX_INDEX_X];
		final float y1 = sceneCoordinates[Constants.VERTEX_INDEX_Y];
		
		pLine.convertLocalToSceneCoordinates(pLine.getX2() - pLine.getX1(), pLine.getY2() - pLine.getY1());
		final float x2 = sceneCoordinates[Constants.VERTEX_INDEX_X];
		final float y2 = sceneCoordinates[Constants.VERTEX_INDEX_Y];
		
		return PhysicsFactory.createLineBody(pPhysicsWorld, x1, y1, x2, y2, pFixtureDef, pPixelToMeterRatio);
	}
	
	/**
	 * deprecated, left for backward compatibility
	 */
	public static Body createLineBody(final PhysicsWorld pPhysicsWorld, final float pX1, final float pY1, final float pX2, final float pY2, final FixtureDef pFixtureDef) {
		return PhysicsFactory.createLineBody(pPhysicsWorld, pX1, pY1, pX2, pY2, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	/**
	 * deprecated, left for backward compatibility
	 */
	public static Body createLineBody(final PhysicsWorld pPhysicsWorld, final float pX1, final float pY1, final float pX2, final float pY2, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final BodyDef lineBodyDef = new BodyDef();
		lineBodyDef.type = BodyType.StaticBody;
		
		final Body boxBody = pPhysicsWorld.createBody(lineBodyDef);
		
		final EdgeShape linePoly = new EdgeShape();
		
		linePoly.set(new Vector2(pX1 / pPixelToMeterRatio, pY1 / pPixelToMeterRatio), new Vector2(pX2 / pPixelToMeterRatio, pY2 / pPixelToMeterRatio));
		pFixtureDef.shape = linePoly;
		
		boxBody.createFixture(pFixtureDef);
		
		linePoly.dispose();
		
		return boxBody;
	}

	/**
	 * @param pPhysicsWorld
	 * @param pShape
	 * @param pVertices are to be defined relative to the center of the pShape and have the {@link org.andengine.extension.physics.box2d.util.constants.PhysicsConstants#PIXEL_TO_METER_RATIO_DEFAULT} applied.
	 * @param pBodyType
	 * @param pFixtureDef
	 * @return
	 */
	public static Body createPolygonBody(final PhysicsWorld pPhysicsWorld, final IShape pShape, final Vector2[] pVertices, final BodyType pBodyType, final FixtureDef pFixtureDef) {
		return PhysicsFactory.createPolygonBody(pPhysicsWorld, pShape, pVertices, pBodyType, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	/**
	 * @param pPhysicsWorld
	 * @param pShape
	 * @param pVertices are to be defined relative to the center of the pShape.
	 * @param pBodyType
	 * @param pFixtureDef
	 * @return
	 */
	public static Body createPolygonBody(final PhysicsWorld pPhysicsWorld, final IShape pShape, final Vector2[] pVertices, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final BodyDef boxBodyDef = new BodyDef();
		boxBodyDef.type = pBodyType;

		final float[] sceneCenterCoordinates = pShape.getSceneCenterCoordinates();
		boxBodyDef.position.x = sceneCenterCoordinates[Constants.VERTEX_INDEX_X] / pPixelToMeterRatio;
		boxBodyDef.position.y = sceneCenterCoordinates[Constants.VERTEX_INDEX_Y] / pPixelToMeterRatio;

		final Body boxBody = pPhysicsWorld.createBody(boxBodyDef);

		final PolygonShape boxPoly = new PolygonShape();

		boxPoly.set(pVertices);
		pFixtureDef.shape = boxPoly;

		boxBody.createFixture(pFixtureDef);

		boxPoly.dispose();

		return boxBody;
	}

	/**
	 * @param pPhysicsWorld
	 * @param pShape
	 * @param pTriangleVertices are to be defined relative to the center of the pShape and have the {@link org.andengine.extension.physics.box2d.util.constants.PhysicsConstants#PIXEL_TO_METER_RATIO_DEFAULT} applied.
	 * @param pBodyType
	 * @param pFixtureDef
	 * @return
	 */
	public static Body createTrianglulatedBody(final PhysicsWorld pPhysicsWorld, final IShape pShape, final List<Vector2> pTriangleVertices, final BodyType pBodyType, final FixtureDef pFixtureDef) {
		return PhysicsFactory.createTrianglulatedBody(pPhysicsWorld, pShape, pTriangleVertices, pBodyType, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	/**
	 * @param pPhysicsWorld
	 * @param pShape
	 * @param pTriangleVertices are to be defined relative to the center of the pShape and have the {@link org.andengine.extension.physics.box2d.util.constants.PhysicsConstants#PIXEL_TO_METER_RATIO_DEFAULT} applied.
	 * 					The vertices will be triangulated and for each triangle a {@link com.badlogic.gdx.physics.box2d.Fixture} will be created.
	 * @param pBodyType
	 * @param pFixtureDef
	 * @return
	 */
	public static Body createTrianglulatedBody(final PhysicsWorld pPhysicsWorld, final IShape pShape, final List<Vector2> pTriangleVertices, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final Vector2[] TMP_TRIANGLE = new Vector2[3];

		final BodyDef boxBodyDef = new BodyDef();
		boxBodyDef.type = pBodyType;

		final float[] sceneCenterCoordinates = pShape.getSceneCenterCoordinates();
		boxBodyDef.position.x = sceneCenterCoordinates[Constants.VERTEX_INDEX_X] / pPixelToMeterRatio;
		boxBodyDef.position.y = sceneCenterCoordinates[Constants.VERTEX_INDEX_Y] / pPixelToMeterRatio;

		final Body boxBody = pPhysicsWorld.createBody(boxBodyDef);

		final int vertexCount = pTriangleVertices.size();
		for(int i = 0; i < vertexCount; /* */) {
			final PolygonShape boxPoly = new PolygonShape();

			TMP_TRIANGLE[2] = pTriangleVertices.get(i++);
			TMP_TRIANGLE[1] = pTriangleVertices.get(i++);
			TMP_TRIANGLE[0] = pTriangleVertices.get(i++);

			boxPoly.set(TMP_TRIANGLE);
			pFixtureDef.shape = boxPoly;

			boxBody.createFixture(pFixtureDef);

			boxPoly.dispose();
		}

		return boxBody;
	}

	/**
	 * Box2D introduced ChainShape - this method creates body for it
	 * @param pPhysicsWorld
	 * @param vertices
	 * @param pBodyType
	 * @param pFixtureDef
	 * @param pPixelToMeterRatio
	 * @return
	 */
	public static Body createChainBody(final PhysicsWorld pPhysicsWorld, final Vector2[] vertices, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		return PhysicsFactory.createChainBody(pPhysicsWorld, 0, 0, vertices, 0, pBodyType, pFixtureDef, pPixelToMeterRatio);
	}

	/**
	 * Box2D introduced ChainShape - this method creates body for it
	 * @param pPhysicsWorld
	 * @param pCenterX
	 * @param pCenterY
	 * @param vertices
	 * @param pRotation
	 * @param pBodyType
	 * @param pFixtureDef
	 * @param pPixelToMeterRatio
	 * @return
	 */
	public static Body createChainBody(final PhysicsWorld pPhysicsWorld, final float pCenterX, final float pCenterY, final Vector2[] vertices, final float pRotation, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final BodyDef chainBodyDef = new BodyDef();

		chainBodyDef.type = pBodyType;
		chainBodyDef.position.x = pCenterX / pPixelToMeterRatio;
		chainBodyDef.position.y = pCenterY / pPixelToMeterRatio;
		chainBodyDef.angle = MathUtils.degToRad(pRotation);

		final Body chainBody = pPhysicsWorld.createBody(chainBodyDef);
		final ChainShape chainPoly = new ChainShape();

		pFixtureDef.shape = chainPoly;
		chainPoly.createChain(vertices);
		chainBody.createFixture(pFixtureDef);
		chainPoly.dispose();

		return chainBody;
	}

	/**
	 * Box2D introduced EdgeShape instead of LineShape
	 * @param pPhysicsWorld
	 * @param v1
	 * @param v2
	 * @param pBodyType
	 * @param pFixtureDef
	 * @param pPixelToMeterRatio
	 * @return
	 */
	public static Body createEdgeBody(final PhysicsWorld pPhysicsWorld, final Vector2 v1, final Vector2 v2, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		return PhysicsFactory.createEdgeBody(pPhysicsWorld, 0, 0, v1, v2, 0, pBodyType, pFixtureDef, pPixelToMeterRatio);
	}

	/**
	 * Box2D introduced EdgeShape instead of LineShape
	 * @param pPhysicsWorld
	 * @param pCenterX
	 * @param pCenterY
	 * @param v1
	 * @param v2
	 * @param pRotation
	 * @param pBodyType
	 * @param pFixtureDef
	 * @param pPixelToMeterRatio
	 * @return
	 */
	public static Body createEdgeBody(final PhysicsWorld pPhysicsWorld, final float pCenterX, final float pCenterY, final Vector2 v1, final Vector2 v2, final float pRotation, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final BodyDef edgeBodyDef = new BodyDef();

		edgeBodyDef.type = pBodyType;
		edgeBodyDef.position.x = pCenterX / pPixelToMeterRatio;
		edgeBodyDef.position.y = pCenterY / pPixelToMeterRatio;
		edgeBodyDef.angle = MathUtils.degToRad(pRotation);

		final Body edgeBody = pPhysicsWorld.createBody(edgeBodyDef);
		final EdgeShape edgePoly = new EdgeShape();

		pFixtureDef.shape = edgePoly;
		edgePoly.set(v1, v2);
		edgeBody.createFixture(pFixtureDef);
		edgePoly.dispose();

		return edgeBody;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
