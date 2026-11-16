package fr.nyvetis.nemean.client.commands

import fr.nyvetis.nemean.Nemean
import fr.nyvetis.nemean.client.gui.NemeanScreen
import fr.nyvetis.nemean.client.gui.ScreenOpener
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal
import com.mojang.brigadier.Command
object NemeanCommand {
    fun init() {
        ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ ->
            dispatcher.register( literal("nemean").executes { _ ->
                Nemean.logger.info("/nemean executed")
                ScreenOpener.open(NemeanScreen())
                Command.SINGLE_SUCCESS
            })
        }
    }
}
