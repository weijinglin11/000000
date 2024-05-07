package com.example.middleexam
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.middleexam.ui.theme.MiddleExamTheme

@Composable
fun Navigator(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home" ){
        composable("home"){ HomePage(navController)}
        composable("commodity"){ CommodityPage(navController, user.Commodity)}
        composable("equipment"){ EquipmentPage(navController, user.Equipment)}
        composable("endPage"){ endPage()}
    }
}
@Composable
fun HomePage(navController: NavController){
    Column {
        Button(onClick = {
            navController.navigate("Commodity")
        }) {
            Text(text = "Commodity")
        }
        Button(onClick = {
            navController.navigate("EquipmentPage")
        }) {
            Text(text = "EquipmentPage")
        }
        Button(onClick = {
            navController.navigate("EndPage")
        }) {
            Text(text = "EndPage")
        }
    }
}
@Composable
fun CommodityPage(navController: NavController,commodity: List<Commodity>){
    Column {
        Text(text = user.Commodity[0].name, fontSize = 40.sp)
        Text(text = user.Commodity[0].role, fontSize = 40.sp)
        Image(painter = painterResource(id = R.drawable.cce2e53172329c28827e0d3c2356e4c1), contentDescription =null )
        Button(onClick = {
            navController.navigate("Commodity")
        }) {


        }
    }

}
@Composable
fun EquipmentPage(navController: NavController,equipment: List<Equipment>){
    Column {
        Text(text = user.Equipment[0].name, fontSize = 40.sp)
        Text(text = user.Equipment[0].role, fontSize = 40.sp)
        Image(painter = painterResource(id = R.drawable.pc9xegcc7qzvktsn8mj3la), contentDescription = null)
        Button(onClick = {navController.navigate("Equipment")
        }) {

        }
    }
}
fun endPage(){

}
@Composable
@Preview(showSystemUi = true)
fun previewHost(){
    Navigator()
}
