package uk.co.halfninja.randomnames

sealed class Gender {
    object Male : Gender()
    object Female : Gender()
    object Nonspecific : Gender()
}
