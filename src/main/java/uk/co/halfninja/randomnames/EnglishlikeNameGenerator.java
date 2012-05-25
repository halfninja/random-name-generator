package uk.co.halfninja.randomnames;

import java.util.Arrays;
import java.util.List;
import static uk.co.halfninja.randomnames.Randomness.*;

public class EnglishlikeNameGenerator implements NameGenerator {

	private static final List<String> maleGivenNames = Arrays.asList("Kevin","Dave","David","Alan","Derek","Paul","Nick","Mark","Sam","Dan","Robert","Gavin","Terry","Barry","Rahul","Steve","John","Naeem","Harris");
	private static final List<String> femaleGivenNames = Arrays.asList("Natalie","Sarah","Deidre","Gladys","Penny","Rebecca","Grace","Kelly","Sally","Maggie","Kate","Kathryn");
	private static final List<String> lastNames = Arrays.asList("Jones","Smith","Baker","Havilland","Partridge","Rogers","Magnets","Trains","Rafferty","O'Toole","Hattes","Borde","Thorpe","Gravis","Twerp","Dingle","Schist","Granite","Evans","Gravel","Doon","Yaris","Corby","Toast","Greens","Havers"); 
	
	@Override
	public Name generate(Gender gender) {
		String firstName;
		if (gender == Gender.male) {
			firstName = random(maleGivenNames);
		} else if (gender == Gender.female) {
			firstName = random(femaleGivenNames);
		} else {
			throw new IllegalArgumentException("Nonspecific genders not supported by this generator");
		}
		
		String familyName = random(lastNames);
		final int i = random.nextInt(15);
		switch (i) {
		case 0:
			familyName += "son"; break;
		case 1:
			familyName += "ton"; break;
		case 2:
			familyName = random(maleGivenNames); break;
		case 3:
			familyName += "-" + random(lastNames); break;
		case 4:
			familyName += "ford"; break;
		case 5:
			familyName += "ham"; break;
		}
		
		return new Name(firstName, familyName);
	}

	@Override
	public Name generate(Gender gender, Name mother, Name father) {
		// TODO inherit surname
		return generate(gender);
	}

}
