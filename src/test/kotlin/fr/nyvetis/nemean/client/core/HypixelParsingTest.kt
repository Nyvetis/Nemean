package fr.nyvetis.nemean.client.core

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HypixelParsingTest {

    @Test
    fun `accepts hypixel addresses`() {
        assertTrue(HypixelParsing.isHypixelAddress("hypixel.net"))
        assertTrue(HypixelParsing.isHypixelAddress("mc.hypixel.net"))
        assertTrue(HypixelParsing.isHypixelAddress("mc.hypixel.net:25565"))
    }

    @Test
    fun `rejects other addresses`() {
        assertFalse(HypixelParsing.isHypixelAddress("hypixel.org"))
        assertFalse(HypixelParsing.isHypixelAddress("localhost"))
        assertFalse(HypixelParsing.isHypixelAddress("fakehypixel.net"))
    }

    @Test
    fun `accepts skyblock titles`() {
        assertTrue(HypixelParsing.isSkyBlockTitle("§e§lSKYBLOCK"))
        assertTrue(HypixelParsing.isSkyBlockTitle("SKYBLOCK"))
        assertTrue(HypixelParsing.isSkyBlockTitle("SKYBLOCK CO-OP"))
        assertTrue(HypixelParsing.isSkyBlockTitle("SKYBLOCK IRONMAN"))
    }

    @Test
    fun `rejects other titles`() {
        assertFalse(HypixelParsing.isSkyBlockTitle("BED WARS"))
        assertFalse(HypixelParsing.isSkyBlockTitle("MEGAWALL"))
        assertFalse(HypixelParsing.isSkyBlockTitle("HOUSING"))
        assertFalse(HypixelParsing.isSkyBlockTitle(""))
    }
}