package com.yly.webdemo.extends

import okio.buffer
import okio.sink
import okio.source
import java.io.File
import java.io.InputStream

fun writeFileToDisk(destFile: File, resourceIs: InputStream): File? {
    return tryWithResource {
        if (!destFile.exists()) {
            destFile.createNewFile()
        }
        val bSink = destFile.sink().buffer().autoClose()
        val bSource = resourceIs.source().buffer().autoClose()
        resourceIs.autoClose()
        bSink.writeAll(bSource)
        return@tryWithResource destFile
    }
}
