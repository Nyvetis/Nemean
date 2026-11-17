package fr.nyvetis.nemean.client.core

data class Drop(val type: String, val item: String)

object DropParser {
    private val DROP_REGEX = Regex("""(RARE|VERY RARE|CRAZY RARE|PET) DROP! (.+?)(?: \(.+\))?""")

    fun parse(text: String): Drop? {
        val match = DROP_REGEX.matchEntire(text) ?: return null
        return Drop(match.groupValues[1], match.groupValues[2].removeSurrounding("(", ")"))
    }
}