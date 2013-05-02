package gamecharacter;

public enum Size {
	FINE,
	DIMINUTIVE,
	TINY,
	SMALL,
	MEDIUM,
	LARGE,
	HUGE,
	GARGANTUAN,
	COLOSSAL;

	public static int getSizeModifier(Size s) {
		switch(s) {
		case FINE: return 8;
		case DIMINUTIVE: return 4;
		case TINY: return 2;
		case SMALL: return 1;
		case MEDIUM: return 0;
		case LARGE: return -1;
		case HUGE: return -2;
		case GARGANTUAN: return -4;
		case COLOSSAL: return -8;
		}
		return 0; /* unreachable */
	}

	public static int getGrappleModifier(Size s) {
		switch(s) {
		case FINE: return -16;
		case DIMINUTIVE: return -12;
		case TINY: return -8;
		case SMALL: return -4;
		case MEDIUM: return 0;
		case LARGE: return 4;
		case HUGE: return 8;
		case GARGANTUAN: return 12;
		case COLOSSAL: return 16;
		}
		return 0; /* unreachable */
	}

	public static int getHideModifier(Size s) {
		switch(s) {
		case FINE: return 16;
		case DIMINUTIVE: return 12;
		case TINY: return 8;
		case SMALL: return 4;
		case MEDIUM: return 0;
		case LARGE: return -4;
		case HUGE: return -8;
		case GARGANTUAN: return -12;
		case COLOSSAL: return -16;
		}
		return 0; /* unreachable */
	}
}