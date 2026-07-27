package com.android.qrcodegenerator.model

import android.graphics.Bitmap

data class QRState(

    val input: String = "",

    val qrBitmap: Bitmap? = null,

    val error: String? = null

)