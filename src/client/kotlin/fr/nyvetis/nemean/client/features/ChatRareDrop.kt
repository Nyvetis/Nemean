package fr.nyvetis.nemean.client.features

import fr.nyvetis.nemean.client.core.ChatListener
import fr.nyvetis.nemean.client.core.DropParser
import fr.nyvetis.nemean.client.core.HypixelState
import fr.nyvetis.nemean.client.gui.TitleDisplay

object ChatRareDrop : Feature {
    override val name = "Rare Drop Alert"
    override fun init() {
        ChatListener.onMessage { text ->
            if (!HypixelState.inSkyBlock) return@onMessage
            val drop = DropParser.parse(text) ?: return@onMessage
            if(drop.type == "RARE") return@onMessage
            TitleDisplay.show("${drop.type} DROP!", drop.item)
        }
    }
}