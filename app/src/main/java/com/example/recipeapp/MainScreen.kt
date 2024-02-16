package com.example.recipeapp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipeapp.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {

    var isSearchBarActivate by remember {
        mutableStateOf(false)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar()
        },
    ) { paddingValues ->
        //My Screen content goes here
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp)

            ) {
                items(5) { index ->
                    LazyBox(text = index.toString())
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Category Name",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)

            ) {
                items(5) { index ->
                    LazyLargeBox(text = index.toString())
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "All Recipes",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        },
    )
}

@Composable
fun SearchBar() {
    val searchText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text(text = "Search for recipes") },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        leadingIcon = {
            Image(imageVector = Icons.Default.Search, contentDescription = "")
        },
        trailingIcon = {
            if (searchText.isEmpty()) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear text"
                    )
                }
            }
        },

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun LazyBox(text: String) {
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
            .background(Orange, shape = RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat_img),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.TopEnd)
        )
        Text(
            text = "Dish Name",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 8.dp, start = 8.dp)
        )
    }
}


@Composable
fun LazyLargeBox(text: String) {
    Column {

        Box(
            modifier = Modifier
                .width(240.dp)
                .height(360.dp)
                .background(Color.Red, shape = RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_splash),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = "Dish Name",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
        )
    }
}


@Preview()
@Composable
fun MainScreenPreview() {
    MainScreen()
}

@Preview
@Composable
fun LazyBoxPreview() {
    // LazyBox(text = "Dish Name")
   // LazyLargeBox(text = "Dish Name")
}