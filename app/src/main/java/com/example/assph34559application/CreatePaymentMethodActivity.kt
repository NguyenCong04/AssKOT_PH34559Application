package com.example.assph34559application

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.assph34559application.customcompose.TextFieldCompose

class CreatePaymentMethodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GetLayoutCreatePaymentMethod(NavHostController(LocalContext.current))
        }


    }
}


@Composable
fun GetLayoutCreatePaymentMethod(navController: NavHostController) {
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
                text = "Create payment method",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight(700)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
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
                    Row() {
                        Image(
                            painter = painterResource(
                                id = R.drawable.mastercard2
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp, 27.dp)
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.visa
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(40.dp, 30.dp)
                        )
                    }

                    Text(
                        text = maskPhoneNumber("* * * * * * XXL"),
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
                                text = "XXXXXX",
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
                                text = "XX/XX",
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

        Column(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            TextFieldCompose(
                label = "CardHolder Name",
                placeholder = "Ex: Bruno Pham",
                value = "",
                onValueChange = {},
                trailingIcon = null,
                border = false,
                modifier = Modifier,
                colorContainer = 0xffF5F5F5
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextFieldCompose(
                label = "Card Number",
                placeholder = "**** **** **** 3456",
                value = "",
                onValueChange = {},
                trailingIcon = null,
                border = true,
                modifier = Modifier,
                colorContainer = 0xffF5F5F5

            )
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextFieldCompose(
                    label = "CVV",
                    placeholder = "Ex: 123",
                    value = "",
                    onValueChange = {},
                    trailingIcon = null,
                    border = false,
                    modifier = Modifier.width(157.dp),
                    colorContainer = 0xffF5F5F5
                )
                Spacer(modifier = Modifier.width(10.dp))

                TextFieldCompose(
                    label = "Expiration Date",
                    placeholder = "03/22",
                    value = "",
                    onValueChange = {},
                    trailingIcon = null,
                    border = true,
                    modifier = Modifier.width(200.dp).height(61.dp),
                    colorContainer = 0xffF5F5F5
                    
                )

            }

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff242424)
                )
            ) {
                Text(
                    text = "SAVE ADDRESS",
                    fontWeight = FontWeight(500),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                )
            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingCreatePaymentMethod() {
    GetLayoutCreatePaymentMethod(NavHostController(LocalContext.current))
}