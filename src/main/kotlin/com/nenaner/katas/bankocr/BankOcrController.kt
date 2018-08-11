package com.nenaner.katas.bankocr

val imageMap = mapOf(
        " _ \n" +
                "| |\n" +
                "|_|" to 0,
        "   \n" +
                "  |\n" +
                "  |" to 1,
        " _ \n" +
                " _|\n" +
                "|_ " to 2,
        " _ \n" +
                " _|\n" +
                " _|" to 3,
        "   \n" +
                "|_|\n" +
                "  |" to 4,
        " _ \n" +
                "|_ \n" +
                " _|" to 5,
        " _ \n" +
                "|_ \n" +
                "|_|" to 6,
        " _ \n" +
                "  |\n" +
                "  |" to 7,
        " _ \n" +
                "|_|\n" +
                "|_|" to 8,
        " _ \n" +
                "|_|\n" +
                " _|" to 9
)

class BankOcrController(private val faxReader: FaxReader) {
    fun scan(): Int? {
        return getNumberFromImage(faxReader.readNextCharacter())
    }

    private fun getNumberFromImage(sourceImage: String): Int {
        return imageMap[sourceImage]
                ?: throw NumberFormatException("An invalid character was encountered in the fax document.")
    }
}