package uk.co.halfninja.randomnames

import java.util.Random

/**
 * A NameGenerator that picks between a list of delegate generators.
 * It is immutable so you create an empty one with newGenerator() and
 * then build a list of generators using withGenerator(), which
 * returns a fresh generator each time.
 */
class CompositeNameGenerator(val entries: List<Entry>) : NameGenerator {

    private val totalWeighting = entries.sumOf { it.weighting }

    /**
     * Pick a random NameGenerator from the possible ones, weighted by
     * their weighting.
     */
    private fun pickGenerator(): NameGenerator = pickGenerator(Randomness.random())
    private fun pickGenerator(seed: Long): NameGenerator = pickGenerator(Randomness.random(seed))
    private fun pickGenerator(random: Random): NameGenerator {
        var choice = random.nextInt(totalWeighting)
        return entries.first { entry ->
            val found = choice < entry.weighting
            if (!found) choice -= entry.weighting
            found
        }.generator
    }

    override fun generate(gender: Gender): Name = pickGenerator().generate(gender)
    override fun generate(gender: Gender, seed: Long): Name = pickGenerator(seed).generate(gender, seed)
    override fun generate(gender: Gender, mother: Name, father: Name): Name = pickGenerator().generate(gender, mother, father)
    override fun generate(gender: Gender, mother: Name, father: Name, seed: Long): Name = pickGenerator(seed).generate(gender, mother, father, seed)

    fun withGenerator(id: String, generator: NameGenerator, weight: Int): CompositeNameGenerator {
        require(weight >= 1) { "Weight must be at least 1" }
        return CompositeNameGenerator(entries + Entry(id, generator, weight))
    }

    data class Entry(val id: String, val generator: NameGenerator, val weighting: Int)

    companion object {
        fun newGenerator() = CompositeNameGenerator(emptyList())
    }
}
