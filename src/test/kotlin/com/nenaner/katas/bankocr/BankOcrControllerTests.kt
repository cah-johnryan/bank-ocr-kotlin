package com.nenaner.katas.bankocr

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.assertEquals

object BankOcrControllerTests: Spek({
    given("a bank OCR Controller") {
        val mockFaxReader = mock<FaxReader>()
        val bankOcrController = BankOcrController(mockFaxReader)
        on("scanning an image of a single image of a number from the page") {
            whenever(mockFaxReader.readNextCharacter()).thenReturn("   \n" +
                    "  |\n" +
                    "  |")
            it("should be able to interpret the single number provided") {
                assertEquals(1, bankOcrController.scan())
            }
        }
        on("scanning an image of a \"2\" from the page") {
            whenever(mockFaxReader.readNextCharacter()).thenReturn(" _ \n" +
                    " _|\n" +
                    "|_ ")
            it("should return 2") {
                assertEquals(2, bankOcrController.scan())
            }
        }
        on("scanning an image of a \"3\" from the page") {
            whenever(mockFaxReader.readNextCharacter()).thenReturn(" _ \n" +
                    " _|\n" +
                    " _|")
            it("should return 3") {
                assertEquals(3, bankOcrController.scan())
            }
        }
    }
})