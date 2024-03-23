package com.antonio.jetpackcomposecomponentscatalog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.security.AllPermission
import java.text.DecimalFormat
import java.text.Format

@Composable
fun basicSlider() {
    var valorSlider by rememberSaveable {mutableStateOf(0f)}
    var format:DecimalFormat= DecimalFormat("#.##")
    var valorFormateado:String

    Column(modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally) {
        Slider(value = valorSlider,
            onValueChange = {valorSlider=it},
            colors = SliderDefaults.colors(activeTrackColor = Color.Red, thumbColor = Color.Green)
        )

        valorFormateado=format.format(valorSlider)
        Text(text = valorFormateado)
    }
}

@Composable
fun advancedSlider() {
    var valorSlider by rememberSaveable {mutableStateOf(0f)}
    var valorFinalSlider by rememberSaveable {mutableStateOf("0")}


    Column(modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally) {
        Slider(value = valorSlider,
            onValueChange = {valorSlider=it},
            onValueChangeFinished= {valorFinalSlider=valorSlider.toString()},
            colors = SliderDefaults.colors(activeTrackColor = Color.Red, thumbColor = Color.Green),
            valueRange = 0f..10f,
            steps = 9
        )


        Text(text = valorFinalSlider)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider() {

    Column(horizontalAlignment = CenterHorizontally) {
        var currentRange by remember {mutableStateOf(0f..10f)}
        RangeSlider(
            value = currentRange,
            onValueChange = {currentRange=it},
            valueRange = 0f..10f,
            steps = 9
        )

        Text(text = "Valor inferior: ${currentRange.start}")
        Text(text = "Valor superior: ${currentRange.endInclusive}")

    }




}