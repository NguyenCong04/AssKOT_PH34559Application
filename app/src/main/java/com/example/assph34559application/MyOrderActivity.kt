@file:Suppress("UNUSED_EXPRESSION", "DEPRECATED_IDENTITY_EQUALS")

package com.example.assph34559application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class MyOrderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            GetLayoutOrder(NavHostController(LocalContext.current))
        }

    }
}

// 0 Delivered
// 1 Processing
// -1 Canceled

class Order(
    var nameOrder: String, var date: String, var quantity: Int, var total:
    Float, var status: Int
)

var listStatus = mutableListOf("Delivered", "Processing", "Canceled")

var listOrder = mutableListOf(
    Order("Order No238562312", "20/03/2020", 3, 150f, 0),
    Order("Order No238562312", "20/03/2020", 3, 150f, 0),
    Order("Order No238562312", "20/03/2020", 3, 150f, 0),

    )


@Composable
fun GetLayoutOrder(navController: NavHostController) {
    var rememberStatus by remember {
        mutableStateOf("Delivered")
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, top = 20.dp, end = 20.dp
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back3),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
            }

            Text(
                text = "My order",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight(700)
            )


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 25.dp, start = 15.dp, end
                    = 15.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listStatus.forEach { item ->
                Text(
                    text = item,
                    fontSize = 17.sp,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .selectable(
                            selected = true,
                            onClick = {
                                rememberStatus = item
                            }
                        )
                        .drawWithContent {
                            drawContent()
                            val lineWidth = 50.dp.toPx()  // Set the desired line width
                            // here
                            val startX = (size.width - lineWidth) / 2
                            val endX = startX + lineWidth

                            if (item === rememberStatus)

                                drawLine(
                                    color = Color(0xff242424),
                                    start = Offset(startX, size.height),
                                    end = Offset(endX, size.height),
                                    strokeWidth = 4.dp.toPx(),
                                    cap = StrokeCap.Round
                                )
                            else null

                        }
                        .padding(8.dp),
                    color = if (item === rememberStatus) Color(0xff242424) else Color
                        (0xff999999),
                    fontWeight = if (item === rememberStatus) FontWeight(700) else
                        FontWeight(400)
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(
                    start = 15.dp,
                    end = 15.dp, top = 30.dp
                ),
        ) {
            items(listOrder) {
                ItemOrder(it)
            }
        }


    }
}


@Composable
fun ItemOrder(listOrder: Order) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 10.dp, bottom = 10.dp)
            .height(175.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp, end = 20.dp, top = 20.dp, bottom
                    = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = listOrder.nameOrder,
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight(600)
            )
            Text(
                text = listOrder.date,
                fontSize = 14.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight(400),
                color = Color(0xff808080)
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xffF0F0F0))

        ) {}
        Column(

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp, end = 20.dp, top = 5.dp, bottom = 10.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(

                ) {
                    Text(
                        text = "Quantity: ",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(500),
                        color = Color(0xff808080)
                    )
                    Text(
                        text = "${listOrder.quantity}",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(700),
                        color = Color(0xff242424)
                    )
                }
                Row(

                ) {
                    Text(
                        text = "Total Amount: ",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(500),
                        color = Color(0xff808080)
                    )
                    Text(
                        text = "\$${listOrder.total}",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(700),
                        color = Color(0xff242424)
                    )
                }


            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp, top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(100.dp,36.dp),
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 4.dp,
                        bottomStart = 0.dp, bottomEnd = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff242424)
                    )
                ) {
                    Text(
                        text = "Detail")
                }
                Text(
                    text =
                    if (listOrder.status === 0) "Delivered"
                    else if (listOrder.status == 1) "Processing"
                    else "Canceled",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff27AE60)
                )

            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingMyOrder() {
    GetLayoutOrder(NavHostController(LocalContext.current))

}