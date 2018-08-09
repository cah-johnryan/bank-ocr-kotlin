package com.nenaner.katas.bankocr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.assertEquals

object BankOcrControllerTests: Spek({
    given("a bank OCR Controller") {
        val bankOcrController = BankOcrController()
        on("scanning an image of a single image of a number from the page") {
            it("should return 1") {
                assertEquals(1, bankOcrController.scan(
                        "   \n" +
                                "  |\n" +
                                "  |"))
            }
        }
        on("scanning an image of a \"2\" from the page") {
            val result = bankOcrController.scan(
                    " _ \n" +
                                " _|\n" +
                                "|_ ")
            it("should return 2") {
                assertEquals(2, result)
            }
        }
        on("scanning an image of a \"3\" from the page") {
            val result = bankOcrController.scan(
                    " _ \n" +
                                " _|\n" +
                                " _|")
            it("should return 3") {
                assertEquals(3, result)
            }
        }
    }
})