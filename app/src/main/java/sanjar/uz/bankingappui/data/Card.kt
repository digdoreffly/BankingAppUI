package sanjar.uz.bankingappui.data

import androidx.compose.ui.graphics.Brush

 data class  Card(
    val CardType: String,
    val CardNumber: String,
    val CardName: String,
    val Balance: Double,
    val color: Brush,
)
