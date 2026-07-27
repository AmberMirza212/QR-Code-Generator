package com.android.qrcodegenerator.util

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

object ShareUtils {

    fun shareQRCode(
        context: Context,
        bitmap: Bitmap
    ) {

        val file = File(
            context.cacheDir,
            "qr_code.png"
        )

        val output = FileOutputStream(file)

        bitmap.compress(
            Bitmap.CompressFormat.PNG,
            100,
            output
        )

        output.close()

        val uri = FileProvider.getUriForFile(
            context,
            context.packageName + ".fileprovider",
            file
        )

        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "image/png"

        intent.putExtra(
            Intent.EXTRA_STREAM,
            uri
        )

        intent.addFlags(
            Intent.FLAG_GRANT_READ_URI_PERMISSION
        )

        context.startActivity(

            Intent.createChooser(
                intent,
                "Share QR Code"
            )

        )

    }

}