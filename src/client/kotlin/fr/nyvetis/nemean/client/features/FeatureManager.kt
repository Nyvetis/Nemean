package fr.nyvetis.nemean.client.features

import fr.nyvetis.nemean.Nemean

object FeatureManager {
    private val all = listOf<Feature>(TestFeature)
    fun initAll(){
        for (feature in all){
            feature.init()
            Nemean.logger.info("Initialized ${feature.name}")
        }
    }
}