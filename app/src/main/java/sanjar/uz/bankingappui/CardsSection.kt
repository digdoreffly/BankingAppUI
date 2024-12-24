package sanjar.uz.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sanjar.uz.bankingappui.data.Card
import sanjar.uz.bankingappui.ui.theme.BlueEnd
import sanjar.uz.bankingappui.ui.theme.BlueStart
import sanjar.uz.bankingappui.ui.theme.GreenEnd
import sanjar.uz.bankingappui.ui.theme.GreenStart
import sanjar.uz.bankingappui.ui.theme.OrangeEnd
import sanjar.uz.bankingappui.ui.theme.OrangeStart
import sanjar.uz.bankingappui.ui.theme.PurpleEnd
import sanjar.uz.bankingappui.ui.theme.PurpleStart

val cards = listOf(
    Card(
        CardType = "VISA",
        CardNumber = "2323 3232 3323 3223",
        CardName = "Deposito",
        Balance =46.455,
        color= getGradient(PurpleStart, PurpleEnd),
    ),
    Card(
        CardType = "MASTER CARD",
        CardNumber = "113 112 333 373",
        CardName = "Business",
        Balance =46.455,
        color= getGradient(BlueStart, BlueEnd),
    ),
    Card(
        CardType = "VISA",
        CardNumber = "23 3232 23 3223",
        CardName = "Saving",
        Balance =86.775,
        color= getGradient(OrangeStart, OrangeEnd),
    ),
    Card(
        CardType = "MASTER CARD",
        CardNumber = "111 377 236 9993",
        CardName = "School",
        Balance =86.775,
        color= getGradient(GreenStart, GreenEnd),
    ),

    )



fun getGradient(
    startColor: androidx.compose.ui.graphics.Color,
    endColor: androidx.compose.ui.graphics.Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }

    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPadding = 0.dp
    if (index == cards.size - 1) {
        lastItemPadding = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_mastercard)
    if (card.CardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_visa)
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPadding)

    ){
        Column(modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {  }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
                ){
        Image(
            painter = image,
            contentDescription = card.CardName,
            modifier = Modifier.width(60.dp)
        )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.CardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold

            )

            Text(
                text = "$ ${card.Balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold

            )



            Text(
                text = card.CardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold

            )
        }
    }
}