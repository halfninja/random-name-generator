package uk.co.halfninja.randomnames

trait NameGenerator {
	def generate(gender: Gender): Name
	def generate(gender: Gender, mother: Name, father: Name): Name
}