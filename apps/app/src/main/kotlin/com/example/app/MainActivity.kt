package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.ui.theme.MultiModuleExampleAppTheme
import com.example.module.GreetingA
import com.example.module.GreetingB
import com.example.module.GreetingC
import com.example.module.GreetingD
import com.example.module.GreetingE
import com.example.module.GreetingF
import com.example.module.GreetingG
import com.example.module.GreetingH
import com.example.module.GreetingI
import com.example.module.GreetingJ
import com.example.module.GreetingK

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MultiModuleExampleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val messages = listOf(
        GreetingA.greeting(),
        GreetingB.greeting(),
        GreetingC.greeting(),
        GreetingD.greeting(),
        GreetingE.greeting(),
        GreetingF.greeting(),
        GreetingG.greeting(),
        GreetingH.greeting(),
        GreetingI.greeting(),
        GreetingJ.greeting(),
        GreetingK.greeting()
    )
    
    LazyColumn(modifier = modifier) {
        items(messages) { message ->
            Text(text = message)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultiModuleExampleAppTheme {
        Greeting()
    }
}