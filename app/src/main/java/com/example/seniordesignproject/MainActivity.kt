package com.example.seniordesignproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seniordesignproject.ui.theme.SeniorDesignProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeniorDesignProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    BuildHomePage()
                }
            }
        }
    }
}

@Composable
fun BuildHomePage() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenWidthDp.dp/6)
    ){
        Banner()
    }

}
@Composable
fun Banner(){

    Column(
        Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp/6)
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .padding(all = 2.dp)

            )
    }

    Column (
        Modifier
            .width((LocalConfiguration.current.screenWidthDp.dp/6)*4)
    ){
        Text(
            text = "APP NAME HERE",
            //add modifications to banner text here
        )
    }

    Column (
        Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp/6)
    ){
        Box(
            Modifier
                .fillMaxSize()
                .background(color= Color.Blue)
        )
        //ADD menu button here
    }

}