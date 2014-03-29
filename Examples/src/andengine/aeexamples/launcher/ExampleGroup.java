package andengine.aeexamples.launcher;


import andengine.aeexamples.R;

import static andengine.aeexamples.launcher.Example.*;


/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga
 *
 * @author Nicolas Gramlich
 * @since 11:13:34 - 27.06.2010
 */
public enum ExampleGroup {
	// ===========================================================
	// Elements
	// ===========================================================

	SIMPLE(R.string.examplegroup_simple,
			LINE, RECTANGLE, SPRITE, SPRITEREMOVE, SPRITEBATCH),
	MODIFIER_AND_ANIMATION(R.string.examplegroup_modifier_and_animation, 
			MOVINGBALL, ENTITYMODIFIER, ENTITYMODIFIERIRREGULAR, CARDINALSPLINEMOVEMODIFIER, PATHMODIFIER, ANIMATEDSPRITES, EASEFUNCTION, ROTATION3D ),
	TOUCH(R.string.examplegroup_touch, 
			TOUCHDRAG, MULTITOUCH, ANALOGONSCREENCONTROL, DIGITALONSCREENCONTROL, ANALOGONSCREENCONTROLS, COORDINATECONVERSION, PINCHZOOM),
	PARTICLESYSTEM(R.string.examplegroup_particlesystems,
			PARTICLESYSTEMSIMPLE, PARTICLESYSTEMCOOL, PARTICLESYSTEMNEXUS),
	/*MULTIPLAYER(R.string.examplegroup_multiplayer,
			MULTIPLAYER, MULTIPLAYERSERVERDISCOVERY, MULTIPLAYERBLUETOOTH),*/
	PHYSICS(R.string.examplegroup_physics,
			COLLISIONDETECTION, Example.PHYSICS, PHYSICSFIXEDSTEP, PHYSICSCOLLISIONFILTERING, PHYSICSJUMP, PHYSICSREVOLUTEJOINT, PHYSICSMOUSEJOINT, PHYSICSREMOVE),
	TEXT(R.string.examplegroup_text,
			Example.TEXT, TICKERTEXT, CHANGEABLETEXT, TEXTBREAK, CUSTOMFONT, STROKEFONT, BITMAPFONT),
	AUDIO(R.string.examplegroup_audio,
			SOUND, MUSIC /*,MODPLAYER*/),
	ADVANCED(R.string.examplegroup_advanced, 
			SPLITSCREEN, BOUNDCAMERA, HULLALGORITHM), // AUGMENTEDREALITY, AUGMENTEDREALITYHORIZON),
	POSTPROCESSING(R.string.examplegroup_postprocessing, 
			MOTIONSTREAK, RADIALBLUR),
	BACKGROUND(R.string.examplegroup_background, 
			REPEATINGSPRITEBACKGROUND, AUTOPARALLAXBACKGROUND, TMXTILEDMAP),
	OTHER(R.string.examplegroup_other, 
			SCREENCAPTURE, PAUSE, MENU, SUBMENU, TEXTMENU, ZOOM , IMAGEFORMATS, PVRTEXTURE, PVRCCZTEXTURE, PVRGZTEXTURE, ETC1TEXTURE, TEXTUREOPTIONS, CANVASTEXTURECOMPOSITING/*, TEXTUREPACKER*/, COLORKEYTEXTURESOURCEDECORATOR, LOADTEXTURE, UPDATETEXTURE, UNLOADRESOURCES, RUNNABLEPOOLUPDATEHANDLER, SVGTEXTUREREGION, XMLLAYOUT, LEVELLOADER),
	APP(R.string.examplegroup_app,
			APP_CITYRADAR),
	GAME(R.string.examplegroup_game, 
			/*GAME_PONG,*/ GAME_SNAKE, GAME_RACER),
	/*BENCHMARK(R.string.examplegroup_benchmark,
			BENCHMARK_SPRITE, BENCHMARK_ATTACHDETACH, BENCHMARK_ENTITYMODIFIER, BENCHMARK_ANIMATION, BENCHMARK_TICKERTEXT,  BENCHMARK_PARTICLESYSTEM,  BENCHMARK_PHYSICS)*/;

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	public final Example[] mExamples;
	public final int mNameResourceID;

	// ===========================================================
	// Constructors
	// ===========================================================

	private ExampleGroup(final int pNameResourceID, final Example ... pExamples) {
		this.mNameResourceID = pNameResourceID;
		this.mExamples = pExamples;
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

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
