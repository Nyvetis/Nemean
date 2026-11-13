package fr.nyvetis.nemean.client.features

interface Feature {
    val name: String
    fun init()
}