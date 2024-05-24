@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package com.example.assph34559application

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class PaymentMethodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GetLayoutPaymentMethod(NavHostController(LocalContext.current))
        }


    }
}

class PaymentMethod(
    var id: Int,
    var type: String,
    var numberCard: String,
    var nameCard: String,
    var date: String
)

var listPaymentMethod = mutableListOf(
    PaymentMethod(1, "master", "0987654323947", "Jennyfer Doe", "05/23"),
    PaymentMethod(3, "visa", "0987654323947", "Jennyfer Doe", "05/23"),
    PaymentMethod(4, "visa", "0987654323947", "Jennyfer Doe", "05/23"),
    PaymentMethod(5, "visa", "0987654323947", "Jennyfer Doe", "05/23"),
    PaymentMethod(6, "visa", "0987654323947", "Jennyfer Doe", "05/23"),
)


@SuppressLint("AutoboxingStateCreation")
@Composable
fun GetLayoutPaymentMethod(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, top = 20.dp, end = 20.dp
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {

                Image(
                    painter = painterResource(id = R.drawable.back3),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
            }

            Text(
                text = "Payment method",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight(700)
            )


        }

        LazyColumn(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            items(listPaymentMethod) {
                ItemPaymentMethod(it)
            }
        }


    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {

        IconButton(
            onClick = {
                navController.navigate("createPayment")
            },
            modifier = Modifier
                .padding(end = 20.dp, bottom = 20.dp)
                .size(60.dp, 60.dp)
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(50.dp)
                )
                .background(
                    Color(0xffffffff),
                    shape = RoundedCornerShape(50.dp)
                ),

            ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }

    }


}

@Composable
fun ItemPaymentMethod(item: PaymentMethod) {

    var isCheck by remember {
        mutableIntStateOf(1)
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(10.dp)
                )
                .height(180.dp)
                .background(color = Color(0xff242424))
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {

                Column(
                    modifier = Modifier.padding(start = 30.dp, top = 20.dp, end = 30.dp)
                ) {
                    Image(
                        painter = painterResource(
                            id = if (item.type === "master") R.drawable.mastercard2
                            else R.drawable.visa
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(35.dp, 27.dp)
                    )
                    Text(
                        text = maskPhoneNumber(item.numberCard),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                        color = Color.White,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(400),
                        fontSize = 20.sp
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column() {
                            Text(
                                text = "Card Holder Name",
                                fontFamily = FontFamily.Serif,
                                color = Color.White,
                                fontSize = 12.sp
                            )
                            Text(
                                text = item.nameCard,
                                fontFamily = FontFamily.Serif,
                                color = Color.White,
                                fontWeight = FontWeight(600)
                            )
                        }

                        Column() {
                            Text(
                                text = "Expiry Date",
                                fontFamily = FontFamily.Serif,
                                color = Color.White,
                                fontSize = 12.sp

                            )
                            Text(
                                text = item.date,
                                fontFamily = FontFamily.Serif,
                                color = Color.White,
                                fontWeight = FontWeight(600)
                            )
                        }


                    }

                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bottom_pay),
                        contentDescription = null,
                        modifier = Modifier.size(280.dp, 100.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .clickable { isCheck === item.id },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = item.id === isCheck,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xff242424),
                    uncheckedColor = Color(0xff9B9B9B)
                ),
                onCheckedChange = null
            )
            Text(
                text = "Use as default payment method",
                fontSize = 14.sp,
                color = Color(0xff242424),
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(start = 5.dp)
            )
        }

    }
    Spacer(modifier = Modifier.height(20.dp))
}

fun maskPhoneNumber(phoneNumber: String, visibleDigits: Int = 3): String {
    val maskedLength = phoneNumber.length - visibleDigits
    val maskedPart = "*".repeat(maskedLength)
    val visiblePart = phoneNumber.takeLast(visibleDigits)
    val maskedPhoneNumber = maskedPart + visiblePart

    // Insert spaces every three digits
    return maskedPhoneNumber.chunked(3).joinToString(" ")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPaymentMethod() {
    GetLayoutPaymentMethod(NavHostController(LocalContext.current))
}