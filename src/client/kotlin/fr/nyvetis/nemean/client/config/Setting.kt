package fr.nyvetis.nemean.client.config

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive

sealed class Setting<T>(val id: String, val name: String, val default: T) {
    var value: T = default
        set(v) { field = validate(v) }

    protected open fun validate(v: T): T = v

    fun reset() { value = default }

    abstract fun toJson(): JsonElement
    abstract fun fromJson(json: JsonElement)
}

class BooleanSetting(id: String, name: String, default: Boolean) : Setting<Boolean>(id, name, default){
    override fun toJson(): JsonElement = JsonPrimitive(value)

    override fun fromJson(json: JsonElement) {
        if (!(json.isJsonPrimitive && json.asJsonPrimitive.isBoolean)) return
        value = json.asBoolean
    }
}