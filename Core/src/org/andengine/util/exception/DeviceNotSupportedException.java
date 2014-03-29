package org.andengine.util.exception;

/**
 * (c) Zynga 2012
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 14:05:09 - 19.03.2012
 */
public class DeviceNotSupportedException extends AndEngineException {
	private static final long serialVersionUID = 2640523490821876076L;

	private final DeviceNotSupportedCause mDeviceNotSupportedCause;

	public DeviceNotSupportedException(final DeviceNotSupportedCause pDeviceNotSupportedCause) {
		super();

		this.mDeviceNotSupportedCause = pDeviceNotSupportedCause;
	}

	public DeviceNotSupportedException(final DeviceNotSupportedCause pDeviceNotSupportedCause, final Throwable pThrowable) {
		super(pThrowable);

		this.mDeviceNotSupportedCause = pDeviceNotSupportedCause;
	}

	public DeviceNotSupportedCause getDeviceNotSupportedCause() {
		return this.mDeviceNotSupportedCause;
	}

	public static enum DeviceNotSupportedCause {
		CODEPATH_INCOMPLETE,
		EGLCONFIG_NOT_FOUND
	}
}
