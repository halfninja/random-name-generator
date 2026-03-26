package uk.co.halfninja.randomnames

import java.util.Random

class EnglishlikeNameGenerator : NameGenerator {

    override fun generate(gender: Gender): Name = generate(gender, Randomness.random())
    override fun generate(gender: Gender, seed: Long): Name = generate(gender, Randomness.random(seed))

    private fun generate(gender: Gender, random: Random): Name {
        val firstName = when (gender) {
            is Gender.Male -> Randomness.random(MaleGivenNames, random)
            is Gender.Female -> Randomness.random(FemaleGivenNames, random)
            is Gender.Nonspecific -> throw IllegalArgumentException("Non-specific genders are not supported")
        }

        val baseFamilyName = Randomness.random(LastNames, random)
        val roll = random.nextInt(15)
        val familyName = when {
            roll == 0 && !baseFamilyName.endsWith("on") -> baseFamilyName + "son"
            roll == 1 && !baseFamilyName.endsWith("on") -> baseFamilyName + "ton"
            roll == 2 -> Randomness.random(MaleGivenNames, random)
            roll == 3 -> baseFamilyName + "-" + Randomness.random(LastNames, random)
            roll == 4 -> baseFamilyName + "ford"
            roll == 5 -> baseFamilyName + "ham"
            else -> baseFamilyName
        }

        return Name(firstName, familyName)
    }

    override fun generate(gender: Gender, mother: Name, father: Name): Name =
        generate(gender, mother, father, Randomness.random())

    override fun generate(gender: Gender, mother: Name, father: Name, seed: Long): Name =
        generate(gender, mother, father, Randomness.random(seed))

    private fun generate(gender: Gender, @Suppress("UNUSED_PARAMETER") mother: Name, @Suppress("UNUSED_PARAMETER") father: Name, random: Random): Name {
        // TODO inherit surname
        return generate(gender, random)
    }

    companion object {
        val MaleGivenNames = listOf(
            "David", "James", "Andrew", "John", "Michael", "Paul", "Matthew", "Mark", "Chris", "Richard",
            "Tom", "Alex", "Daniel", "Peter", "Ben", "Robert", "Christopher", "Thomas", "Stephen", "Adam",
            "Simon", "Jonathan", "Ian", "Jack", "Sam", "Martin", "Matt", "George", "Nick", "Joe"
        )

        val FemaleGivenNames = listOf(
            "Sarah", "Emma", "Laura", "Rachel", "Helen", "Claire", "Emily", "Hannah", "Rebecca", "Sophie",
            "Charlotte", "Anna", "Lucy", "Amy", "Catherine", "Jennifer", "Katie", "Jane", "Kate", "Elizabeth",
            "Julie", "Louise", "Susan", "Maria", "Karen", "Caroline", "Alison", "Lisa", "Nicola", "Jessica"
        )

        val LastNames = listOf(
            "Smith", "Jones", "Patel", "Williams", "Brown", "Davies", "Taylor", "Lee", "Evans", "Harris", "Shah",
            "White", "Wilson", "Johnson", "Khan", "Clarke", "Thomas", "Lewis", "Roberts", "Walker", "Thompson",
            "Wright", "Edwards", "Davis", "Moore", "Ward", "Chan", "Cooper", "Green", "Robinson", "King", "Turner",
            "Jackson", "Wood", "Hughes", "Martin", "Baker", "Hall", "Bennett", "Mitchell", "Shaw", "Hill", "Clark",
            "Parker", "Watson", "Scott", "James", "Wong", "Morris", "Cox"
        )
    }
}
