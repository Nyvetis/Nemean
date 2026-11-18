package fr.nyvetis.nemean.client.utils

import net.minecraft.ChatFormatting
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component

object ChatUtils {
    private const val PREFIX = "Nemean >> "

    fun prefixed(text: String): Component =
        Component.literal(PREFIX).withStyle(ChatFormatting.GOLD)
            .append(Component.literal(text).withStyle(ChatFormatting.GRAY))

    fun send(text: String) {
        Minecraft.getInstance().gui.hud.chat.addClientSystemMessage(prefixed(text))
    }
}