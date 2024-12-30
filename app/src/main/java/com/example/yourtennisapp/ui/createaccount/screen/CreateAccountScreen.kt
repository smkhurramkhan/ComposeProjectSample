package com.example.yourtennisapp.ui.createaccount.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapptoolkit.extensions.empty
import com.example.yourtennisapp.common.AddBottomLogo
import com.example.yourtennisapp.common.CreateAccountCheckBoxText
import com.example.yourtennisapp.common.CustomTextField
import com.example.yourtennisapp.common.GeboorteTextField
import com.example.yourtennisapp.common.GradientDrawableButton
import com.example.yourtennisapp.common.ToolbarComposable
import com.example.yourtennisapp.ui.theme.YourTennisAppTheme
import com.example.yourtennisapp.utils.VerticalSpacer10dp
import com.example.yourtennisapp.utils.VerticalSpacer20dp
import com.example.yourtennisapp.utils.VerticalSpacer50dp

@Composable
fun CreateAccountScreen(
    onBackButtonClick: () -> Unit,
    nextButtonClick: () -> Unit
) {
    var firstName by remember { mutableStateOf(String.empty) }
    var surName by remember { mutableStateOf(String.empty) }
    var email by remember { mutableStateOf(String.empty) }

    var day by remember { mutableStateOf(String.empty) }
    var month by remember { mutableStateOf(String.empty) }
    var year by remember { mutableStateOf(String.empty) }

    var isChecked by remember { mutableStateOf(false) }


    YourTennisAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start

                ) {
                    VerticalSpacer50dp()

                    ToolbarComposable(
                        onBackButtonClick = onBackButtonClick,
                        title = "Account aanmaken",
                        isMenuTextVisible = true
                    )

                    VerticalSpacer20dp()


                    CustomTextField(
                        value = firstName,
                        onValueChange = { firstName = it },
                        placeholderText = "Voornaam",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )

                    VerticalSpacer10dp()

                    CustomTextField(
                        value = surName,
                        onValueChange = { surName = it },
                        placeholderText = "Achternaam",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )

                    VerticalSpacer10dp()


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        // Label
                        Text(
                            text = "Geboortedatum",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        // Input Fields Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // DD Input
                            GeboorteTextField(
                                value = day,
                                onValueChange = { day = it },
                                placeholder = "DD",
                                modifier = Modifier.weight(1f),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Next
                                )
                            )

                            // MM Input
                            GeboorteTextField(
                                value = month,
                                onValueChange = { month = it },
                                placeholder = "MM",
                                modifier = Modifier.weight(1f),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Next
                                )
                            )

                            // YYYY Input
                            GeboorteTextField(
                                value = year,
                                onValueChange = { year = it },
                                placeholder = "YYYY",
                                modifier = Modifier.weight(2f),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Next
                                )
                            )
                        }
                    }

                    VerticalSpacer10dp()

                    CustomTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholderText = "E-mailadres",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        )
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it }, // Updates the state
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.Green, // Color when checked
                                uncheckedColor = Color.Gray, // Color when unchecked
                                checkmarkColor = Color.White // Color of the checkmark
                            )
                        )

                        CreateAccountCheckBoxText(modifier = Modifier)

                        VerticalSpacer20dp()

                    }

                    VerticalSpacer20dp()

                    GradientDrawableButton(
                        "Volgende",
                        onClick = {
                            nextButtonClick()
                        }
                    )


                }


            }

            AddBottomLogo()
        }

    }
}


@Composable
@Preview(showBackground = true)
fun ShowCreateAccountScreen() {
    CreateAccountScreen({}, {})
}