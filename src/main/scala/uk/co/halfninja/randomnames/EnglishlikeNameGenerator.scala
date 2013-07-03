package uk.co.halfninja.randomnames

class EnglishlikeNameGenerator extends NameGenerator {
	import EnglishlikeNameGenerator._
	import Randomness.JRandom

	override def generate(gender: Gender): Name = generate(gender, Randomness.random())
	override def generate(gender: Gender, seed: Long): Name = generate(gender, Randomness.random(seed))
	private def generate(gender: Gender, random: JRandom): Name = {
		val firstName = gender match {
			case Gender.male => Randomness.random(MaleGivenNames, random)
			case Gender.female => Randomness.random(FemaleGivenNames, random)
			case _ => throw new IllegalArgumentException("Non-specific genders are not supported")
		}

		val baseFamilyName = Randomness.random(LastNames, random)
		val familyName = random.nextInt(15) match {
			case 0 if !baseFamilyName.endsWith("on") => baseFamilyName + "son"
			case 1 if !baseFamilyName.endsWith("on") => baseFamilyName + "ton"
			case 2 => Randomness.random(MaleGivenNames, random)
			case 3 => baseFamilyName + "-" + Randomness.random(LastNames, random)
			case 4 => baseFamilyName + "ford"
			case 5 => baseFamilyName + "ham"
			case _ => baseFamilyName
		}

		Name(firstName, familyName)
	}

	override def generate(gender: Gender, mother: Name, father: Name): Name = generate(gender, mother, father, Randomness.random())
	override def generate(gender: Gender, mother: Name, father: Name, seed: Long): Name = generate(gender, mother, father, Randomness.random(seed))
	private def generate(gender: Gender, mother: Name, father: Name, random: JRandom): Name = {
		// TODO inherit surname
		generate(gender, random)
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