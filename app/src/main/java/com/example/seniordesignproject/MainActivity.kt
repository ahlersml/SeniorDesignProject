package com.example.seniordesignproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.seniordesignproject.ui.theme.SeniorDesignProjectTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        viewModel.selectedTab.value = "Rooms"
        super.onCreate(savedInstanceState)
        setContent {
            SeniorDesignProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    BuildHomePage(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun BuildHomePage(viewModel: MainViewModel) {
    var screenHeightUnit = LocalConfiguration.current.screenHeightDp.dp/14
    var bannerHeight = screenHeightUnit
    var lowerBannerHeight = screenHeightUnit
    var mainPageHeight = LocalConfiguration.current.screenHeightDp.dp-(lowerBannerHeight + bannerHeight)

    Column(
        Modifier
            .fillMaxHeight(),
    ) {
        Row(
            //background for upper banner mods
            Modifier
                .fillMaxWidth()
                .height(bannerHeight)
        ){
            Banner(viewModel = viewModel)
        }
        Row (
            //background for main page space mods
            Modifier
                .fillMaxWidth()
                .height(mainPageHeight)
                .background(color = Color.Gray)
        ){
            MainPage(viewModel = viewModel)
        }
        Row(
            //background for lower banner mods
            Modifier
                .fillMaxWidth()
                .height(lowerBannerHeight)
                .background(color = Color.Blue)
        ){
            LowerBanner(viewModel = viewModel)
        }
    }

}

@Composable
fun Banner(viewModel: MainViewModel){

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
                .background(color = Color.Blue)
        )
        //ADD menu button here
    }

}

@Composable
fun MainPage(viewModel: MainViewModel){
    if(viewModel.selectedTab.value == "Rooms"){
        Rooms(viewModel = viewModel)
    }
    if(viewModel.selectedTab.value == "UpcomingTasks"){
        UpcomingTasks(viewModel = viewModel)
    }
    if(viewModel.selectedTab.value == "CommonTasks"){
        CommonTasks(viewModel = viewModel)
    }
}
@Composable
fun LowerBanner(viewModel: MainViewModel){
    var roomsSelected by remember { mutableStateOf(true)}
    var upcomingTasksSelected by remember {mutableStateOf(false)}
    var commonTasksSelected by remember { mutableStateOf(false)}
    val roomsButtonColor = if(roomsSelected) Color.Green else Color.Red
    val upcomingTasksButtonColor = if(upcomingTasksSelected) Color.Green else Color.Red
    val commonTasksButtonColor = if(commonTasksSelected) Color.Green else Color.Red
    Column (
        Modifier
            .fillMaxWidth(0.33333f)
    ){
        Button(
            onClick = {
                viewModel.selectedTab.value = "Rooms"
                roomsSelected = true
                upcomingTasksSelected = false
                commonTasksSelected = false

            },
            Modifier
                .background(color = roomsButtonColor)
                .fillMaxHeight()
                .fillMaxWidth()
        ){
            Text(
                text = "ButtonText",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
    Column (
        Modifier
            .fillMaxWidth(0.5f)
    ){
        Button(
            onClick = {
                viewModel.selectedTab.value = "UpcomingTasks"
                roomsSelected = false
                upcomingTasksSelected = true
                commonTasksSelected = false
            },
            Modifier
                .background(color = upcomingTasksButtonColor)
                .fillMaxHeight()
                .fillMaxWidth()
        ){
            Text(
                text = "ButtonText",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
    Column (
        Modifier
            .fillMaxWidth()
            .padding(0.dp)
    ){
        Button(
            onClick = {
                viewModel.selectedTab.value = "CommonTasks"
                roomsSelected = false
                upcomingTasksSelected = false
                commonTasksSelected = true
            },
            Modifier
                .background(color = commonTasksButtonColor)
                .fillMaxHeight()
                .fillMaxWidth()
        ){
            Text(
                text = "ButtonText",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun Rooms(viewModel: MainViewModel){
    Text("Rooms")
}

@Composable
fun UpcomingTasks(viewModel: MainViewModel){
    Text("Upcoming Tasks")
}

@Composable
fun CommonTasks(viewModel: MainViewModel){
    Text("CommonTasks")
}
