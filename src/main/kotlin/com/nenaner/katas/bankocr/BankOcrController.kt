package com.nenaner.katas.bankocr

class BankOcrController {
    private val imageMap = mapOf(
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
                    " _|" to 9,
                    " _ \n" +
                    "| |\n" +
                    "|_|" to 0
            )
    fun scan(sourceImage: String): Int? {
        return getNumberFromImage(sourceImage)
    }

    private fun getNumberFromImage(sourceImage: String): Int? {
        return imageMap[sourceImage]
    }
}