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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
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

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayoutCart(NavHostController(LocalContext.current))
        }
    }
}

var listCart = mutableListOf(
    Product(
        "Black Simple Lamp",
        12.00f,
        "Minimal Stand is made of by natural wood. The " + "design that is very simple and minimal. This is truly one of the best " + "furniture's in any family for now. With 3 different colors, you can easily " + "select the best match for your home.",
        5.0f,
        R.drawable.image_product1
    ),
    Product(
        "Minimal Stand",
        25.00f,
        "Minimal Stand is made of by natural wood. The " + "design that is very simple and minimal. This is truly one of the best " + "furniture's in any family for now. With 3 different colors, you can easily " + "select the best match for your home.",
        5.0f,
        R.drawable.image_product2
    ),
    Product(
        "Coffee Chair",
        20.00f,
        "Minimal Stand is made of by natural wood. The " + "design that is very simple and minimal. This is truly one of the best " + "furniture's in any family for now. With 3 different colors, you can easily " + "select the best match for your home.",
        5.0f,
        R.drawable.image_product3
    ),
    Product(
        "Simple Desk",
        50.00f,
        "Minimal Stand is made of by natural wood. The " + "design that is very simple and minimal. This is truly one of the best " + "furniture's in any family for now. With 3 different colors, you can easily " + "select the best match for your home.",
        5.0f,
        R.drawable.image_product4
    ),
)


@Composable
fun GetLayoutCart(navController: NavHostController) {
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
            IconButton(onClick = {
                navController.navigate("home")
            }) {
                Image(
                    painter = painterResource(id = R.drawable.back3),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
            }

            Text(
                text = "My cart",
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
                .weight(3f)
                .padding(
                    start = 20.dp, end = 20.dp, top = 30.dp
                )
        ) {

            LazyColumn {
                itemsIndexed(listCart) { index, product ->
                    val isLastItem = index == listCart.size - 1
                    ItemCart(product, isLastItem)
                }

            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.1f)
        ) {

            TextField(value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        text = "Enter your promo code",
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff999999),
                        fontSize = 15.sp
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .shadow(
                        elevation = 2.dp, shape = RoundedCornerShape(10.dp)
                    )
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                trailingIcon = {
                    IconButton(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .background(
                                Color(0xff303030), shape = RoundedCornerShape(10.dp)
                            )
                            .padding(
                                top = 4.dp, bottom = 4.dp, start = 3.dp
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                })
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 25.dp, end = 25.dp, top = 5.dp, bottom = 10.dp
                    ), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total: ",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff808080),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),

                    )
                Text(
                    text = "$95.00",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff303030),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                )

            }
            Button(
                onClick = {
                    navController.navigate("checkout")
                },
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
                    text = "Check out", fontFamily = FontFamily.Serif, fontWeight =
                    FontWeight(600)
                )
            }
        }

    }
}

@Composable
fun ItemCart(list: Product, isLast: Boolean) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .drawWithContent {
            drawContent()
            if (!isLast) {
                drawLine(
                    color = Color(0xffF0F0F0),
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx()
                )
            }
        }
        .padding(bottom = 10.dp)) {
        Row(
            modifier = Modifier.weight(3f)
        ) {
            Image(
                painter = painterResource(id = list.img),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .shadow(
                        elevation = 1.dp, shape = RoundedCornerShape(10.dp)
                    )
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp)
            ) {
                Text(
                    text = list.name,
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff999999),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500)
                )
                Text(
                    text = "$${list.price}",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff242424),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier.padding(top = 7.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .background(
                                Color(0xffE0E0E0), shape = RoundedCornerShape(6.dp)
                            )
                            .size(30.dp, 30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp, 14.dp)
                        )


                    }
                    Text(
                        text = "01",
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(600)
                    )
                    IconButton(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .background(
                                Color(0xffE0E0E0), shape = RoundedCornerShape(6.dp)
                            )
                            .size(
                                30.dp, 30.dp
                            )
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.remove),
                            contentDescription = null,
                            modifier = Modifier.size(11.dp, 11.dp)

                        )


                    }
                }

            }
        }
        IconButton(
            onClick = { }, modifier = Modifier.weight(0.2f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.delete),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 25.dp)
                    .size(20.dp, 20.dp)
            )
        }
    }
    Spacer(modifier = Modifier.height(15.dp))
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingCart() {
    GetLayoutCart(NavHostController(LocalContext.current))
}