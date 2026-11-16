package fr.nyvetis.nemean.client.gui

import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component
object TitleDisplay {
    fun show(title: String){
        val gui = Minecraft.getInstance().gui
        gui.hud.setTimes(10, 70, 20)
        gui.hud.setTitle(Component.literal(title))
    }

}