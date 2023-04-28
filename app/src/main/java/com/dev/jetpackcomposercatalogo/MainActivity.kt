package com.dev.jetpackcomposercatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.jetpackcomposercatalogo.ui.theme.JetPackComposerCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposerCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MyBox("Android")
                    MyStateExample()
                }
            }
        }
    }
}


@Composable
fun MyStateExample() {
    var counter by rememberSaveable {
        mutableStateOf( 0)
    }
    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "PUSH")
        }
        Text(text = "on push $counter")
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(
        modifier = Modifier
            .width(0.dp)
            .height(size.dp)
    )
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan)
        ) {
            Text(text = "Example 1", modifier = Modifier.align(Alignment.Center), Color.Red)

        }
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
            ) {
                Text(text = "Example 2", modifier = Modifier.align(Alignment.Center), Color.Black)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green)
            ) {
                Text(text = "Example 3", modifier = Modifier.align(Alignment.Center), Color.Blue)
            }
        }
        MySpacer(size = 20)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)
        ) {
            Text(text = "Example 4", modifier = Modifier.align(Alignment.BottomCenter), Color.White)
        }
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(text = "Hola", modifier = Modifier.weight(1f))
        Text(text = "Hola", modifier = Modifier.weight(1f))
        Text(text = "Hola", modifier = Modifier.weight(1f))
        Text(text = "Hola", modifier = Modifier.weight(1f))
    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Example one", modifier = Modifier.background(Color.Red))
        Text(text = "Example one", modifier = Modifier.background(Color.Blue))
        Text(text = "Example one", modifier = Modifier.background(Color.Black))
        Text(text = "Example one", modifier = Modifier.background(Color.Cyan))
    }
}

@Composable
fun MyBox(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Blue)
        ) {
            Text(text = "Box 2", modifier = Modifier.align(Alignment.Center), Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposerCatalogoTheme {
        //MyBox("Android")
        //MyColumn()
        //MyRow()
        //MyComplexLayout()
        MyStateExample()
    }
}