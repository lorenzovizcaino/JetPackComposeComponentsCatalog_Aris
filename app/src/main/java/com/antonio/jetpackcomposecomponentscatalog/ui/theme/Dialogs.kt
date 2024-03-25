package com.antonio.jetpackcomposecomponentscatalog.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.antonio.jetpackcomposecomponentscatalog.R

@Composable
fun MyConfirmmationDialog(show: Boolean, onDismiss: () -> Unit):String{
    var lista= listOf<String>("None","Calisto","Ganymede","Luna","Oberon","Phobos","Dione")
    var ringTone by rememberSaveable {
        mutableStateOf("")
    }
    var ringTone2 by rememberSaveable {
        mutableStateOf("")
    }
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(Color.White)

            ){
                MyTitleDialog("Phone ringtones", modifier=Modifier.padding(24.dp))
                Divider(modifier = Modifier.fillMaxWidth(), color=Color.LightGray)
                ringTone=MyRadioButton2(lista)
                Divider(modifier = Modifier.fillMaxWidth(), color=Color.LightGray)
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                    TextButton(onClick = {onDismiss()}) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = { ringTone2=ringTone
                                           onDismiss()}) {
                        Text(text = "OK")
                    }
                }






            }

        }
    }
    return ringTone2

}

@Composable
fun MyRadioButton2(lista: List<String>,modifier: Modifier=Modifier.padding(6.dp)): String {
    var ringTone by rememberSaveable {
        mutableStateOf("None")
    }
    lista.forEach { item-> 
        Row(modifier=modifier,verticalAlignment = Alignment.CenterVertically){
            RadioButton(selected = ringTone==item, onClick = { ringTone=item })
            Text(text = item)
        }

    }

    return ringTone

}


@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit): String {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var email2 by rememberSaveable {
        mutableStateOf("")
    }
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },

            ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {


                MyTitleDialog(text = "Set backup account")

                email = AccountItem(email = "ejemplo1@gmail.com", drawable = R.drawable.fotocarnet1)
                if (email != "") {
                    onDismiss()
                    email2 = email
                }


                email = AccountItem(email = "ejemplo2@gmail.com", drawable = R.drawable.fotocarnet2)
                if (email != "") {
                    onDismiss()
                    email2 = email
                }
                email = AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)
                if (email != "") {
                    onDismiss()
                    email2 = email
                }


            }
        }

    }



    return email2
}

@Composable
fun AccountItem(
    email: String,
    @DrawableRes drawable: Int
): String {   //@DrawableRes le indica que va a recibir una direccion de memoria
    var retorno by rememberSaveable { mutableStateOf("") }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )

        Text(text = email, modifier = Modifier
            .padding(8.dp)
            .clickable { retorno = email }, fontSize = 14.sp, color = Color.Gray
        )
    }
    println(retorno)
    return retorno
}

@Composable
fun MyTitleDialog(text: String,modifier: Modifier=Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            ) //cuando pulsamos atras y fuera del dialogo respectivamente

        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {

                Text(text = "Esto es un ejemplo")
            }
        }

    }


}

@Composable
fun MyAlertDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() },   //cuando el usuario clicka fuera del cuadro del AlertDialog
            title = { Text(text = "Titulo") },
            text = { Text(text = "Hola soy una descripcion super guay :(") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton")
                }
            }
        )
    }

}