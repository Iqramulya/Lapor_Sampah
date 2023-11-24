
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laporsampahapps.R
import com.example.laporsampahapps.ui.theme.LaporSampahAppsTheme
import com.example.laporsampahapps.ui.theme.Purple30
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaporSampahAppsTheme {
                val navController = rememberNavController()
                Surface {
                    NavHost(navController, startDestination = "splash") {
                        composable("splash") { SplashScreen(navController) }
                        composable("homeMenu") { HomeMenu() }
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController? = null) {
    var showSplashScreen by remember { mutableStateOf(true) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = showSplashScreen) {
        coroutineScope.launch {

            delay(2000)
            showSplashScreen = false
            navController?.navigate("homeMenu")
        }
    }

    if (showSplashScreen) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Purple30),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logosampah),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(200.dp)
            )
            Text(
                text = "Lapor Sampah",
                modifier = Modifier.paddingFromBaseline(top = 55.dp),
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = FontFamily.Serif
            )
        }
    }
}

@Composable
fun HomeMenu() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Purple30),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .border(width = 10.dp, color = Color.White, shape = CircleShape)
                .padding(16.dp)
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Red)
                    .padding(8.dp)
            ) {
                Text("Button Merah", color = Color.White)
            }


            Spacer(modifier = Modifier.height(8.dp))


            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Yellow)
                    .padding(8.dp)
            ) {
                Text("Button Kuning", color = Color.Black)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMainContent() {
    LaporSampahAppsTheme {
        SplashScreen(navController = null)
    }
}
