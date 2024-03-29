package com.iro.mygoapp.ui.screens.unauthenticated.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.iro.mygoapp.R
import com.iro.mygoapp.ui.screens.unauthenticated.components.topAppBar
import com.iro.mygoapp.ui.theme.MyGoAppTheme
import com.iro.mygoapp.utils.extensions.boldTextStyle
import com.iro.mygoapp.utils.extensions.height
import com.iro.mygoapp.utils.extensions.primaryTextStyle
import com.iro.mygoapp.utils.extensions.radius
import com.iro.mygoapp.utils.extensions.secondaryTextStyle
import com.usecases.gozem_app.navigation.NavigationRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen( navController: NavHostController) {
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }

    val emailErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }

    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            topAppBar(navController)
        },

        content = {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .padding(it),
                content = {
                    item {
                        Text(
                            stringResource(R.string.signin_title),
                            style = boldTextStyle(fontSize = 24.sp, color = Color.Black)
                        )
                        10.height()
                        Text(
                            stringResource(R.string.sign_up_to_your_account),
                            style = secondaryTextStyle(fontSize = 16.sp)
                        )
                        24.height()
                        OutlinedTextField(
                            value = email,
                            modifier = Modifier
                                .fillMaxWidth(),
                            label = { Text(text = stringResource(R.string.full_name)) },
                            textStyle = primaryTextStyle(),
                            placeholder = {
                                Text(
                                    text = stringResource(R.string.sign_up_to_your_account),
                                    style = secondaryTextStyle()
                                )
                            },
                            isError = emailErrorState.value,
                            onValueChange = {
                                if (emailErrorState.value) {
                                    emailErrorState.value = false
                                }
                                email = it
                            }
                        )
                        if (emailErrorState.value) {
                            Text(
                                text = stringResource(R.string.required_field),
                                style = primaryTextStyle(color = Color.Red)
                            )
                        }
                        8.height()
                        OutlinedTextField(
                            value = email,
                            modifier = Modifier
                                .fillMaxWidth(),
                            label = { Text(text = stringResource(R.string.email_address)) },
                            textStyle = primaryTextStyle(),
                            placeholder = {
                                Text(
                                    text = stringResource(R.string.email_address),
                                    style = secondaryTextStyle()
                                )
                            },
                            isError = emailErrorState.value,
                            onValueChange = {
                                if (emailErrorState.value) {
                                    emailErrorState.value = false
                                }
                                email = it
                            }
                        )
                        if (emailErrorState.value) {
                            Text(
                                text = stringResource(R.string.required_field),
                                style = primaryTextStyle(color = Color.Red)
                            )
                        }
                        8.height()
                        OutlinedTextField(
                            value = password,
                            modifier = Modifier
                                .fillMaxWidth(),
                            label = { Text(text = "Password") },
                            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                            textStyle = primaryTextStyle(),
                            trailingIcon = {
                                IconButton(
                                    onClick = {passwordVisibility = !passwordVisibility },
                                    content = {
                                        Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                                    }
                                )
                            },
                            placeholder = { Text(text = stringResource(R.string.password), style = secondaryTextStyle()) },
                            isError = passwordErrorState.value,
                            onValueChange = {
                                if (passwordErrorState.value) {
                                    passwordErrorState.value = false
                                }
                                password = it
                            }
                        )

                        if (passwordErrorState.value) {
                            Text(
                                text = stringResource(R.string.required_field),
                                style = primaryTextStyle(color = Color.Red)
                            )
                        }
                        26.height()
                        Button(
                            onClick = {
                                when {
                                    email.text.isEmpty() -> {
                                        emailErrorState.value = true
                                    }
                                    password.text.isEmpty() -> {
                                        passwordErrorState.value = true
                                    }
                                    else->{
                                        passwordErrorState.value = false
                                        emailErrorState.value = false
                                    }
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = 40.radius(),
                            content = {
                                Text(
                                    "Sign Up",
                                    style = boldTextStyle(
                                        color = Color.White,
                                    ),
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        )
                        26.height()
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                            content = {
                                Text(
                                    stringResource(R.string.no_account),
                                    style = secondaryTextStyle(fontSize = 16.sp)
                                )
                                TextButton(
                                    onClick = {
                                        navController.navigate(NavigationRoutes.SignInScreen.routes)
                                    },
                                ) {
                                    Text(
                                        text =stringResource(R.string.sign_up),
                                        style = primaryTextStyle(color = Color.Black)
                                    )
                                }
                            },
                        )
                    }
                },
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    val navController = rememberNavController()
    MyGoAppTheme {
        SignUpScreen(
            navController
        )
    }
}
