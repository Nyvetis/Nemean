package fr.nyvetis.nemean.client.features

import fr.nyvetis.nemean.client.core.ChatListener
import fr.nyvetis.nemean.client.gui.TitleDisplay

object ChatRareDrop : Feature {
    override val name = "Rare Drop Alert"
    override fun init() {
        ChatListener.onMessage { text ->
            when {
                text.startsWith("RARE DROP!") ->TitleDisplay.show("RARE DROP!")
                text.startsWith("PET DROP!") ->TitleDisplay.show("PET DROP!")
            }
        }
    }
}