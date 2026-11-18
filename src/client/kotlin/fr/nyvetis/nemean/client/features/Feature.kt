package fr.nyvetis.nemean.client.features

import fr.nyvetis.nemean.client.config.BooleanSetting
import fr.nyvetis.nemean.client.config.Setting

abstract class Feature(
    val id: String,
    val name: String,
    val description: String,
    val category: Category,
) {
    val settings = mutableListOf<Setting<*>>()
    val enabled = setting(BooleanSetting("enabled","Enabled", true))

    protected fun <S : Setting<*>> setting(s:S):S{
        settings += s
        return s
    }
    abstract fun init()
}