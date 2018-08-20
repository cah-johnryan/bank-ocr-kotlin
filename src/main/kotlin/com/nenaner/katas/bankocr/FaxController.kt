package com.nenaner.katas.bankocr

class FaxController(private val faxReader: FaxReaderInterface) : FaxControllerInterface {
    override fun readNextCharacter(): String? {
        faxReader.readNextLine()
        faxReader.readNextLine()
        faxReader.readNextLine()
        faxReader.readNextLine()
        return null
    }
}