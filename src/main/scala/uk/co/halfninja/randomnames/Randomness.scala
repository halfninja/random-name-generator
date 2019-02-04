package uk.co.halfninja.randomnames

import java.util.Random

object Randomness {
	type JRandom = java.util.Random

	def random() = new JRandom
	def random(seed: Long) = new JRandom(seed)
	def random(strings: Seq[String], random: JRandom): String = strings(random.nextInt(strings.size))
}
