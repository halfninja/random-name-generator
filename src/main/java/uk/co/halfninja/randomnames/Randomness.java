package uk.co.halfninja.randomnames;

import java.util.List;
import java.util.Random;

class Randomness {
	public static final Random random = new Random();
	public static final String random(List<String> strings) {
		return strings.get(random.nextInt(strings.size()));
	}
}
