package fr.nyvetis.nemean.client.config

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import fr.nyvetis.nemean.Nemean
import fr.nyvetis.nemean.client.features.FeatureManager
import java.io.IOException
import net.fabricmc.loader.api.FabricLoader
import java.nio.file.Files
import java.nio.file.StandardCopyOption

object ConfigManager {
    private const val VERSION = 1
    private val dir = FabricLoader.getInstance().configDir.resolve(Nemean.MOD_ID)
    private val file = dir.resolve("config.json")
    private val gson = GsonBuilder().setPrettyPrinting().create()

    fun save() {
        val root = JsonObject()
        root.addProperty("version", VERSION)

        val features = JsonObject()
        for (feature in FeatureManager.features) {
            val obj = JsonObject()
            for (setting in feature.settings) {
                obj.add(setting.id, setting.toJson())
            }
            features.add(feature.id, obj)
        }
        root.add("features", features)

        try {
            Files.createDirectories(dir)
            val tmp = dir.resolve("config.json.tmp")
            Files.writeString(tmp, gson.toJson(root))
            Files.move(tmp, file, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE)
        } catch (e: IOException) {
            Nemean.logger.error("Could not save config", e)
        }
    }

    fun load() {
        if (!Files.exists(file)) return

        val root = try {
            JsonParser.parseString(Files.readString(file)).asJsonObject
        } catch (e: Exception) {
            Nemean.logger.error("Config file is corrupted, using defaults", e)
            Files.move(file, dir.resolve("config.json.bak"), StandardCopyOption.REPLACE_EXISTING)
            return
        }

        val features = root.getAsJsonObject("features") ?: return
        for (feature in FeatureManager.features) {
            val obj = features.getAsJsonObject(feature.id) ?: continue
            for (setting in feature.settings) {
                val json = obj.get(setting.id) ?: continue
                setting.fromJson(json)
            }
        }
        Nemean.logger.info("Config loaded")
    }
}