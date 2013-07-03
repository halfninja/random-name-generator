package uk.co.halfninja.randomnames

case class Name(val givenName: String, val familyName: String, val middleNames: Seq[String], val quotedName: String) {

	override def toString =
		(Seq(givenName) ++ 
		(Option(quotedName).map { n => '"' + n + '"' }.toSeq) ++
		middleNames ++
		Seq(familyName)).mkString(" ")
		
}

object Name {
	def apply(givenName: String, familyName: String) = new Name(givenName, familyName, Seq.empty, null)
}