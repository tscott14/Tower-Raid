package utils;

public class Time {

	private long now = 0;
	private int factor = 0;
	private double t = 0;

	public void wait(double _t, String _type, boolean reset) {
		if (_type.equals("ms")) {
			factor = 1;
		} else if (_type.equals("s")) {
			factor = 1000;
		} else if (_type.equals("m")) {
			factor = 60000;
		} else if (_type.equals("h")) {
			factor = 3600000;
		} else {
			return;
		}
		t = _t;

		if (reset) {
			reset();
		}

	}

	public void reset() {
		now = System.currentTimeMillis() + ((int) t * factor);
	}

	public boolean isTimeUp() {
		return System.currentTimeMillis() - now >= 0;
	}

}
