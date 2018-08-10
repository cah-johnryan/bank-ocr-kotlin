package com.nenaner.katas.bankocr

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.kotlintest.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object BankOcrControllerTests : Spek({
    given("a bank OCR Controller") {
        val mockFaxReader = mock<FaxReader>()
        val bankOcrController = BankOcrController(mockFaxReader)
        on("scanning an image with a single character from the page") {
            it("should return the right number") {
                imageMap.forEach { imageToTest, expectedValue ->
                    run {
                        whenever(mockFaxReader.readNextCharacter()).thenReturn(imageToTest)
                        bankOcrController.scan() shouldBe expectedValue
                    }
                }
            }
        }
    }
})