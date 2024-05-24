package com.example.assph34559application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class CheckOutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            GetLayoutCheckOut(NavHostController(LocalContext.current))
        }

    }
}

@Composable
fun GetLayoutCheckOut(navController: NavHostController) {
    val stateScroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, top = 10.dp, end = 20.dp
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Image(
                    painter = painterResource(id = R.drawable.back3),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
            }

            Text(
                text = "Check out",
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
                .weight(3f)
                .padding(top = 10.dp)
                .verticalScroll(stateScroll)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Shipping Address",
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                    color = Color(0xff909090),

                    )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.edit2),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp, 24.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth()
                    .shadow(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .height(130.dp)
            ) {
                Text(
                    text = "Bruno Fernandez",
                    modifier = Modifier.padding(17.dp),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff303030),
                    fontWeight = FontWeight(700)
                )
                Row(
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth()
                        .height(1.5.dp)
                        .background(Color(0xffF0F0F0))
                ) {}
                Text(
                    text = "25 rue Robert La touche, Nice, 06200, Côte D’azure, France",
                    modifier = Modifier.padding(start = 17.dp, end = 17.dp),
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff808080),
                    fontWeight = FontWeight(400),
                    lineHeight = 25.sp,
                    fontSize = 14.sp
                )


            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Payment",
                        fontFamily = FontFamily.Serif,
                        fontSize = 18.sp,
                        color = Color(0xff909090),

                        )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.edit2),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .shadow(
                            elevation = 5.dp,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .height(70.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(start = 10.dp, end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(
                            onClick = {},
                            enabled = true,
                            modifier = Modifier
                                .size(65.dp, 40.dp)
                                .padding(start = 10.dp)
                                .shadow(
                                    elevation = 1.5.dp,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .background(
                                    Color(0xffFFFFFF),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(start = 10.dp, end = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.mastercard),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp, 25.dp)
                            )
                        }
                        Text(
                            text = "**** **** **** 3947",
                            color = Color(0xff242424),
                            modifier = Modifier.padding(start = 20.dp),
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            fontFamily = FontFamily.Serif
                        )

                    }

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Delivery method",
                        fontFamily = FontFamily.Serif,
                        fontSize = 18.sp,
                        color = Color(0xff909090),

                        )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.edit2),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .shadow(
                            elevation = 5.dp,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .height(55.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(start = 10.dp, end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.dhl),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 15.dp)
                                .size(100.dp, 25.dp)
                        )
                        Text(
                            text = "Fast (2-3days)",
                            color = Color(0xff242424),
                            modifier = Modifier.padding(start = 20.dp),
                            fontSize = 14.sp,
                            fontWeight = FontWeight(700),
                            fontFamily = FontFamily.Serif
                        )

                    }

                }

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .shadow(
                            elevation = 5.dp,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .height(135.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 15.dp),
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, bottom = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Order: ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(400),
                            color = Color(0xff808080)
                        )
                        Text(
                            text = "\$ 95.00",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(600),
                            color = Color(0xff242424)
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, bottom = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Text(
                            text = "Delivery: ", fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(400),
                            color = Color(0xff808080)
                        )
                        Text(
                            text = "\$ 5.00", fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(600),
                            color = Color(0xff242424)
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Text(
                            text = "Total: ", fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(400),
                            color = Color(0xff808080)
                        )
                        Text(
                            text = "\$ 100.00", fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(600),
                            color = Color(0xff242424)
                        )

                    }

                }

            }

        }
        Column(
            modifier = Modifier.fillMaxHeight().weight(0.3f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp)
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(10.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff242424)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "SUBMIT ORDER", fontFamily = FontFamily.Serif, fontWeight =
                    FontWeight(600)
                )
            }
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingCheckOut() {
    GetLayoutCheckOut(NavHostController(LocalContext.current))

}