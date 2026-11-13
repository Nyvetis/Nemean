package fr.nyvetis.nemean.client.commands

import fr.nyvetis.nemean.Nemean
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal

object NemeanCommand {
    fun init() {
        ClientCommandRegistrationCallback.EVENT.register { dispatcher, registryAccess ->
            dispatcher.register( literal("nemean").executes { context ->
                Nemean.logger.info("Commande nemean executee")
                1
            })
        }
    }
}