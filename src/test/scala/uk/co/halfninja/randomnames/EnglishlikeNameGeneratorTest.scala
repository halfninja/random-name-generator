package uk.co.halfninja.randomnames

import org.junit.Test

class EnglishlikeNameGeneratorTest {

	/**
	 * Not actually testing anything here.. just printing things out.
	 * Fun!
	 */
	@Test
	def test() {
		val generator = NameGenerators.standardGenerator()
		(1 to 10).foreach { i =>
			println(generator.generate(Gender.male))
			println(generator.generate(Gender.female))
		}
	}

}
