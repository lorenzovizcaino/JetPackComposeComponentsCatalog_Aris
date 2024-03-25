package com.antonio.jetpackcomposecomponentscatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antonio.jetpackcomposecomponentscatalog.ui.CheckInfo
import com.antonio.jetpackcomposecomponentscatalog.ui.MyRangeSlider
import com.antonio.jetpackcomposecomponentscatalog.ui.advancedSlider
import com.antonio.jetpackcomposecomponentscatalog.ui.basicSlider
import com.antonio.jetpackcomposecomponentscatalog.ui.theme.JetPackComposeComponentsCatalogTheme
import com.antonio.jetpackcomposecomponentscatalog.ui.theme.MyAlertDialog
import com.antonio.jetpackcomposecomponentscatalog.ui.theme.MyConfirmmationDialog
import com.antonio.jetpackcomposecomponentscatalog.ui.theme.MyCustomDialog
import com.antonio.jetpackcomposecomponentscatalog.ui.theme.MySimpleCustomDialog
import kotlinx.coroutines.selects.select

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var lista =listOf<String>("Juan", "Maria", "Julia", "Perico", "Antonio", "Remi", "Antia")
            var show by rememberSaveable {mutableStateOf(false)}
            var email by rememberSaveable {mutableStateOf("")}
            JetPackComposeComponentsCatalogTheme {
                // A surface container using the 'background' color from the theme
                //var selected by rememberSaveable { mutableStateOf("Antonio") }
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ){
                       Button(onClick = { show=true }) {
                           Text(text = "Mostrar Dialogo")
                       }
//                        email=MyCustomDialog(show = show, onDismiss = {show=false})
                        email=MyConfirmmationDialog(show=show,onDismiss={show=false})
                        if(email!=""){
                            Text(text = "Has elegido: $email")
                        }


                    }
                    //MyDialog(show = show, onDismiss = {show=false}, onConfirm = {Log.i("Antonio","click")} )
                   // MySimpleCustomDialog(show = show, onDismiss = {show=false})

                }

//                  Este codigo es de MyTriStatusCheckBox()
//                {
//                    val myOptions= getOptions(listOf("Antonio","Ejemplo","Remedios"))
//                    Column() {
//                        MyTriStatusCheckBox()
//                        myOptions.forEach{
//                            MyCheckBoxWithTextCompleted(it)
//                        }
//
//
//                    }
//
//                }
            }
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetPackComposeComponentsCatalogTheme {
        MyBadgeBox()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Helado", "Chocolate", "Cafe", "Natillas", "Fruta")


    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )

        //cuando se pulse el OutlinedTextField el boolean pasa a true y se abre el DropdownMenu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false},  //se llama cuando se cierra el DropdownMenu, pasandolo a false se cierra el mismo
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(
                    text = { dessert },
                    onClick = {
                        expanded = false
                        selectedText = dessert

                    },
                )
                Text(text = dessert)
            }
        }


    }
}

@Composable
fun MyDivider() {
    Divider(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp), color = Color.Green
    )
}

@Composable
fun Myprueba(lista: List<String>) {
    var seleccion by rememberSaveable { mutableStateOf("Juan") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 100.dp),
        verticalArrangement = Arrangement.Center,

        ) {
        lista.forEach { item ->
            Row() {
                RadioButton(selected = seleccion == item, onClick = { seleccion = item })
                Text(item, modifier = Modifier.padding(top = 12.dp))
            }
        }
        Text(text = "Ha sido selecionado $seleccion")


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Blue)
    ) {
        BadgedBox(badge = { Badge { Text(text = "1000") } }
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = ""
            )
        }
    }
}


@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 36.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(contentColor = Color.Green, containerColor = Color.Red),
        border = BorderStroke(5.dp, Color.Green)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row() {
            RadioButton(selected = name == "Antonio", onClick = { onItemSelected("Antonio") })
            Text(text = "Antonio", modifier = Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(selected = name == "Remi", onClick = { onItemSelected("Remi") })
            Text(text = "Remi", modifier = Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(selected = name == "Antia", onClick = { onItemSelected("Antia") })
            Text(text = "Antia", modifier = Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(selected = name == "Oscar", onClick = { onItemSelected("Oscar") })
            Text(text = "Oscar", modifier = Modifier.padding(top = 12.dp))
        }
    }
}

@Composable
fun MyRadioButton() {
    var status by rememberSaveable { mutableStateOf(true) }
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = status, onClick = { status = !status }, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
            )
        )
        Text(text = "Ejemplo 1", modifier = Modifier.padding(top = 12.dp))
    }

}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onChekedChange = { status = it }
        )
    }


}


@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onChekedChange(!checkInfo.selected) })
        Text(text = checkInfo.title, Modifier.padding(12.dp))


    }

}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Text(text = "Ejemplo 1", Modifier.padding(12.dp))


    }

}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Green,
            checkmarkColor = Color.Blue

        )
    )

}

@Composable
fun MySwitch() {
    var estadoSwitch by rememberSaveable { mutableStateOf(false) }
    Switch(
        checked = estadoSwitch,
        onCheckedChange = { estadoSwitch = !estadoSwitch },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,        //los ThumbColor son los colores del switch
            checkedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Magenta,    //los TrackColor son el fondo por defecto gris del switch
            checkedTrackColor = Color.Cyan,


            )
    )

}

@Composable
fun MyProgressAdvance() {
    var estado by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,


        ) {
        CircularProgressIndicator(progress = estado)

        Row(Modifier.fillMaxSize()) {
            Button(onClick = { estado += 0.1f }) {
                Text(text = "Incrementar")
            }

            Button(onClick = { estado -= 0.1f }) {
                Text(text = "Decrementar")
            }
        }

    }
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)

    }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.Green
            )
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar perfil")
        }

    }
}


@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "icono",
        tint = Color.Red
        //implementada la libreria --> implementation ("androidx.compose.material:material-icons-extended:1.4.3")
        //en gradle, se utiliza para tener acceso a muchos mas iconos, OJO dice Aris que ocupa una barbaridad, y que
        //si no es necesaria mejor no implementarla
        //https://fonts.google.com/icons  --> Url de google par ver los iconos disponibles con esta libreria
    )
}

@Composable
fun MyImageAdvanved() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        //modifier = Modifier.clip(RoundedCornerShape(25f)), esquinas imagen redondeadas
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape) // imagen redonda
    )
}


@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        alpha = 0.5f
    )

}

@Composable
fun MyButtonExample() {
    //var enabled=true --> no se puede poner asi por que al clickar el boton se volveria a poner a true
    // y no realizaria su funcion el boton, hay que utilizar la linea de abajo.
    //Y  si utilizamos --> var enabled by remember {mutableStateOf(true) --> al girar la pantalla no nos funcionaria correctamente
    var enabled by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")
        }


        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledContainerColor = Color.Blue,
                disabledContentColor = Color.Magenta
            )
        ) {
            Text(text = "Hola")

        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Hola")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {

    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        Modifier.padding(24.dp),
        label = {
            Text(
                text = "holita"
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvanced() {
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {

                it.replace("a", "")
            } else {
                it
            }

        },
        label = { Text(text = "Introduce tu nombre") })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("Antonio") }
    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", fontFamily = FontFamily.Cursive)
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.LineThrough  //tachado
        )
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.Underline  //subrayado
        )
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                ) //combincion de tachado  y subrayado
            )
        )

        Text(
            text = "Esto es un ejemplo",
            fontSize = 30.sp
        )


    }

}

