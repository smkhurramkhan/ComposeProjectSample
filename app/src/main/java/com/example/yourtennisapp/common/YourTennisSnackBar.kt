package com.example.yourtennisapp.common

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yourtennisapp.R

@Composable
fun YourTennisSnackBar(
    snackbarHostState: SnackbarHostState,
    snackBarEnum: SnackBarEnum
) {
    SnackbarHost(snackbarHostState) { data ->
        Snackbar(
            elevation = 0.dp,
            backgroundColor = Color(integerResource(id = snackBarEnum.backgroundColor)),
            snackbarData = data,
            shape = MaterialTheme.shapes.medium
        )
    }
}

sealed class SnackBarEnum(val backgroundColor: Int) {
    //TODO("Add your own SnackBarEnum")
    object SUCCESS : SnackBarEnum(R.color.black)
    object ERROR : SnackBarEnum(R.color.black)
}

@Preview
@Composable
private fun BodyPreview() {
    YourTennisSnackBar(
        rememberScaffoldState().snackbarHostState,
        SnackBarEnum.SUCCESS
    )
}