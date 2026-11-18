package fr.nyvetis.nemean.client.config

sealed class Setting<T>(val id: String, val name: String, val default: T) {
    var value: T = default
        set(v) { field = validate(v) }

    protected open fun validate(v: T): T = v

    fun reset() { value = default }
}

class BooleanSetting(id: String, name: String, default: Boolean) : Setting<Boolean>(id, name, default)