package uk.co.halfninja.randomnames

import uk.co.halfninja.randomnames.Randomness._

/**
 * A NameGenerator that picks between a list of delegate generators.
 * It is immutable so you create an empty one with newGenerator and
 * then build a list of generators using withGenerator(), which
 * returns a fresh generator each time.
 */
class CompositeNameGenerator(val entries: Seq[CompositeNameGenerator.Entry]) extends NameGenerator {

	final val totalWeighting = entries.foldLeft(0) { (acc, entry) => acc + entry.weighting }
	
	/**
	 * Pick a random NameGenerator from the possible ones, weighted by
	 * their weighting.
	 */
	private def pickGenerator(): NameGenerator = pickGenerator(random())
	private def pickGenerator(seed: Long): NameGenerator = pickGenerator(random(seed))
	private def pickGenerator(random: JRandom): NameGenerator = {
		var choice = random.nextInt(totalWeighting)
		entries.find { entry =>
			val found = choice < entry.weighting
			if (!found) choice -= entry.weighting
			found
		}.head.generator
	}
	
	override def generate(gender: Gender) = pickGenerator().generate(gender)
	override def generate(gender: Gender, seed: Long) = pickGenerator(seed).generate(gender, seed)
	override def generate(gender: Gender, mother: Name, father: Name) = pickGenerator().generate(gender, mother, father)
	override def generate(gender: Gender, mother: Name, father: Name, seed: Long) = pickGenerator(seed).generate(gender, mother, father, seed)

	def withGenerator(string: String, generator: NameGenerator, weight: Int) = {
		if (weight < 1) throw new IllegalArgumentException("Weight must be at least 1")
		new CompositeNameGenerator(entries :+ CompositeNameGenerator.Entry(string, generator, weight))
	}

}

object CompositeNameGenerator {
	case class Entry(id: String, generator: NameGenerator, weighting: Int)

	def newGenerator() = new CompositeNameGenerator(Seq.empty)
}