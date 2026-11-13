package fr.nyvetis.nemean.client.features

import fr.nyvetis.nemean.Nemean

object TestFeature : Feature {
    override val name = "Test Feature"
    override fun init() {
        Nemean.logger.info(name)
    }
}