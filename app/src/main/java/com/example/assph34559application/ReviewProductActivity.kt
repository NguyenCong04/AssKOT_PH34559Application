package com.example.assph34559application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class ReviewProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            GetLayoutReviewProduct(NavHostController(LocalContext.current))
        }

    }
}

class ReviewProduct(
    var image: Int,
    var nameUser: String,
    var date: String,
    var desc: String
)

var listReviewProduct = mutableListOf<ReviewProduct>(
    ReviewProduct(
        R.drawable.avater,
        "Bruno Fernandez",
        "20/03/2020",
        "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
    ),
    ReviewProduct(
        R.drawable.avater,
        "Bruno Fernandez",
        "20/03/2020",
        "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
    ),
    ReviewProduct(
        R.drawable.avater,
        "Bruno Fernandez",
        "20/03/2020",
        "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
    ),
)


@Composable
fun GetLayoutReviewProduct(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp),
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
                text = "Rating & Review",
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
            modifier = Modifier.fillMaxWidth(),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_product2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                        .clip(
                            shape =
                            RoundedCornerShape(10.dp)
                        ),
                    contentScale = ContentScale.Crop,
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Minimal Stand",
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Serif,
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                        Text(
                            text = "4.5",
                            fontSize = 24.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(700),
                            modifier = Modifier.padding(start = 7.dp)
                        )
                    }
                    Text(
                        text = "10 reviews",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(top = 10.dp)
                    )

                }

            }

            Row(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color(0xffF0F0F0)
                    )
            ) {}

            LazyColumn(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxSize()
            ) {
                items(listReviewProduct) {
                    ItemReviewProduct(it)
                }

            }
            Column(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth()
                    .background(Color.Red)

            ) {
                Button(
                    onClick = { /*TODO*/ },
                ) {
                    Text(text = "Write a review")
                }
            }


        }


    }

}

@Composable
fun ItemReviewProduct(items: ReviewProduct) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .shadow(
                        elevation = 2.dp,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(
                        color = Color(0xffFFFFFF)
                    )
                    .padding(top = 30.dp, end = 15.dp, start = 15.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = items.nameUser,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Serif,
                    )
                    Text(
                        text = items.date,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff808080)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 15.dp, bottom = 15.dp
                        )
                ) {
                    {

                    }
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        modifier = Modifier
                            .size(17.dp, 17.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .size(17.dp, 17.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .size(17.dp, 17.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .size(17.dp, 17.dp)
                    )
                    
                }
                Text(
                    text = items.desc,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight(400),
                    color = Color(0xff242424),
                    textAlign = TextAlign.Justify,
                    lineHeight = 19.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )


            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = items.image),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp, 40.dp)
                    )
                }

            }
        }

    }
    Spacer(modifier = Modifier.height(50.dp))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingReviewProduct() {
    GetLayoutReviewProduct(NavHostController(LocalContext.current))
}