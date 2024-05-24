package com.example.assph34559application.customcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.Normalizer.Form


@Composable
fun OutLineTextFieldCompose(
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    placeholder: String

) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = label,
                    color = Color(0xff808080),
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Serif,
                )
            },
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color(0xffB3B3B3),
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight(500)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xffDBDBDB),
                focusedBorderColor = Color(0xffDBDBDB)
            )
        )

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingCustomOutLineTextField() {
    OutLineTextFieldCompose(
        value = "",
        onValueChange = {},
        label = "Zipcode (Postal Code)",
        placeholder = "Pham Cong Thanh"
    )
}
