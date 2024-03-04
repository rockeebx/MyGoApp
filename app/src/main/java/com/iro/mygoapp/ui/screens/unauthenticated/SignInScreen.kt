package com.iro.mygoapp.ui.screens.unauthenticated

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.iro.mygoapp.ui.theme.MyGoAppTheme
import com.iro.mygoapp.utils.extensions.boldTextStyle
import com.iro.mygoapp.utils.extensions.height
import com.iro.mygoapp.utils.extensions.primaryTextStyle
import com.iro.mygoapp.utils.extensions.radius
import com.iro.mygoapp.utils.extensions.secondaryTextStyle
import com.usecases.gozem_app.navigation.NavigationRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen( navController: NavHostController) {
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }

    val emailErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }

    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() })
                    {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.padding(horizontal = 8.dp),
                            tint = Color.Black
                        )
                    }
                },
            )
        },

        content = {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .padding(it),
                content = {
                    item {
                        Text(
                            "Easy to learn,\ndiscover more\nskills",
                            style = boldTextStyle(fontSize = 24.sp, color = Color.Black)
                        )
                        10.height()
                        Text(
                            "Sign in to your account",
                            style = secondaryTextStyle(fontSize = 16.sp)
                        )
                        24.height()
                        OutlinedTextField(
                            value = email,
                            modifier = Modifier
                                .fillMaxWidth(),
                            label = { Text(text = "Email address") },
                            textStyle = primaryTextStyle(),
                            //shape = 40.radius(),
                            placeholder = {
                                Text(
                                    text = "Email address",
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
                                text = "Required Field",
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
                            //shape = 40.radius(),
                            trailingIcon = {
                                IconButton(
                                    onClick = {passwordVisibility = !passwordVisibility },
                                    content = {
                                        Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                                    }
                                )
                            },
                            placeholder = { Text(text = "Password", style = secondaryTextStyle()) },
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
                                text = "Required Field",
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
                                        navController.navigate(NavigationRoutes.HomeScreen.routes)
                                    }
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = 40.radius(),
                            content = {
                                Text(
                                    "Sign In",
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
                                    "Already have an account?",
                                    style = secondaryTextStyle(fontSize = 16.sp)
                                )
                                TextButton(
                                    onClick = {
                                        navController.navigate(NavigationRoutes.SignUpScreen.routes)
                                    },
                                ) {
                                    Text(
                                        text = "Sign Up",
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
fun PreviewSignInScreen() {
    val navController = rememberNavController()
    MyGoAppTheme {
        SignInScreen(
            navController
        )
    }
}
