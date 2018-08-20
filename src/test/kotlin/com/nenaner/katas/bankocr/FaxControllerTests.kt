package com.nenaner.katas.bankocr

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object FaxControllerTests : Spek({
    given("a Fax Reader") {
        val mockFaxReader = mock<FaxReaderInterface>()
        val faxController = FaxController(mockFaxReader)
        on("reading the next character") {
            faxController.readNextCharacter()
            it("makes a call to the Fax reader to read 4 lines") {
                verify(mockFaxReader, times(4)).readNextLine()
            }
        }
    }
})
