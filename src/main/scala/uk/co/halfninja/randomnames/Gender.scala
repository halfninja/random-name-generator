package uk.co.halfninja.randomnames

sealed trait Gender

object Gender {
	case object male extends Gender
	case object female extends Gender
	case object nonspecific extends Gender
}
