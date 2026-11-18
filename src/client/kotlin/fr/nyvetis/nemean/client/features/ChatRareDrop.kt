package fr.nyvetis.nemean.client.features

import fr.nyvetis.nemean.client.core.ChatListener
import fr.nyvetis.nemean.client.core.DropParser
import fr.nyvetis.nemean.client.core.HypixelState
import fr.nyvetis.nemean.client.gui.TitleDisplay

object ChatRareDrop : Feature(
    "rare_drop_alert",
    "Rare Drop Alert",
    "Sends a title when a very rare drop or more is detected in the chat",
    Category.GENERAL
    )
{
    override fun init() {
        ChatListener.onMessage { text ->
            if (!enabled.value) return@onMessage
            if (!HypixelState.inSkyBlock) return@onMessage
            val drop = DropParser.parse(text) ?: return@onMessage
            if(drop.type == "RARE") return@onMessage
            TitleDisplay.show("${drop.type} DROP!", drop.item)
        }
    }
}