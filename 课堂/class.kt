import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun MyApp(modifier: Modifier =Modifier){
    var shouldshowOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface (modifier, color = MaterialTheme.colorScheme.background){
        if (shouldshowOnboarding){
        OnboardingScreen(onContinueClicked = {shouldshowOnboarding = false})
    }else {
        Greetings()
    }
    }
}
@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
     Column (
         modifier = modifier.fillMaxSize(),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally,
       ){
         Text("Come on ")
         Button(
             modifier = Modifier.padding(vertical = 24.dp),
             onClick = onContinueClicked
         ){
             Text("Continue")
         }
     }
     }
@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(100){"$it"},
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names){name ->
            Greeting(name =name)
        }
    }
}
@Composable
private fun Greeting(name :String, modifier: Modifier = Modifier){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ){
        CardContent(name)
    }
}

@Composable
fun CardContent(name: String) { 
    var expanded by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ){
        Column (
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ){
           Text(text = "Hello, ")
           Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
           )
        if (expanded){
            Text(text = "奥利给".repeat(10))
        }
        }
        IconButton(onClick = {expanded = !expanded}) {
            Icon(
                imageVector = if(expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = if (expanded){
                    stringResource(R.string.show_less)
                }else{
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun  MyAppPreview(){
    MyApplicationTheme{
        MyApp(Modifier.fillMaxSize())
    }
}


