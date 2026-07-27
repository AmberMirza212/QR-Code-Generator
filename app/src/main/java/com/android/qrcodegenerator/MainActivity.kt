package com.android.qrcodegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.qrcodegenerator.ui.QRGeneratorScreen
import com.android.qrcodegenerator.ui.theme.QRCodeGeneratorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QRCodeGeneratorTheme {
                QRGeneratorScreen()
            }
        }
    }
}
