package uk.co.halfninja.randomnames;

public class NameGenerators {
	public static final CompositeNameGenerator standardGenerator() {
		return CompositeNameGenerator
				.newGenerator()
				.withGenerator("englishlike", new EnglishlikeNameGenerator(), 1);
	}
}
