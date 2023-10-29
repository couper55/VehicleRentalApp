package com.example.my_app

import android.content.Context
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

object ExcelHelper {
    private const val USER_INFO_FILE_NAME = "userinfo.xlsx"

    fun writeToUserInfoExcel(context: Context, userData: List<String>) {
        // Add field names to userData
        val file = File(context.filesDir, USER_INFO_FILE_NAME)
        if (!file.exists()) {
            // Add field names to userData
            //val userDataWithFields = listOf("First Name", "Last Name", "Email", "Password", "Age", "Address", "License Number")
            writeToExcel(context, userData, USER_INFO_FILE_NAME)
        } else {
            // The file already exists, don't add field names again
            return writeToExcel(context, userData, USER_INFO_FILE_NAME)
        }
    }


    fun readUserInfoFromExcel(context: Context): List<String> {
        return readFromExcel(context, USER_INFO_FILE_NAME)
    }


    private fun readFromExcel(context: Context, fileName: String): List<String> {
        val userDataList = mutableListOf<String>()

        try {
            val file = File(context.filesDir, fileName)
            if (file.exists()) {
                val fis = FileInputStream(file)
                val workbook: Workbook = XSSFWorkbook(fis)
                val sheet: Sheet = workbook.getSheetAt(0)

                for (row: Row in sheet) {
                    val userData = StringBuilder()
                    for (cell: Cell in row) {
                        userData.append(cell.toString()).append(",")
                    }
                    userDataList.add(userData.toString())
                }
                workbook.close()
                fis.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return userDataList
    }

    private fun writeToExcel(context: Context, data: List<String>, fileName: String) {
        try {
            val file = File(context.filesDir, fileName)
            val workbook: Workbook
            val sheet: Sheet
            if (file.exists()) {
                val fis = FileInputStream(file)
                workbook = XSSFWorkbook(fis)
                sheet = workbook.getSheetAt(0)
            } else {
                workbook = XSSFWorkbook()
                sheet = workbook.createSheet()
            }

            // Only add field names if the sheet is empty
            if (sheet.lastRowNum.toLong() == -1L) {
                val headerRow = sheet.createRow(0)
                for (i in data.indices) {
                    val cell: Cell = headerRow.createCell(i)
                    cell.setCellValue(data[i])
                }
            }

            val rowCount = sheet.lastRowNum + 1
            val row = sheet.createRow(rowCount)
            for (i in data.indices) {
                val cell: Cell = row.createCell(i)
                cell.setCellValue(data[i])
            }

            val fos = FileOutputStream(file)
            workbook.write(fos)
            fos.close()
            workbook.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
