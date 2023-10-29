package com.example.my_app

import android.content.Context
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

object ExcelHelper {
    private const val USER_INFO_FILE_NAME = "userinfo.csv"

    fun writeToUserInfoCSV(context: Context, userData: List<String>) {
        val file = File(context.filesDir, USER_INFO_FILE_NAME)
        if (!file.exists()) {
            writeToCSV(context, userData, USER_INFO_FILE_NAME)
        } else {
            return writeToCSV(context, userData, USER_INFO_FILE_NAME)
        }
    }

    fun readUserInfoFromCSV(context: Context): List<String> {
        return readFromCSV(context, USER_INFO_FILE_NAME)
    }

    private fun readFromCSV(context: Context, fileName: String): List<String> {
        val userDataList = mutableListOf<String>()

        try {
            val file = File(context.filesDir, fileName)
            if (file.exists()) {
                val bufferedReader = file.bufferedReader()

                // Read the header line (field names) and discard it
                bufferedReader.readLine()

                bufferedReader.forEachLine {
                    userDataList.add(it)
                }

                bufferedReader.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return userDataList
    }

    private fun writeToCSV(context: Context, data: List<String>, fileName: String) {
        try {
            val file = File(context.filesDir, fileName)

            val isNewFile = !file.exists()

            val printWriter = PrintWriter(FileWriter(file, true))

            // Add field names if it's a new file
            if (isNewFile) {
                val header = data.joinToString(",")
                printWriter.println(header)
            }

            // Append data
            val dataLine = data.joinToString(",")
            printWriter.println(dataLine)

            printWriter.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
