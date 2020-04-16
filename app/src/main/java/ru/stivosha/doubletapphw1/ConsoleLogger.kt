package ru.stivosha.doubletapphw1

import android.content.Context
import java.io.File

class ConsoleLogger {

    private val FILE_NAME = "logs.txt"
    private val file : File

    constructor(context : Context){
        var path = context.filesDir
        file = File(path, FILE_NAME)
        if(!file.exists())
            file.createNewFile()
    }

    fun writeInLog(text : String){
        file.appendText(text + "\n")
    }
}