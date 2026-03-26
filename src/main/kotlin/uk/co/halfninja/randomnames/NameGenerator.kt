package uk.co.halfninja.randomnames

interface NameGenerator {
    fun generate(gender: Gender): Name
    fun generate(gender: Gender, seed: Long): Name
    fun generate(gender: Gender, mother: Name, father: Name): Name
    fun generate(gender: Gender, mother: Name, father: Name, seed: Long): Name
}
