package com.example.myapplication

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        UserCardList()
    }
}
data class User(var userAvatar: Int,var userName:String,var userBio:String)

@Composable
fun UserCard(user: User){
    Row (verticalAlignment = Alignment.CenterVertically,modifier = Modifier
        .padding(bottom = 10.dp)
        .fillMaxWidth()
        .size(width = 200.dp, height = 100.dp)
        .background(Color.White)
    ){
       Image(
           painter = painterResource(id = user.userAvatar), contentDescription =null,modifier = Modifier
               .size(100.dp)
               .padding(20.dp)
               .clip(CircleShape)

       )
        Column {
            Text(text = user.userName, style = androidx.compose.ui.text.TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            )
            Text(text = user.userBio)
        }
        Text(text = "3 min ago", modifier = Modifier.padding(15.dp), color = Color.Gray)
    }

}

@Composable
fun UserCardList(){
    Box{
        Column {
            var users = listOf<User>(
                User(R.drawable.w700d1q75cms, "张三","眼中山河，何惧秋凉"),
                User(R.drawable.w700d1q75cms, "张三","眼中山河，何惧秋凉"),
                User(R.drawable.w700d1q75cms, "张三","眼中山河，何惧秋凉"),
                User(R.drawable.w700d1q75cms, "张三","眼中山河，何惧秋凉"),
                User(R.drawable.w700d1q75cms, "张三","眼中山河，何惧秋凉"),
                User(R.drawable.w700d1q75cms, "张三","眼中山河，何惧秋凉"),
                User(R.drawable.w700d1q75cms, "张三","眼中山河，何惧秋凉"),
            )
            repeat(users.size){index->
                UserCard(users[index])
            }
        }
    }
}