package uk.co.halfninja.randomnames

import java.util.Random

object Randomness {
    fun random(): Random = Random()
    fun random(seed: Long): Random = Random(seed)
    fun random(strings: List<String>, random: Random): String = strings[random.nextInt(strings.size)]
}
