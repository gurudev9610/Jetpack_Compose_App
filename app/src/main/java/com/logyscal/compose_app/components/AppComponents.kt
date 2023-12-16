package com.logyscal.compose_app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.logyscal.compose_app.ui.theme.TextColor
import com.logyscal.compose_app.ui.theme.Primary
import com.logyscal.compose_app.ui.theme.componentShapes
import com.logyscal.compose_app.R

//import androidx.compose.ui.res.colorResource
@Composable
fun NormalTextComponent(value : String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
//        color = colorResource(id = R.color.colorText)
    )
}

@Composable
fun HeadingTextComponent(value : String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
//        color = colorResource(id = R.color.colorText)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextFieldComponent(labelValue: String, painterResource: Painter) {

    val textValue = remember {
        mutableStateOf(value = "")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary
//          focusedBorderColor = colorResource(id = R.color.colorPrimary)
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        }
    )
}

@SuppressLint("ResourceType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(labelValue: String, painterResource: Painter) {

    val password = remember {
        mutableStateOf(value = "")
    }
    val passwordVisible = remember {
        mutableStateOf(value = false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary
//          focusedBorderColor = colorResource(id = R.color.colorPrimary)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if(passwordVisible.value){
                Icons.Filled.Visibility
            }
            else{
                Icons.Filled.VisibilityOff
            }

            var description = if (passwordVisible.value){
                stringResource(id = R.string.hide_pswd)
            }
            else{
                stringResource(id = R.string.show_pswd)
            }
            
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) {
            VisualTransformation.None
        }
        else{
            PasswordVisualTransformation()
        }
    )
}