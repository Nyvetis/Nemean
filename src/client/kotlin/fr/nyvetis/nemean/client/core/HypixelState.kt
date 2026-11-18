package fr.nyvetis.nemean.client.core

import net.fabricmc.loader.api.FabricLoader
import net.minecraft.client.Minecraft
import net.minecraft.world.scores.DisplaySlot

object HypixelState {
    val isDev = FabricLoader.getInstance().isDevelopmentEnvironment
    val serverAddress: String? get() = Minecraft.getInstance().currentServer?.ip

    val scoreboardTitle: String? get() = Minecraft.getInstance().level
        ?.scoreboard
        ?.getDisplayObjective(DisplaySlot.SIDEBAR)
        ?.displayName
        ?.string

    val onHypixel: Boolean get() {
        if (isDev) return true
        val address = serverAddress
        return address != null && HypixelParsing.isHypixelAddress(address)
    }

    val inSkyBlock: Boolean get() {
        if (isDev) return true
        if (!onHypixel) return false
        val title = scoreboardTitle
        return title != null && HypixelParsing.isSkyBlockTitle(title)
    }
}