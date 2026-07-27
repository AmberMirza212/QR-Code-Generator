package com.android.qrcodegenerator.ui

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.qrcodegenerator.ui.theme.DarkBlue
import com.android.qrcodegenerator.ui.theme.LightBlue
import com.android.qrcodegenerator.ui.theme.SkyBlue
import com.android.qrcodegenerator.util.FileUtils
import com.android.qrcodegenerator.util.ShareUtils
import com.android.qrcodegenerator.viewmodel.QRCodeViewModel

@Composable
fun QRGeneratorScreen(viewModel: QRCodeViewModel = viewModel()) {
    val state = viewModel.state
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        LightBlue,
                        SkyBlue
                    )
                )
            )
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Icon(
                imageVector = Icons.Default.QrCode,
                contentDescription = null,
                tint = DarkBlue,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "QR Code Generator",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Generate QR Codes instantly",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = state.input,
                onValueChange = {
                    viewModel.updateInput(it)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text("Enter text or URL")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )

            AnimatedVisibility(
                visible = state.error != null,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = state.error ?: "",
                    color = MaterialTheme.colorScheme.error
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    viewModel.generateQR()
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Generate QR")
            }

            Spacer(modifier = Modifier.height(30.dp))

            Card(
                modifier = Modifier.size(260.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Crossfade(
                        targetState = state.qrBitmap,
                        label = "QRAnimation"
                    ) { bitmap ->
                        if (bitmap == null) {
                            Text(
                                "QR Preview",
                                style = MaterialTheme.typography.titleMedium
                            )
                        } else {
                            Image(
                                bitmap = bitmap.asImageBitmap(),
                                contentDescription = "QR Code",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        state.qrBitmap?.let {
                            val saved = FileUtils.saveQRCode(context, it)
                            Toast.makeText(
                                context,
                                if (saved) "QR Code Saved Successfully" else "Failed to Save QR Code",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    enabled = state.qrBitmap != null
                ) {
                    Text("Save")
                }

                Button(
                    onClick = {
                        state.qrBitmap?.let {
                            ShareUtils.shareQRCode(context, it)
                        }
                    },
                    enabled = state.qrBitmap != null
                ) {
                    Text("Share")
                }
            }
            
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
