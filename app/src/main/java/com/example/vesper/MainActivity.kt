package com.example.vesper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vesper.designsystem.ui.theme.VesperTheme
import com.example.vesper.features.home.HomeScreen
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VesperTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val count = remember { mutableIntStateOf(0) }
    val elements = listOf(
        "Kotlin",
        "Java",
        "TypeScript",
        "JavaScript",
        "Python",
        "C#",
        "C++",
        "Rust",
        "Swift",
        "Go",
        "Dart",
        "PHP",
        "Ruby",
        "Scala",
        "Elixir",
        "Haskell",
        "Lua",
        "Zig",
        "R",
        "Julia",
        "Clojure",
        "Erlang",
        "F#",
        "Perl",
        "Assembly",
        "SQL",
        "Shell / Bash",
        "Groovy",
        "Solidity",
        "OCaml"
    )
    LazyHorizontalStaggeredGrid(
        rows = StaggeredGridCells.Fixed(1),
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalItemSpacing = 8.dp,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(50) { _ ->
            Box(
                Modifier
                    .height(72.dp)
                    .width(Random.nextInt(50, 200).dp)
                    .background(
                        Color(
                            Random.nextInt(255),
                            Random.nextInt(255),
                            Random.nextInt(255),
                            255
                        )
                    )
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    VesperTheme {
        Greeting("Android")
    }
}