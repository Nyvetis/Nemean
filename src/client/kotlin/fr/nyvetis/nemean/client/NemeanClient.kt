package fr.nyvetis.nemean.client

import fr.nyvetis.nemean.Nemean
import fr.nyvetis.nemean.client.core.ChatListener
import fr.nyvetis.nemean.client.features.FeatureManager
import net.fabricmc.api.ClientModInitializer

object NemeanClient : ClientModInitializer {
	override fun onInitializeClient() {
		Nemean.logger.info("NemeanClient Loaded!")
		ChatListener.init()
		FeatureManager.initAll()
	}
}