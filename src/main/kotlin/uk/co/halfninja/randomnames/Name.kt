package uk.co.halfninja.randomnames

data class Name(
    val givenName: String,
    val familyName: String,
    val middleNames: List<String> = emptyList(),
    val quotedName: String? = null
) {
    override fun toString(): String =
        listOfNotNull(
            givenName,
            quotedName?.let { "\"$it\"" },
            *middleNames.toTypedArray(),
            familyName
        ).joinToString(" ")
}
