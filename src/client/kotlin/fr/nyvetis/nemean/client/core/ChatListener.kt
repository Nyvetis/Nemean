package fr.nyvetis.nemean.client.core

import fr.nyvetis.nemean.Nemean
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents

object ChatListener {
    private val handlers = mutableListOf<(String) -> Unit>()

    fun onMessage(handler: (String) -> Unit) {
        handlers.add(handler)
    }

    fun init() {
        ClientReceiveMessageEvents.GAME.register { message, overlay ->
            if (overlay) return@register

            val text = message.string
            Nemean.logger.info("[chat] $text")

            for (handler in handlers) {
                handler(text)
            }
        }
    }
}