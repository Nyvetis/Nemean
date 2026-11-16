package fr.nyvetis.nemean.client.gui

import net.minecraft.client.Minecraft
import net.minecraft.client.resources.sounds.SimpleSoundInstance
import net.minecraft.network.chat.Component
import net.minecraft.sounds.SoundEvents

object TitleDisplay {
    fun show(title: String, subtitle: String? = null) {
        val gui = Minecraft.getInstance().gui
        gui.hud.setTimes(10, 70, 20)
        if (subtitle != null) {
            gui.hud.setSubtitle(Component.literal(subtitle))
        }
        gui.hud.setTitle(Component.literal(title))
        playSound()
    }

    fun playSound() {
        val sound = SimpleSoundInstance.forUI(SoundEvents.PLAYER_LEVELUP, 1.0f)
        Minecraft.getInstance().soundManager.play(sound)
    }

}