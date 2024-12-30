package com.example.yourtennisapp.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapptoolkit.extensions.empty
import com.example.yourtennisapp.ui.theme.blueish
import com.example.yourtennisapp.utils.VerticalSpacer20dp

@Composable
fun ToolbarComposable(
    onBackButtonClick: () -> Unit, title: String,
    isMenuTextVisible: Boolean = false,
    textAlign: TextAlign = Center,
    startPadding: Int = 0
) {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = String.empty,
                modifier = Modifier
                    .size(30.dp)
                    .offset(x = 6.dp, y = 8.dp)
                    .clickable {
                        onBackButtonClick()
                    }
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Annuleer",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .offset(x = 6.dp, y = 8.dp)
                    .padding(end = 10.dp)
                    .alpha(if (isMenuTextVisible) 1f else 0f),
                style = TextStyle(
                    color = blueish,
                    fontWeight = FontWeight.Bold
                )
            )
        }


        VerticalSpacer20dp()

        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(startPadding.dp),
            textAlign = textAlign,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ShowToolbarScreen() {
    ToolbarComposable({}, String.empty)
}