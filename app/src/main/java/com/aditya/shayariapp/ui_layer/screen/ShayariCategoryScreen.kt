package com.aditya.shayariapp.ui_layer.screen

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Book
import androidx.compose.material.icons.rounded.KeyboardDoubleArrowRight
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aditya.shayariapp.data_layer.util.Constants
import com.aditya.shayariapp.ui_layer.view_model.ShayariViewModel


@Composable
fun ShayariCategoryScreen(navController: NavController, viewModel: ShayariViewModel) {

    Scaffold(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        topBar = {
            Card(
                modifier = Modifier
                    .height(56.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp

                        )
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Shayari Category ", modifier = Modifier.clickable {
                            navController.navigate(Constants.Screen.ShayariScreen.name)
                        }, style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Icon(
                        imageVector = Icons.Rounded.Settings,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }
            }

        }) {

        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
        ) {

            items(viewModel.shayariAllCategory) {
                Box(
                    modifier = Modifier.height(56.dp).fillMaxSize().clip(RoundedCornerShape(10.dp))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(10.dp).background(Color.Green).padding(5.dp).clickable {
                                                                                                                          navController.navigate(Constants.Screen.ShayariScreen.name+"/${it.id}")
                        } ,
                        horizontalArrangement = Arrangement.SpaceBetween ,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Rounded.Book, contentDescription =null  , tint = Color.Red)
                        Text(text = it.name.toString() , style = TextStyle(
                            color = Color.Black
                        )
                        )
                        Icon(imageVector = Icons.Rounded.KeyboardDoubleArrowRight, contentDescription =null  ,tint=Color.DarkGray )
                    }
                }
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun MyPreview(@PreviewParameter(ShayariViewModelPreviewProvider::class) viewModel: ShayariViewModel) {
    ShayariCategoryScreen(navController = rememberNavController(), viewModel = viewModel)
}

class ShayariViewModelPreviewProvider : PreviewParameterProvider<ShayariViewModel> {
    override val values: Sequence<ShayariViewModel> = sequenceOf(
        // Create an instance of your view model with actual data
        ShayariViewModel(MockApplication())
    )
}

class MockApplication : Application()