package fr.nyvetis.nemean.client.features

import fr.nyvetis.nemean.Nemean
import fr.nyvetis.nemean.client.core.ChatListener

object TestFeature : Feature {
    override val name = "Test Feature"

    override fun init() {
        ChatListener.onMessage { text ->
            Nemean.logger.info("TestFeature received : $text")
        }
    }
}