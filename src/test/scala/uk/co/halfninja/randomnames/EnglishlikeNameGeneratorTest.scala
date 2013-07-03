package uk.co.halfninja.randomnames

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers._

class EnglishlikeNameGeneratorTest extends FunSuite {

	/**
	 * Not actually testing anything here.. just printing things out.
	 * Fun!
	 */
	test("Generation of names works") {
		val generator = NameGenerators.standardGenerator()
		(1 to 10).foreach { i =>
			println(generator.generate(Gender.male))
			println(generator.generate(Gender.female))
		}
	}

	test("Seeded name generation returns expected names") {
		val generator = NameGenerators.standardGenerator()
		(1 to 10).foreach { i =>
			generator.generate(Gender.male, 1234567).toString() should be ("Matthew Baker")
			generator.generate(Gender.male, 1234568).toString() should be ("Sam Greenton")
			generator.generate(Gender.male, 1234569).toString() should be ("Richard Robertsford")
			generator.generate(Gender.male, 1234570).toString() should be ("Jack Patel")
			generator.generate(Gender.male, 1234571).toString() should be ("Chris Shaw")
			generator.generate(Gender.male, 1234572).toString() should be ("Matt Hughes")
			generator.generate(Gender.male, 1234573).toString() should be ("Daniel Edwards")
			generator.generate(Gender.male, 1234574).toString() should be ("Martin Taylor")
			generator.generate(Gender.male, 1234575).toString() should be ("Tom Watson-Thompson")
			generator.generate(Gender.male, 1234576).toString() should be ("Alex Brown")
			generator.generate(Gender.female, 1234567).toString() should be ("Emily Baker")
			generator.generate(Gender.female, 1234568).toString() should be ("Karen Greenton")
			generator.generate(Gender.female, 1234569).toString() should be ("Sophie Robertsford")
			generator.generate(Gender.female, 1234570).toString() should be ("Maria Patel")
			generator.generate(Gender.female, 1234571).toString() should be ("Rebecca Shaw")
			generator.generate(Gender.female, 1234572).toString() should be ("Alison Hughes")
			generator.generate(Gender.female, 1234573).toString() should be ("Lucy Edwards")
			generator.generate(Gender.female, 1234574).toString() should be ("Caroline Taylor")
			generator.generate(Gender.female, 1234575).toString() should be ("Charlotte Watson-Thompson")
			generator.generate(Gender.female, 1234576).toString() should be ("Anna Brown")
		}
	}

}
