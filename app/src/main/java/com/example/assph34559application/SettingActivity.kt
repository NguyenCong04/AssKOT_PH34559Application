package com.example.assph34559application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
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
import com.example.assph34559application.customcompose.TextFieldCompose

class SettingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            GetLayoutSetting(NavHostController(LocalContext.current))
        }

    }
}


@Composable
fun GetLayoutSetting(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, top = 20.dp, end = 20.dp
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
                text = "Setting",
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
            modifier = Modifier.padding(top = 30.dp)
        ) {
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Personal Information",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(600),
                        color = Color(0xff909191)
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.edit2),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp, 24.dp),
                            tint = Color(0xff808080),
                        )
                    }
                }
                TextFieldCompose(
                    label = "Name",
                    placeholder = "",
                    value = "bruno203@gmail.com",
                    onValueChange = {},
                    trailingIcon = null,
                    border = false,
                    modifier = Modifier.background(
                        color = Color.White
                    ),
                    colorContainer = 0xffffffff
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextFieldCompose(
                    label = "Email",
                    placeholder = "",
                    value = "Bruno Pham",
                    onValueChange = {},
                    trailingIcon = null,
                    border = false,
                    modifier = Modifier.background(
                        color = Color.White
                    ),
                    colorContainer = 0xffffffff
                )

            }

            Column(

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Password",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(600),
                        color = Color(0xff909191)
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.edit2),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp, 24.dp),
                            tint = Color(0xff808080),
                        )
                    }
                }
                TextFieldCompose(
                    label = "Password",
                    placeholder = "",
                    value = "BrunoPhan",
                    onValueChange = {},
                    trailingIcon = null,
                    border = false,
                    modifier = Modifier.background(
                        color = Color.White
                    ),
                    colorContainer = 0xffffffff
                )

            }

            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Notifications",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(600),
                        color = Color(0xff909191)
                    )
                }

                Column(
                    modifier = Modifier.padding(top = 10.dp),

                    ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .shadow(
                                elevation = 2.dp,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(start = 15.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Sales",
                            fontFamily = FontFamily.Serif,
                            color = Color(0xff242424),
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp
                        )
                        IconButton(onClick = { /*TODO*/ }) {
                            Image(
                                painter = painterResource(id = R.drawable.online),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp, 25.dp),
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .shadow(
                                elevation = 2.dp,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(start = 15.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "New arrivals",
                            fontFamily = FontFamily.Serif,
                            color = Color(0xff242424),
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp
                        )
                        IconButton(onClick = { /*TODO*/ }) {
                            Image(
                                painter = painterResource(id = R.drawable.online),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp, 25.dp),
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .shadow(
                                elevation = 2.dp,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(start = 15.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Delivery status changes",
                            fontFamily = FontFamily.Serif,
                            color = Color(0xff242424),
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp
                        )

                    }

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Help Center",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(600),
                        color = Color(0xff909191)
                    )
                }
                Column(
                    modifier = Modifier.padding(top = 15.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .shadow(
                                elevation = 2.dp,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(start = 15.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "FAQ",
                            fontFamily = FontFamily.Serif,
                            color = Color(0xff242424),
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp
                        )
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                modifier = Modifier.size(40.dp, 25.dp),
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                }

            }

        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingSetting() {
    GetLayoutSetting(NavHostController(LocalContext.current))
}