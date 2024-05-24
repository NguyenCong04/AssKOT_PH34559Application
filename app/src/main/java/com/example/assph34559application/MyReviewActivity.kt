package com.example.assph34559application

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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

class MyReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GetLayoutMyReview(NavHostController(LocalContext.current))
        }

    }
}

class MyReview(
    var id: Int,
    var image: Int,
    var nameProduct: String,
    var price: Float,
    var star: Int,
    var date: String,
    var desc: String
)

var listReview = mutableListOf(
    MyReview(
        1,
        R.drawable.image_product1,
        "Coffee Table",
        50f,
        4,
        "20/03/2020",
        "Nice Furniture with good delivery. The delivery time is very fast. Then " +
                "products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
    ),
    MyReview(
        1,
        R.drawable.image_product1,
        "Coffee Table",
        50f,
        4,
        "20/03/2020",
        "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
    ),
    MyReview(
        1,
        R.drawable.image_product1,
        "Coffee Table",
        50f,
        4,
        "20/03/2020",
        "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
    ),
    MyReview(
        1,
        R.drawable.image_product1,
        "Coffee Table",
        50f,
        4,
        "20/03/2020",
        "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
    )
)

@Composable
fun GetLayoutMyReview(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, top = 20.dp, end = 20.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {

                Icon(
                    painter = painterResource(id = R.drawable.back3),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp, 20.dp),
                    tint = Color(0xff242424)
                )
            }

            Text(
                text = "My review",
                modifier = Modifier,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight(700)
            )
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(20.dp, 20.dp),
                tint = Color(0xff242424)
            )


        }

        LazyColumn(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 30.dp)
        ) {
            items(listReview) {
                ItemReviewer(list = it)
            }
        }

    }


}

@Composable
fun ItemReviewer(list: MyReview) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(245.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(22.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = list.image),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 15.dp, bottom = 10.dp)
                    .size(70.dp, 70.dp)
                    .clip(
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = list.nameProduct,
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xff606060)
                )
                Text(
                    text = "\$ ${list.price}",
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xff242424)
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
                Spacer(modifier = Modifier.width(3.dp))

            }
            Text(text = list.date,
                fontFamily = FontFamily.Serif,
                fontSize =  12.sp,
                fontWeight = FontWeight(400),
                color = Color(0xff808080)
            )
        }
        Text(text = list.desc,
            fontFamily = FontFamily.Serif,
            fontSize =  13.sp,
            fontWeight = FontWeight(400),
            color = Color(0xff242424),
            textAlign = TextAlign.Justify,
            lineHeight = 20.sp,
            modifier = Modifier.padding(top = 15.dp),
            maxLines = 5,
            overflow = TextOverflow.Ellipsis
        )

    }
    Spacer(modifier = Modifier.height(20.dp))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingMyReview() {
    GetLayoutMyReview(NavHostController(LocalContext.current))
}