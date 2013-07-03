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
			case 0 if !baseFamilyName.endsWith("on") => baseFamilyName + "son"
			case 1 if !baseFamilyName.endsWith("on") => baseFamilyName + "ton"
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
		"David", "James", "Andrew",	"John", "Michael", "Paul", "Matthew", "Mark", "Chris", "Richard",
		"Tom", "Alex", "Daniel", "Peter", "Ben", "Robert", "Christopher", "Thomas", "Stephen", "Adam",
		"Simon", "Jonathan", "Ian", "Jack", "Sam", "Martin", "Matt", "George", "Nick", "Joe"
	)

	val FemaleGivenNames = Seq(
		"Sarah", "Emma", "Laura", "Rachel", "Helen", "Claire", "Emily", "Hannah", "Rebecca", "Sophie",
		"Charlotte", "Anna", "Lucy", "Amy", "Catherine", "Jennifer", "Katie", "Jane", "Kate", "Elizabeth",
		"Julie", "Louise", "Susan", "Maria", "Karen", "Caroline", "Alison", "Lisa", "Nicola", "Jessica"
	)

	val LastNames = Seq(
		"Smith", "Jones", "Patel", "Williams", "Brown", "Davies", "Taylor", "Lee", "Evans", "Harris", "Shah", 
		"White", "Wilson", "Johnson", "Khan", "Clarke", "Thomas", "Lewis", "Roberts", "Walker", "Thompson", 
		"Wright", "Edwards", "Davis", "Moore", "Ward", "Chan", "Cooper", "Green", "Robinson", "King", "Turner", 
		"Jackson", "Wood", "Hughes", "Martin", "Baker", "Hall", "Bennett", "Mitchell", "Shaw", "Hill", "Clark", 
		"Parker", "Watson", "Scott", "James", "Wong", "Morris", "Cox"
	)

}