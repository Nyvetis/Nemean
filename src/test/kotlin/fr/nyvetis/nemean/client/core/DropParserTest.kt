package fr.nyvetis.nemean.client.core

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class DropParserTest {

    @Test
    fun `parses a rare drop with magic find`() {
        assertEquals(
            Drop("RARE", "Mithril Coat"),
            DropParser.parse("RARE DROP! Mithril Coat (+152 ✯ Magic Find)")
        )
    }

    @Test
    fun `parses a real slayer drop with item in parentheses`() {
        assertEquals(
            Drop("VERY RARE", "Tarantula Silk"),
            DropParser.parse("VERY RARE DROP! (Tarantula Silk)")
        )
    }

    @Test
    fun `parses a rare drop without magic find`() {
        assertEquals(
            Drop("RARE", "Mithril Coat"),
            DropParser.parse("RARE DROP! Mithril Coat")
        )
    }

    @Test
    fun `parses a crazy rare drop without magic find`() {
        assertEquals(
            Drop("CRAZY RARE", "Judgment Core"),
            DropParser.parse("CRAZY RARE DROP! Judgment Core")
        )
    }

    @Test
    fun `parses a pet drop`() {
        assertEquals(
            Drop("PET", "Golden Dragon"),
            DropParser.parse("PET DROP! Golden Dragon (+300 ✯ Magic Find)")
        )
    }

    @Test
    fun `ignores other messages`() {
        assertNull(DropParser.parse("You received 500 coins!"))
    }
}