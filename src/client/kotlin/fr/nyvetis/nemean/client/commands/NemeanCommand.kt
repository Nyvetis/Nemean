package fr.nyvetis.nemean.client.commands

import fr.nyvetis.nemean.Nemean
import fr.nyvetis.nemean.client.gui.NemeanScreen
import fr.nyvetis.nemean.client.gui.ScreenOpener
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal
import com.mojang.brigadier.Command
import com.mojang.brigadier.arguments.StringArgumentType
import fr.nyvetis.nemean.client.config.ConfigManager
import fr.nyvetis.nemean.client.core.HypixelState
import fr.nyvetis.nemean.client.features.FeatureManager
import fr.nyvetis.nemean.client.utils.ChatUtils
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.argument

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
                .then(literal("toggle")
                        .then(argument("id", StringArgumentType.word()).executes { context ->
                            val id = StringArgumentType.getString(context, "id")
                            val feature = FeatureManager.get(id)
                            if (feature == null) {
                                context.source.sendFeedback(ChatUtils.prefixed("Unknown feature: $id"))
                                return@executes 0
                            }
                            feature.enabled.value = !feature.enabled.value
                            ConfigManager.save()
                            val state = if (feature.enabled.value) "ON" else "OFF"
                            context.source.sendFeedback(ChatUtils.prefixed("${feature.name}: $state"))
                            Command.SINGLE_SUCCESS
                        })
                )
            )
        }
    }
}
