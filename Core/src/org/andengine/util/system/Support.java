package org.andengine.util.system;

import org.andengine.opengl.view.ConfigChooser;
import org.andengine.util.exception.DeviceNotSupportedException;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class Support {
    public static boolean isDeviceSupported() {
        try {
            checkDeviceSupported();
            return true;
        } catch (final DeviceNotSupportedException e) {
            return false;
        }
    }

    public static void checkDeviceSupported() throws DeviceNotSupportedException {
        checkOpenGLSupport();
    }

    private static void checkOpenGLSupport() throws DeviceNotSupportedException {
        checkEGLConfigChooserSupport();
    }

    private static void checkEGLConfigChooserSupport() throws DeviceNotSupportedException {
		/* Get an EGL instance. */
        final EGL10 egl = (EGL10) EGLContext.getEGL();

		/* Get to the default display. */
        final EGLDisplay eglDisplay = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);

		/* We can now initialize EGL for that display. */
        final int[] version = new int[2];
        egl.eglInitialize(eglDisplay, version);

        final ConfigChooser configChooser = new ConfigChooser(false); // TODO Doesn't correlate to possible multisampling request in EngineOptions...

        try {
            configChooser.chooseConfig(egl, eglDisplay);
        } catch (final IllegalArgumentException e) {
            throw new DeviceNotSupportedException(DeviceNotSupportedException.DeviceNotSupportedCause.EGLCONFIG_NOT_FOUND, e);
        }
    }
}
