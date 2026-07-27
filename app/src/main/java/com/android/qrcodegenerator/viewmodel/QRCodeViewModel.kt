package com.android.qrcodegenerator.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.android.qrcodegenerator.model.QRState
import com.android.qrcodegenerator.util.QRCodeGenerator

class QRCodeViewModel : ViewModel() {

    var state by mutableStateOf(QRState())
        private set

    fun updateInput(value: String) {
        state = state.copy(
            input = value,
            error = null
        )
    }

    fun generateQR() {
        if (state.input.isBlank()) {
            state = state.copy(
                error = "Please enter text or URL."
            )
            return
        }

        val bitmap = QRCodeGenerator.generateQRCode(
            state.input
        )

        state = state.copy(
            qrBitmap = bitmap,
            error = null
        )
    }
}
