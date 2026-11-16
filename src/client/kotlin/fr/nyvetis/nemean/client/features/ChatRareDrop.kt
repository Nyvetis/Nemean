package fr.nyvetis.nemean.client.features

import fr.nyvetis.nemean.client.core.ChatListener
import fr.nyvetis.nemean.client.core.DropParser
import fr.nyvetis.nemean.client.gui.TitleDisplay

object ChatRareDrop : Feature {
    override val name = "Rare Drop Alert"
    override fun init() {
        ChatListener.onMessage { text ->
            val drop = DropParser.parse(text) ?: return@onMessage
            TitleDisplay.show("${drop.type} DROP!", drop.item)
        }
    }
}