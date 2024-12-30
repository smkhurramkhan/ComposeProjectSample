package com.example.yourtennisapp.common

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.yourtennisapp.R
import com.example.yourtennisapp.ui.theme.blueish

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isPasswordField: Boolean = false,
    modifier: Modifier = Modifier
) {
    val isDarkTheme = isSystemInDarkTheme()
    val textColor = if (isDarkTheme) Color.White else Color.Black
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(16.dp)
            ),
        keyboardOptions = keyboardOptions,
        textStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
        placeholder = {
            Text(
                text = placeholderText,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 15.sp
                ),
                color = Color.LightGray
            )
        },
        singleLine = true
    )
}

@Composable
fun GradientDrawableButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(56.dp)
            .background(Color.Transparent)
    ) {
        AndroidView(
            factory = { context ->
                Button(context).apply {
                    background = context.getDrawable(R.drawable.button_bg)
                    setOnClickListener { onClick() }
                }
            },
            modifier = Modifier
                .matchParentSize()
                .padding(start = 10.dp, end = 10.dp)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SignUpPrompt(
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val annotatedText = buildAnnotatedString {
        append("Nog geen account? ")
        withStyle(
            style = SpanStyle(
                color = blueish,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Maak nu hier aan")
        }

        addStringAnnotation(
            tag = "SIGN_UP", // Tag to identify the clickable text
            annotation = "SignUp",
            start = length - "Maak nu hier aan".length,
            end = length
        )
    }

    // Use a Box to center-align the ClickableText
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),  // Fill the available space
        contentAlignment = Alignment.Center  // Align children to the center
    ) {
        Text(
            text = annotatedText,
            modifier = Modifier.clickable {
                // Handle the click
                onSignUpClick()
            },
            style = TextStyle(
                fontSize = 16.sp
            ),
        )
    }
}

@Composable
fun GeboorteTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    val isDarkTheme = isSystemInDarkTheme()
    val textColor = if (isDarkTheme) Color.White else Color.Black
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange, // Updates the value dynamically
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(color = Color.Gray)
            )
        },
        modifier = modifier.height(56.dp),
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(8.dp), // Rounded corners
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true
    )
}

@Composable
fun CreateAccountCheckBoxText(
    modifier: Modifier = Modifier
) {
    val annotatedText = buildAnnotatedString {
        append("Ik ga akkoord met de algemene voorwaarden, lorem ipsum dolor ")
        withStyle(
            style = SpanStyle(
                color = blueish,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("sit amet.")
        }

        addStringAnnotation(
            tag = "SIGN_UP", // Tag to identify the clickable text
            annotation = "SignUp",
            start = length - "sit amet.".length,
            end = length
        )
    }

    // Use a Box to center-align the ClickableText
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),  // Fill the available space
        contentAlignment = Alignment.Center  // Align children to the center
    ) {
        Text(
            text = annotatedText,
            style = TextStyle(
                fontSize = 16.sp
            ),
        )
    }
}

@Composable
fun PasswordField(
    password: String,
    labelText: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }
    val isDarkTheme = isSystemInDarkTheme()
    val textColor = if (isDarkTheme) Color.White else Color.Black

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        label = {
            Text(
                labelText,
                style = TextStyle(
                    fontSize = 14.sp
                )
            )
        },
        shape = RoundedCornerShape(8.dp), // Rounded corners
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible) {
                Icons.Default.Visibility
            } else {
                Icons.Default.VisibilityOff
            }
            val description = if (passwordVisible) "Hide password" else "Show password"
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, contentDescription = description)
            }
        },
        singleLine = true
    )
}



