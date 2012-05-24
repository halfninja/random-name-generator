package uk.co.halfninja.randomnames;

import org.junit.Test;

import uk.co.halfninja.randomnames.Gender;
import uk.co.halfninja.randomnames.NameGenerator;
import uk.co.halfninja.randomnames.NameGenerators;

public class EnglishlikeNameGeneratorTest {

	/**
	 * Not actually testing anything here.. just printing things out.
	 * Fun!
	 */
	@Test
	public void test() {
		NameGenerator generator = NameGenerators.standardGenerator();
		for (int i=0; i<10; i++) {
			System.out.println( generator.generate(Gender.male) );
			System.out.println( generator.generate(Gender.female) );
		}
	}

}
