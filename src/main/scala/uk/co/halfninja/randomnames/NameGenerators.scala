package uk.co.halfninja.randomnames

object NameGenerators {
	def standardGenerator() =
		CompositeNameGenerator
			.newGenerator()
			.withGenerator("englishlike", new EnglishlikeNameGenerator, 1)
}
