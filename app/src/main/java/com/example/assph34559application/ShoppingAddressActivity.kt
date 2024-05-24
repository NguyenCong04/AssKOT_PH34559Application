@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class ShoppingAddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GetLayoutShoppingAddress(NavHostController(LocalContext.current))
        }

    }
}

class ShoppingAddress(var id: Int, var nameUser: String, var nameAddress: String)

var listAddress = mutableListOf(
    ShoppingAddress(
        1,
        "Bruno Fernande's",
        "25 rue Robert La-touche, Nice, 06200, Côte D’azure, France"
    ),
    ShoppingAddress(
        2,
        "Bruno Fernande's",
        "25 rue Robert La-touche, Nice, 06200, Côte D’azure, France"
    ),
    ShoppingAddress(
        3,
        "Bruno Fernande's",
        "25 rue Robert La-touche, Nice, 06200, Côte D’azure, France"
    ),
    ShoppingAddress(
        3,
        "Bruno Fernande's",
        "25 rue Robert La-touche, Nice, 06200, Côte D’azure, France"
    ),
)

@Composable
fun GetLayoutShoppingAddress(navController: NavHostController) {
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
            IconButton(onClick = { navController.popBackStack() }) {
                Image(
                    painter = painterResource(id = R.drawable.back3),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
            }

            Text(
                text = "Shipping address",
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
            modifier = Modifier
                .padding(top = 30.dp)
        ) {
            items(listAddress) {
                ItemAddress(it)
            }
        }

    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {

        IconButton(
            onClick = {
                navController.navigate("createAddress")
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
fun ItemAddress(item: ShoppingAddress) {
    var isChecked by remember {
        mutableStateOf(1)
    }


    Column() {
        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
                .selectable(
                    selected = (item.id == isChecked),
                    onClick = {
                        isChecked = item.id
                    },
                    role = Role.Checkbox
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = item.id === isChecked,
                onCheckedChange = null,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xff242424),
                    uncheckedColor = Color(0xff808080)
                )
            )
            Text(
                text = "Use as the shipping address",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                color = Color(if (item.id === isChecked) 0xff242424 else 0xff999999)
            )
        }


        Column(
            modifier = Modifier
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.nameUser,
                    modifier = Modifier.padding(17.dp),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff303030),
                    fontWeight = FontWeight(700)
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(top = 5.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.edit2),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp, 25.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
                    .height(1.5.dp)
                    .background(Color(0xffF0F0F0))
            ) {}
            Text(
                text = item.nameAddress,
                modifier = Modifier.padding(start = 17.dp, end = 17.dp),
                fontFamily = FontFamily.Serif,
                color = Color(0xff808080),
                fontWeight = FontWeight(400),
                lineHeight = 25.sp,
                fontSize = 14.sp
            )


        }


    }
    Spacer(modifier = Modifier.height(25.dp))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingShoppingAddress() {
    GetLayoutShoppingAddress(NavHostController(LocalContext.current))

}