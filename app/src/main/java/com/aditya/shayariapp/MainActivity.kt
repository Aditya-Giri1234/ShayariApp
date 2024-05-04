package com.aditya.shayariapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aditya.shayariapp.data_layer.util.Constants
import com.aditya.shayariapp.ui.theme.ShayariAppTheme
import com.aditya.shayariapp.ui_layer.screen.ShayariCategoryScreen
import com.aditya.shayariapp.ui_layer.screen.ShayariScreen
import com.aditya.shayariapp.ui_layer.screen.ShayariViewModelPreviewProvider
import com.aditya.shayariapp.ui_layer.view_model.ShayariViewModel

class MainActivity : ComponentActivity() {

    private val viewModel:ShayariViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShayariAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MyApp(innerPadding ,viewModel)
                }
            }
        }
    }
}


@Composable
fun MyApp(paddingValues: PaddingValues, viewModel: ShayariViewModel) {
    Box(modifier = Modifier.padding(paddingValues)){

        val context= LocalContext.current
        val navController= rememberNavController()

        NavHost(navController = navController, startDestination = Constants.Screen.ShayariCategoryScreen.name ){
            composable(route=Constants.Screen.ShayariCategoryScreen.name){
                ShayariCategoryScreen(navController ,viewModel)
            }

            composable(route=Constants.Screen.ShayariScreen.name+"/{id}"){
                val id=it.arguments?.getString("id")
                ShayariScreen(navController,viewModel.getShayariById(id!!.toInt()))
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MyAppPreview(@PreviewParameter(ShayariViewModelPreviewProvider::class) viewModel: ShayariViewModel) {
    ShayariAppTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            MyApp(innerPadding, viewModel = viewModel )
        }
    }
}