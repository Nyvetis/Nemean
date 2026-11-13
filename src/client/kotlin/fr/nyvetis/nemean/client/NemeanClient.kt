package fr.nyvetis.nemean.client

import net.fabricmc.api.ClientModInitializer
import org.slf4j.LoggerFactory

object NemeanClient : ClientModInitializer {
	const val MOD_ID = "nemean"
	val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitializeClient() {
		logger.info("NemeanClient Loaded!")
	}
}