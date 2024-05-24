@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package com.example.assph34559application.customcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextFieldCompose(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (value: String) -> Unit,
    trailingIcon: ImageVector?,
    border: Boolean,
    modifier: Modifier,
    colorContainer:Long
) {
    Column(
        modifier = Modifier
    ) {

        TextField(
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
            modifier = modifier
                .fillMaxWidth()
                .shadow(
                    elevation = if (border !== true) 1.dp else 0.dp,
                    shape = RoundedCornerShape(5.dp)
                )
                .background(
                    color = if (border === true) Color.Transparent else Color(colorContainer),
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(1.5.dp)
                .border(
                    border = if (border === true) BorderStroke(
                        width = 1.dp,
                        color = Color(0xffDBDBDB)
                    )
                    else BorderStroke(0.dp, color = Color.Transparent),
                    shape = if (border === true) RoundedCornerShape(5.dp)
                    else RoundedCornerShape(0.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = if (border === true) Color.Transparent else Color
                    (colorContainer),
                unfocusedContainerColor = if (border === true) Color.Transparent else Color
                    (colorContainer),
                focusedLabelColor = Color(0xffff808080),
                unfocusedLabelColor = Color(0xffff808080),
                focusedPlaceholderColor = Color(0xffB3B3B3),
                unfocusedPlaceholderColor = Color(0xffB3B3B3)
            ),
            trailingIcon = {
                @Suppress("UNUSED_EXPRESSION")
                if (trailingIcon === null) null else
                    Icon(
                        imageVector = trailingIcon, contentDescription
                        = null
                    )
            }
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingTextField() {
    TextFieldCompose(
        label = "Full name", placeholder = "Ex: Bruno Phan", value = "",
        onValueChange = {}, trailingIcon = null, border = false, modifier = Modifier,
        colorContainer = 0xffF5F5F5
    )

}