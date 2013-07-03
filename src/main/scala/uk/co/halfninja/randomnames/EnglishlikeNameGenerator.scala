package uk.co.halfninja.randomnames

import uk.co.halfninja.randomnames.Randomness._

class EnglishlikeNameGenerator extends NameGenerator {
	import EnglishlikeNameGenerator._

	override def generate(gender: Gender) = {
		val firstName = gender match {
			case Gender.male => random(MaleGivenNames)
			case Gender.female => random(FemaleGivenNames)
			case _ => throw new IllegalArgumentException("Non-specific genders are not supported")
		}

		val baseFamilyName = random(LastNames)
		val familyName = random.nextInt(15) match {
			case 0 => baseFamilyName + "son"
			case 1 => baseFamilyName + "ton"
			case 2 => random(MaleGivenNames)
			case 3 => baseFamilyName + "-" + random(LastNames)
			case 4 => baseFamilyName + "ford"
			case 5 => baseFamilyName + "ham"
			case _ => baseFamilyName
		}

		Name(firstName, familyName)
	}

	override def generate(gender: Gender, mother: Name, father: Name) = {
		// TODO inherit surname
		generate(gender)
	}

}

object EnglishlikeNameGenerator {

	val MaleGivenNames = Seq(
		"Kevin","Dave","David","Alan","Derek","Paul","Nick","Mark","Sam","Dan","Robert","Gavin","Terry","Barry","Rahul","Steve","John","Naeem","Harris"
	)

	val FemaleGivenNames = Seq(
		"Natalie","Sarah","Deidre","Gladys","Penny","Rebecca","Grace","Kelly","Sally","Maggie","Kate","Kathryn"
	)

	val LastNames = Seq(
		"Jones","Smith","Baker","Havilland","Partridge","Rogers","Magnets","Trains","Rafferty","O'Toole","Hattes","Borde","Thorpe","Gravis","Twerp","Dingle","Schist",
		"Granite","Evans","Gravel","Doon","Yaris","Corby","Toast","Greens","Havers"
	)

}