package fr.nyvetis.nemean.client.core

object HypixelParsing {
    fun isHypixelAddress(address: String): Boolean {
        val host = address.lowercase().substringBefore(':')
        return host == "hypixel.net" || host.endsWith(".hypixel.net")
    }
    fun isSkyBlockTitle(title: String): Boolean {
        val cleanTitle = title.replace(Regex("§."), "").trim()
        return cleanTitle.startsWith("SKYBLOCK")
    }
}