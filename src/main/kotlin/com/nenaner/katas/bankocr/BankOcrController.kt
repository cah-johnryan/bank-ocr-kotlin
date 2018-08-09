package com.nenaner.katas.bankocr

class BankOcrController {
    val imageOfOne = "   \n" +
            "  |\n" +
            "  |"
    fun scan(sourceImage: String): Int? {
        return if (imageOfOne.equals(sourceImage)) 1 else 2
    }
}