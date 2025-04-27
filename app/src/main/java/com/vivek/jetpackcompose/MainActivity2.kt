package com.vivek.jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivek.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlinx.coroutines.launch

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                snackBarDemp()
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun snackBarDemp(){
        val scaffoldState : BottomSheetScaffoldState = rememberBottomSheetScaffoldState()
        val coroutineScope = rememberCoroutineScope()

        Scaffold(){
            Button(onClick = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Hello")
                }
            }) { }
        }

    }

    @Preview
    @Composable
    fun buttonDemo(){
        Button(onClick = {
            println("Button Clicked")
        }, colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Red
        ))
        {
            Text(text = "Click Me",color = Color.White,modifier = Modifier.border(width = 1.dp,color = Color.Black))
        }

        TextButton(onClick = {
            println("Text Button Clicked")
        }, enabled = false)
        {
            Text(text = "TV Click Me2", style = MaterialTheme.typography.labelSmall, modifier = Modifier.padding(5.dp))
        }

        OutlinedButton (onClick = {
            println("Button Clicked")
        }, enabled = false, shape = CutCornerShape(5.dp))
        {
            Text(text = "Click Me2",color = Color.Blue)
        }
    }

}


