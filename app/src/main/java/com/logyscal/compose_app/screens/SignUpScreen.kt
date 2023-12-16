package com.logyscal.compose_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.logyscal.compose_app.R
import com.logyscal.compose_app.components.EmailTextFieldComponent
import com.logyscal.compose_app.components.HeadingTextComponent
import com.logyscal.compose_app.components.NormalTextComponent
import com.logyscal.compose_app.components.PasswordTextFieldComponent

@Composable
fun SignUpScreen(){

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)

        )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.signup))
            Spacer(modifier = Modifier.height(20.dp))
            EmailTextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource(id = R.drawable.round_email_24)
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.create_pswd),
                painterResource = painterResource(id = R.drawable.round_lock_24)
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.confirm_pswd),
                painterResource = painterResource(id = R.drawable.round_lock_24)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}