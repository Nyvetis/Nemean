package fr.nyvetis.nemean.client.gui

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.minecraft.client.gui.screens.Screen

object ScreenOpener {
    private var pending: Screen? = null

    fun open(screen: Screen) {
        pending = screen
    }

    fun init() {
        ClientTickEvents.END_CLIENT_TICK.register { client ->
            val screen = pending
            if (screen != null) {
                client.setScreenAndShow(screen)
                pending = null
            }
        }
    }
}