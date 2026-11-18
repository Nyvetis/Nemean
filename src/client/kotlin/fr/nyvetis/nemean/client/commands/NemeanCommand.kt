package fr.nyvetis.nemean.client.commands

import fr.nyvetis.nemean.Nemean
import fr.nyvetis.nemean.client.gui.NemeanScreen
import fr.nyvetis.nemean.client.gui.ScreenOpener
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal
import com.mojang.brigadier.Command
import fr.nyvetis.nemean.client.core.HypixelState
import fr.nyvetis.nemean.client.utils.ChatUtils

object NemeanCommand {
    fun init() {
        ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ ->
            dispatcher.register( literal("nemean")
                .executes { _ ->
                Nemean.logger.info("/nemean executed")
                ScreenOpener.open(NemeanScreen())
                Command.SINGLE_SUCCESS
                }
                .then(literal("debug").executes { context ->
                    context.source.sendFeedback(ChatUtils.prefixed("Dev environment: ${HypixelState.isDev}"))
                    context.source.sendFeedback(ChatUtils.prefixed("Server address: ${HypixelState.serverAddress}"))
                    context.source.sendFeedback(ChatUtils.prefixed("Scoreboard title: ${HypixelState.scoreboardTitle}"))
                    context.source.sendFeedback(ChatUtils.prefixed("On Hypixel: ${HypixelState.onHypixel} | In SkyBlock: ${HypixelState.inSkyBlock}"))
                    Command.SINGLE_SUCCESS
                })
            )
        }
    }
}
