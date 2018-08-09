package com.nenaner.katas.bankocr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.function.Executable

object BankOcrControllerTests : Spek({
    given("a bank OCR Controller") {
        val bankOcrController = BankOcrController()
        on("scanning an image of a single image of a number from the page") {
            it("should be able to interpret the single number provided") {
                assertAll(
                        Executable {
                            assertEquals(1, bankOcrController.scan(
                                    "   \n" +
                                            "  |\n" +
                                            "  |"))
                        },
                        Executable {
                            assertEquals(2, bankOcrController.scan(
                                    " _ \n" +
                                            " _|\n" +
                                            "|_ "))
                        },
                        Executable {
                            assertEquals(3, bankOcrController.scan(
                                    " _ \n" +
                                            " _|\n" +
                                            " _|"))
                        },
                        Executable {
                            assertEquals(4, bankOcrController.scan(
                                    "   \n" +
                                            "|_|\n" +
                                            "  |"))
                        },
                        Executable {
                            assertEquals(5, bankOcrController.scan(
                                    " _ \n" +
                                            "|_ \n" +
                                            " _|"))
                        },
                        Executable {
                            assertEquals(6, bankOcrController.scan(
                                    " _ \n" +
                                            "|_ \n" +
                                            "|_|"))
                        },
                        Executable {
                            assertEquals(7, bankOcrController.scan(
                                    " _ \n" +
                                            "  |\n" +
                                            "  |"))
                        },
                        Executable {
                            assertEquals(8, bankOcrController.scan(
                                    " _ \n" +
                                            "|_|\n" +
                                            "|_|"))
                        },
                        Executable {
                            assertEquals(9, bankOcrController.scan(
                                    " _ \n" +
                                            "|_|\n" +
                                            " _|"))
                        },
                        Executable {
                            assertEquals(0, bankOcrController.scan(
                                    " _ \n" +
                                            "| |\n" +
                                            "|_|"))
                        }
                )
            }
        }
    }
})