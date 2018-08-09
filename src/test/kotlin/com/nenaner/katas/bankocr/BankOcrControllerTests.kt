package com.nenaner.katas.bankocr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.assertEquals

object BankOcrControllerTests: Spek({
    given("a bank OCR Controller") {
        val bankOcrController = BankOcrController()
        on("scanning an image of a \"1\" from the page") {
            val result = bankOcrController.scan(
                    "   \n" +
                                "  |\n" +
                                "  |")
            it("should return 1") {
                assertEquals(1, result)
            }
        }
    }
})