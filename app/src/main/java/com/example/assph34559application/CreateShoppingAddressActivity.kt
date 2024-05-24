package com.example.assph34559application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

class CreateShoppingAddressActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GetLayoutCreateShoppingAddress(NavHostController(LocalContext.current))
        }


    }
}


@Composable
fun GetLayoutCreateShoppingAddress(navController: NavHostController) {

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
                text = "Create shopping address",
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
            modifier = Modifier.padding(top = 20.dp)
        ) {
            TextFieldCompose(
                label = "Full name",
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
                label = "Address",
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
                label = "Zipcode (Postal Code)",
                placeholder = "Pham Cong Thanh",
                value = "",
                onValueChange = {},
                trailingIcon = null,
                border = true,
                modifier = Modifier,
                colorContainer = 0xffF5F5F5

            )
            Spacer(modifier = Modifier.height(15.dp))

            TextFieldCompose(
                label = "Country",
                placeholder = "Select Country",
                value = "",
                onValueChange = {},
                trailingIcon = Icons.Default.KeyboardArrowDown,
                border = false,
                modifier = Modifier,
                colorContainer = 0xffF5F5F5

            )
            Spacer(modifier = Modifier.height(15.dp))

            TextFieldCompose(
                label = "City",
                placeholder = "New York",
                value = "",
                onValueChange = {},
                trailingIcon = Icons.Default.KeyboardArrowDown,
                border = true,
                modifier = Modifier,
                colorContainer = 0xffF5F5F5

            )
            Spacer(modifier = Modifier.height(15.dp))

            TextFieldCompose(
                label = "District",
                placeholder = "Select District-",
                value = "",
                onValueChange = {},
                trailingIcon = Icons.Default.KeyboardArrowDown,
                border = false,
                modifier = Modifier,
                colorContainer = 0xffF5F5F5

            )

        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            verticalArrangement = Arrangement.Bottom
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

@Composable
fun Sp() {
    Spacer(modifier = Modifier.height(5.dp))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingCreateShoppingAddress() {
    GetLayoutCreateShoppingAddress(NavHostController(LocalContext.current))
}