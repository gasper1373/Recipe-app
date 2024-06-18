package com.example.recipeapp

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.recipeapp.ui.theme.Pink80

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController) {
    val isFavourite by remember {
        mutableStateOf(false)
    }
    Scaffold(
        content = {
            LazyColumn {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                    ) {
                        // Image
                        Image(
                            painter = painterResource(id = R.drawable.bg_splash),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        IconButton(
                            onClick = {
                                navController.popBackStack()

                            },
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(16.dp)
                                .background(Color.DarkGray, shape = RoundedCornerShape(16.dp))
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color.White,
                                modifier = Modifier.size(200.dp)
                            )
                        }
                        IconButton(
                            onClick = {
                            },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(16.dp)
                                .background(
                                    Color.DarkGray,
                                    shape = RoundedCornerShape(16.dp)
                                )
                        ) {
                            if (!isFavourite) {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "Favourite"
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "Favourite", tint = Color.Gray
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CardMenu1()
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp, bottom = 4.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Ingredients",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.Black,
                            )
                        }
                        CardIngredient1()
                        Spacer(modifier = Modifier.height(4.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Instructions",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.Black,
                            )
                        }
                        InstructionCard1()
                        Spacer(modifier = Modifier.height(100.dp))
                    }
                }
            }
        }
    )
}


@Composable
fun CardMenu1() {
    Card(
        modifier = Modifier
            .width(300.dp)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally) // Align the column in the horizontal center
        ) {
            // Outer Card Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 48.dp),
            ) {
                Text(
                    text = "Category name",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(imageVector = Icons.Default.Timer, contentDescription = "Timer")
                Text("30 mins", fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
                Icon(
                    imageVector = Icons.Default.LocalFireDepartment,
                    contentDescription = "Calories"
                )
                Text(
                    "256 kcal",
                    fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp)
                )
                Icon(
                    imageVector = Icons.Default.Group,
                    contentDescription = "Portions"
                )
                Text(
                    "3 portions",
                    fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
fun CardIngredient1() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, top = 8.dp)
                .align(Alignment.Start) // Align the column in the horizontal center
        ) {
            Text(text = "Pork 1")
            Text(text = "Garlic")
            Text(text = "Spy Sauce 1 tbsp")
            Text(text = "Spring Onions")
            Text(text = "Olive oil")
            Text(text = "Onion")
            Text(text = "Honey")
            Text(text = "Dijon mustard")
            Text(text = "Salt and pepper")
        }
    }
}

@Composable
fun InstructionCard1() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Pink80)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.Start) // Align the column in the horizontal center
        ) {
            Text(
                text = "Preheat the oven to 375°F.\n" +
                        "" +
                        "Rub chicken breasts with olive oil, salt, pepper, paprika, thyme, and rosemary.\",\n" +
                        "" +
                        "Place the chicken in a baking dish.\",\n" +
                        "" +
                        "Bake for 25-30 minutes or until the internal temperature reaches 165°F.\",\n" +
                        "" +
                        "Serve and enjoy!\""
            )
        }
    }
}


//@Preview
//@Composable
//fun MyScaffoldPreview() {
//    DetailScreen()
//}