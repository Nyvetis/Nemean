package fr.nyvetis.nemean.client.features

import fr.nyvetis.nemean.Nemean

object FeatureManager {
    private val all = listOf<Feature>(ChatRareDrop)
    val features: List<Feature> get() = all
    fun initAll(){
        for (feature in all){
            feature.init()
            Nemean.logger.info("Initialized ${feature.name}")
        }
    }

    fun get(id: String): Feature? = all.find { it.id == id }
}