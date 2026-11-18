package fr.nyvetis.nemean.client.core

import net.fabricmc.loader.api.FabricLoader
import net.minecraft.client.Minecraft
import net.minecraft.world.scores.DisplaySlot

object HypixelState {
    private val isDev = FabricLoader.getInstance().isDevelopmentEnvironment

    val onHypixel: Boolean get() {
        if (isDev) return true
        val address = Minecraft.getInstance().currentServer?.ip
        return address != null && HypixelParsing.isHypixelAddress(address)
    }

    val inSkyBlock: Boolean get() {
        if (isDev) return true
        if (!onHypixel) return false
        val title = Minecraft.getInstance().level
            ?.scoreboard
            ?.getDisplayObjective(DisplaySlot.SIDEBAR)
            ?.displayName
            ?.string
        return title != null && HypixelParsing.isSkyBlockTitle(title)
    }
}