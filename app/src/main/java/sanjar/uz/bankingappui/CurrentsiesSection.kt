package sanjar.uz.bankingappui



import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sanjar.uz.bankingappui.data.CurrentsiesSection
import sanjar.uz.bankingappui.ui.theme.GreenStart


val Currentsies =listOf(
    CurrentsiesSection(

        name = "USD",
        buy = 23.32f,
        sell = 23.67f,
        icon = Icons.Rounded.ShoppingCart,
        ),
    CurrentsiesSection(

        name = "RP",
        buy = 23.32f,
        sell = 23.67f,
        icon = Icons.Rounded.ShoppingCart,
    ),CurrentsiesSection(

        name = "YEN",
        buy = 23.32f,
        sell = 23.67f,
        icon = Icons.Rounded.ShoppingCart,
    ),CurrentsiesSection(

        name = "RUP",
        buy = 23.32f,
        sell = 23.67f,
        icon = Icons.Rounded.ShoppingCart,
    ),CurrentsiesSection(

        name = "REAL",
        buy = 23.32f,
        sell = 23.67f,
        icon = Icons.Rounded.ShoppingCart,
    ),CurrentsiesSection(

        name = "YIN",
        buy = 23.32f,
        sell = 23.67f,
        icon = Icons.Rounded.ShoppingCart,
    ),
    )


@Preview
@Composable
fun CurrentsiesSection() {

    var isVisible by remember{
        mutableStateOf(false)
    }
    var iconState by remember{
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .animateContentSize()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {

            Box(modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .clickable {
                    isVisible = !isVisible
                    if (isVisible) {
                        iconState = Icons.Rounded.KeyboardArrowUp
                    } else {
                        iconState = Icons.Rounded.KeyboardArrowDown
                    }
                }

            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = iconState,
                    contentDescription = "Currentsies",
                    tint = MaterialTheme.colorScheme.onSecondary
                )

            }
            Spacer(modifier = Modifier.width(28.dp))
            Text(
                text = "Currentsies",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
        )
        if (isVisible) {
            BoxWithConstraints(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
            ) {

                val boxWithConstraintsScope = this
                val width = boxWithConstraintsScope.maxWidth / 3

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ){
                    Spacer(
                        modifier = Modifier
                            .height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            modifier = Modifier.width(width),
                            text ="Curreny",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground



                        )

                        Text(
                            modifier = Modifier.width(width),
                            text ="Buy",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground



                        )

                        Text(
                            modifier = Modifier.width(width),
                            text ="Sell",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground



                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn {
                        items(Currentsies.size){ index ->
                            CurrentsiesItem(
                                index = index,
                                width = width
                            )


                        }
                    }
                }
        }
    }

    }
}

@Composable
fun CurrentsiesItem(index: Int,width: Dp) {
    val currency = Currentsies[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(GreenStart)
            .padding(4.dp)
        ){
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = currency.icon,
                contentDescription = currency.name,
                tint = Color.White
                )
        }


    }
}