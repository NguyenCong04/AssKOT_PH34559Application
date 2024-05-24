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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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

class FavoriteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayoutFavorite(NavHostController(LocalContext.current))
        }
    }
}


@Composable
fun GetLayoutFavorite(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp, 20.dp),
                    tint = Color(0xff242424)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Favorite",
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                    color = Color(0xff242424),
                    fontWeight = FontWeight(600)
                )

            }

            IconButton(
                onClick = {
                    navController.navigate("cart")
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp, 20.dp),
                    tint = Color(0xff242424)

                )
            }
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
                    ItemFavorite(product, isLastItem)
                }

            }

        }

        Column(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
                .weight(0.4f),
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
                    text = "Add all to my cart", fontFamily = FontFamily.Serif,
                    fontWeight =
                    FontWeight(600)
                )
            }
        }

    }
}

@Composable
fun ItemFavorite(list: Product, isLast: Boolean) {
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

            }
        }
        Column(
            modifier = Modifier.weight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            IconButton(
                onClick = { },

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = 21.dp)
                        .size(20.dp, 20.dp)
                )
            }
            IconButton(
                onClick = { },
                modifier = Modifier
                    .padding(top = 18.dp)
                    .background(
                        color = Color(0xffE0E0E0),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(35.dp, 35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add_cart3),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp, 20.dp)
                )
            }
        }

    }
    Spacer(modifier = Modifier.height(15.dp))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingFavorite() {
    GetLayoutFavorite(NavHostController(LocalContext.current))
}