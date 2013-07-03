package uk.co.halfninja.randomnames

import java.util.Random

object Randomness {
	val random = new Random
	def random(strings: Seq[String]): String = strings(random.nextInt(strings.size))
}
