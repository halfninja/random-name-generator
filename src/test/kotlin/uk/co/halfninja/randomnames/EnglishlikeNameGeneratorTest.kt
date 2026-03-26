package uk.co.halfninja.randomnames

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EnglishlikeNameGeneratorTest {

    /**
     * Not actually testing anything here.. just printing things out.
     * Fun!
     */
    @Test
    fun `generation of names works`() {
        val generator = NameGenerators.standardGenerator()
        repeat(10) {
            println(generator.generate(Gender.Male))
            println(generator.generate(Gender.Female))
        }
    }

    @Test
    fun `seeded name generation returns expected names`() {
        val generator = NameGenerators.standardGenerator()
        assertEquals("Matthew Baker", generator.generate(Gender.Male, 1234567).toString())
        assertEquals("Sam Greenton", generator.generate(Gender.Male, 1234568).toString())
        assertEquals("Richard Robertsford", generator.generate(Gender.Male, 1234569).toString())
        assertEquals("Jack Patel", generator.generate(Gender.Male, 1234570).toString())
        assertEquals("Chris Shaw", generator.generate(Gender.Male, 1234571).toString())
        assertEquals("Matt Hughes", generator.generate(Gender.Male, 1234572).toString())
        assertEquals("Daniel Edwards", generator.generate(Gender.Male, 1234573).toString())
        assertEquals("Martin Taylor", generator.generate(Gender.Male, 1234574).toString())
        assertEquals("Tom Watson-Thompson", generator.generate(Gender.Male, 1234575).toString())
        assertEquals("Alex Brown", generator.generate(Gender.Male, 1234576).toString())
        assertEquals("Emily Baker", generator.generate(Gender.Female, 1234567).toString())
        assertEquals("Karen Greenton", generator.generate(Gender.Female, 1234568).toString())
        assertEquals("Sophie Robertsford", generator.generate(Gender.Female, 1234569).toString())
        assertEquals("Maria Patel", generator.generate(Gender.Female, 1234570).toString())
        assertEquals("Rebecca Shaw", generator.generate(Gender.Female, 1234571).toString())
        assertEquals("Alison Hughes", generator.generate(Gender.Female, 1234572).toString())
        assertEquals("Lucy Edwards", generator.generate(Gender.Female, 1234573).toString())
        assertEquals("Caroline Taylor", generator.generate(Gender.Female, 1234574).toString())
        assertEquals("Charlotte Watson-Thompson", generator.generate(Gender.Female, 1234575).toString())
        assertEquals("Anna Brown", generator.generate(Gender.Female, 1234576).toString())
    }
}
