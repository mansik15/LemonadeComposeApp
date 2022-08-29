package com.app.lemonadecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.lemonadecomposeapp.ui.theme.LemonadeComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MakeLemonade()
                }
            }
        }
    }
}

@Composable
fun MakeLemonade() {
    var count by remember { mutableStateOf(1) }
    var result by remember { mutableStateOf(1) }
    val imageResource = when (count) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val stringResource = when (count) {
        1 -> R.string.lemonade_1
        2 -> R.string.lemonade_2
        3 -> R.string.lemonade_3
        else -> R.string.lemonade_4
    }

    Column(
        modifier = Modifier.wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = stringResource))
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = result.toString(),
            Modifier.clickable {
                count++
                result = (1..4).random()
                if (count == 4) { count = 0}
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MakeLemonadePreview() {
    LemonadeComposeAppTheme {
        MakeLemonade()
    }
}