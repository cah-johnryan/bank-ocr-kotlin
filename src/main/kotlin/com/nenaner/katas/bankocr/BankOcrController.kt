package com.nenaner.katas.bankocr

const val numberFormatExceptionMessageText = "An invalid character was encountered in the fax document."
// @formatter:off
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
// @formatter:on

class BankOcrController(private val faxReader: FaxReader) {
    private val multiplier = 10

    fun scan(): Int? {
        var currentSum = 0
        var nextImageRead = faxReader.readNextCharacter()
        while (nextImageRead != null) {
            val nextNumber = getNumberFromImage(nextImageRead)
            currentSum = currentSum * multiplier + nextNumber
            nextImageRead = faxReader.readNextCharacter()
        }
        return currentSum
    }

    private fun getNumberFromImage(sourceImage: String): Int {
        return imageMap[sourceImage] ?: throw NumberFormatException(numberFormatExceptionMessageText)
    }
}