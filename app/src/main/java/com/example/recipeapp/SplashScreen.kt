package com.example.recipeapp

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipeapp.ui.theme.Orange

@Composable
fun SplashScreen(
    navController: NavController,
    modifier: Modifier = Modifier) {
    Box(
        modifier.fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_splash),
            contentDescription = "Splash Screen",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Adjust padding as needed
        ) {
            // Spacer to push the button to the bottom
            Spacer(modifier = Modifier.weight(1f))
            // Button at the bottom end
            Button(
                onClick = {
                          navController.navigate("mainScreen")
                },
                modifier = Modifier
                    .align(Alignment.Start)
            ) {
                Text(text = "Get Started")
            }
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun SplashScreenPreview() {
//    SplashScreen()
//}