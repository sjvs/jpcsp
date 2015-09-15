/*
This file is part of jpcsp.

Jpcsp is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Jpcsp is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jpcsp.  If not, see <http://www.gnu.org/licenses/>.
 */
package jpcsp.HLE.modules;

import jpcsp.HLE.HLEFunction;
import jpcsp.HLE.HLEModule;
import jpcsp.HLE.HLEUnimplemented;
import jpcsp.HLE.TPointer32;
import jpcsp.HLE.Modules;
import jpcsp.HLE.kernel.types.SceKernelErrors;
import jpcsp.hardware.Battery;
import jpcsp.settings.Settings;

import org.apache.log4j.Logger;

public class sceImpose extends HLEModule {
    public static Logger log = Modules.getLogger("sceImpose");

	@Override
	public String getName() {
		return "sceImpose";
	}

	@Override
    public void start() {
        languageMode_language = Settings.getInstance().readInt("emu.impose.language", PSP_LANGUAGE_ENGLISH);
        languageMode_button = Settings.getInstance().readInt("emu.impose.button", PSP_CONFIRM_BUTTON_CROSS);

        super.start();
    }

    public final static int PSP_LANGUAGE_JAPANESE = 0;
    public final static int PSP_LANGUAGE_ENGLISH = 1;
    public final static int PSP_LANGUAGE_FRENCH = 2;
    public final static int PSP_LANGUAGE_SPANISH = 3;
    public final static int PSP_LANGUAGE_GERMAN = 4;
    public final static int PSP_LANGUAGE_ITALIAN = 5;
    public final static int PSP_LANGUAGE_DUTCH = 6;
    public final static int PSP_LANGUAGE_PORTUGUESE = 7;
    public final static int PSP_LANGUAGE_RUSSIAN = 8;
    public final static int PSP_LANGUAGE_KOREAN = 9;
    public final static int PSP_LANGUAGE_TRADITIONAL_CHINESE = 10;
    public final static int PSP_LANGUAGE_SIMPLIFIED_CHINESE = 11;
    private int languageMode_language;

    public final static int PSP_CONFIRM_BUTTON_CIRCLE = 0;
    public final static int PSP_CONFIRM_BUTTON_CROSS = 1;
    private int languageMode_button;

    public final static int PSP_UMD_POPUP_DISABLE = 0;
    public final static int PSP_UMD_POPUP_ENABLE = 1;
    private int umdPopupStatus;

    private int backlightOffTime;

	public static final int PSP_IMPOSE_MAIN_VOLUME            = 0x1;
	public static final int PSP_IMPOSE_BACKLIGHT_BRIGHTNESS   = 0x2;
	public static final int PSP_IMPOSE_EQUALIZER_MODE         = 0x4;
	public static final int PSP_IMPOSE_MUTE                   = 0x8;
	public static final int PSP_IMPOSE_AVLS                   = 0x10;
	public static final int PSP_IMPOSE_TIME_FORMAT            = 0x20;
	public static final int PSP_IMPOSE_DATE_FORMAT            = 0x40;
	public static final int PSP_IMPOSE_LANGUAGE               = 0x80;
	public static final int PSP_IMPOSE_BACKLIGHT_OFF_INTERVAL = 0x200;
	public static final int PSP_IMPOSE_SOUND_REDUCTION        = 0x400;
	public static final int PSP_IMPOSE_UMD_POPUP_ENABLED      = 1;
	public static final int PSP_IMPOSE_UMD_POPUP_DISABLED     = 0;

    @HLEUnimplemented
	@HLEFunction(nid = 0x381BD9E7, version = 150)
	public int sceImposeHomeButton() {
		return 0;
	}

    @HLEUnimplemented
	@HLEFunction(nid = 0x5595A71A, version = 150)
	public int sceImposeSetHomePopup() {
		return 0;
	}

    @HLEUnimplemented
	@HLEFunction(nid = 0x0F341BE4, version = 150)
	public int sceImposeGetHomePopup() {
		return 0;
	}

	@HLEFunction(nid = 0x72189C48, version = 150)
	public int sceImposeSetUMDPopup(int mode) {
        umdPopupStatus = mode;
        
        return 0;
	}

	@HLEFunction(nid = 0xE0887BC8, version = 150)
	public int sceImposeGetUMDPopup() {
		return umdPopupStatus;
	}

	@HLEFunction(nid = 0x36AA6E91, version = 150)
	public int sceImposeSetLanguageMode(int lang, int button) {
        if (log.isDebugEnabled()) {
            String langStr;
            switch (lang) {
                case PSP_LANGUAGE_JAPANESE: langStr = "JAP"; break;
                case PSP_LANGUAGE_ENGLISH: langStr = "ENG"; break;
                case PSP_LANGUAGE_FRENCH: langStr = "FR"; break;
                case PSP_LANGUAGE_KOREAN: langStr = "KOR"; break;
                default: langStr = "PSP_LANGUAGE_UNKNOWN" + lang; break;
            }

        	log.debug(String.format("sceImposeSetLanguageMode lang=%d(%s), button=%d", lang, langStr, button));
        }

        languageMode_language = lang;
        languageMode_button = button;

		return 0;
	}

    @HLEFunction(nid = 0x24FD7BCF, version = 150)
    public int sceImposeGetLanguageMode(TPointer32 langPtr, TPointer32 buttonPtr) {
    	if (log.isDebugEnabled()) {
	    	log.debug(String.format("sceImposeGetLanguageMode langPtr=%s, buttonPtr=%s returning lang=%d, button=%d", langPtr, buttonPtr, languageMode_language, languageMode_button));
    	}

        langPtr.setValue(languageMode_language);
        buttonPtr.setValue(languageMode_button);

        return 0;
    }

	@HLEFunction(nid = 0x8C943191, version = 150)
	public int sceImposeGetBatteryIconStatus(TPointer32 chargingPtr, TPointer32 iconStatusPtr) {
		int batteryPowerPercent = Battery.getCurrentPowerPercent();

        // Possible values for iconStatus: 0..3
        int iconStatus = Math.min(batteryPowerPercent / 25, 3);
        boolean charging = Battery.isCharging();

        chargingPtr.setValue(charging ? 1 : 0);
        iconStatusPtr.setValue(iconStatus);

		return 0;
	}

    @HLEFunction(nid = 0x8F6E3518, version = 150)
    public int sceImposeGetBacklightOffTime() {
		return backlightOffTime;
	}

    @HLEFunction(nid = 0x967F6D4A, version = 150)
    public int sceImposeSetBacklightOffTime(int time) {
        backlightOffTime = time;

		return 0;
	}

	@HLEFunction(nid = 0x531C9778, version = 352)
	public int sceImposeGetParam(int param) {
		int value = 0;

		switch (param) {
			case PSP_IMPOSE_MAIN_VOLUME:
				// Return value [0..30]?
				value = 30;
				break;
			case PSP_IMPOSE_BACKLIGHT_BRIGHTNESS:
			case PSP_IMPOSE_EQUALIZER_MODE:
			case PSP_IMPOSE_MUTE:
			case PSP_IMPOSE_AVLS:
			case PSP_IMPOSE_TIME_FORMAT:
			case PSP_IMPOSE_DATE_FORMAT:
			case PSP_IMPOSE_LANGUAGE:
			case PSP_IMPOSE_BACKLIGHT_OFF_INTERVAL:
			case PSP_IMPOSE_SOUND_REDUCTION:
				log.warn(String.format("sceImposeGetParam param=0x%X not implemented", param));
				break;
			default:
				log.warn(String.format("sceImposeGetParam param=0x%X invalid parameter", param));
				return SceKernelErrors.ERROR_INVALID_MODE;
		}

		return value;
	}

	@HLEFunction(nid = 0x810FB7FB, version = 352)
	public int sceImposeSetParam(int param, int value) {
		switch (param) {
			case PSP_IMPOSE_MAIN_VOLUME:
			case PSP_IMPOSE_BACKLIGHT_BRIGHTNESS:
			case PSP_IMPOSE_EQUALIZER_MODE:
			case PSP_IMPOSE_MUTE:
			case PSP_IMPOSE_AVLS:
			case PSP_IMPOSE_TIME_FORMAT:
			case PSP_IMPOSE_DATE_FORMAT:
			case PSP_IMPOSE_LANGUAGE:
			case PSP_IMPOSE_BACKLIGHT_OFF_INTERVAL:
			case PSP_IMPOSE_SOUND_REDUCTION:
				log.warn(String.format("sceImposeSetParam param=0x%X, value=0x%X not implemented", param, value));
				break;
			default:
				log.warn(String.format("sceImposeSetParam param=0x%X, value=0x%X invalid parameter", param, value));
				return SceKernelErrors.ERROR_INVALID_MODE;
		}

		return 0;
	}
}