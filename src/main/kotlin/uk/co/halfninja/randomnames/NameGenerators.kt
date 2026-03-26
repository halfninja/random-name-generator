package uk.co.halfninja.randomnames

object NameGenerators {
    fun standardGenerator() =
        CompositeNameGenerator
            .newGenerator()
            .withGenerator("englishlike", EnglishlikeNameGenerator(), 1)
}
