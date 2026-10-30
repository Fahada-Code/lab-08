package com.example.lab_8

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WizardTest {
    private lateinit var evilWizard: Wizard

    // Set up a new wizard before every single test
    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(30, damageDealt)

        assertEquals(20, evilWizard.mana)
    }

    @Test
    fun castSpell_explosion_unsuccessful() {
        evilWizard.mana = 5
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(0, damageDealt)

        assertEquals(5, evilWizard.mana)
    }

    @Test
    fun train_enoughMana_increasesSpellPower() {
        evilWizard.train()

        assertEquals(11, evilWizard.spellPower)
        assertEquals(25, evilWizard.mana)
    }

    @Test
    fun train_notEnoughMana_doesNotChangeStats() {
        evilWizard.mana = 3

        evilWizard.train()

        assertEquals(10, evilWizard.spellPower)
        assertEquals(3, evilWizard.mana)
    }

    @Test
    fun train_enoughMana() {
        evilWizard.train()
        assertEquals(11, evilWizard.spellPower)
        assertEquals(25, evilWizard.mana)
    }

    @Test
    fun train_notEnoughMana() {
        evilWizard.mana = 3
        evilWizard.train()
        assertEquals(10, evilWizard.spellPower)
        assertEquals(3, evilWizard.mana)
}