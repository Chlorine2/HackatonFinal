package com.example.hackatonfinal.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hackatonfinal.ui.theme.blue
import com.example.hackatonfinal.viewModel.SharedViewModel

@Composable
fun RegistrationPage(onClickSignUp: () -> Unit = {}, onClickReset : () -> Unit = {}, viewModel: SharedViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color.Transparent,
            )
    ) {


        Box(
            modifier = Modifier
                /*.background(
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(25.dp, 5.dp, 25.dp, 5.dp)
                )*/
                .align(Alignment.BottomCenter),
        ) {


            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                ,

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Create An Account",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 130.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.headlineLarge,
                    color = blue,
                )
                Spacer(modifier = Modifier.height(8.dp))
                RegisterName(viewModel)

                Spacer(modifier = Modifier.height(8.dp))
                RegisterLastName(viewModel)

                Spacer(modifier = Modifier.padding(3.dp))
                RegisterEmail(viewModel)

                Spacer(modifier = Modifier.padding(3.dp))
                RegisterPassword(viewModel)

                Spacer(modifier = Modifier.padding(3.dp))
                RegisterPasswordConfirm()




                Spacer(modifier = Modifier.padding(10.dp))
                /* Button(
                     onClick = {},
                     modifier = Modifier
                         .fillMaxWidth(0.8f)
                         .height(50.dp)
                 ) {
                     Text(text = "Login", fontSize = 20.sp)
                 }*/
                Button(
                    onClick = {} // Set your desired background color here
                ){
                    Text(text = "Registration")
                }

                Spacer(modifier = Modifier.padding(10.dp))
                TextButton(onClick =
                {
                    if(viewModel.SignUp()) {
                        onClickSignUp()

                    }
                }) {
                    Text(
                        text = "Sign In",
                        letterSpacing = 1.sp,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }


                Spacer(modifier = Modifier.padding(5.dp))
                TextButton(onClick = {
                    onClickReset()
                }) {
                    Text(
                        text = "Reset Password",
                        letterSpacing = 1.sp,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))

            }


        }

    }


}


//...........................................................................



//name
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterName(viewModel : SharedViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = viewModel.firstname.collectAsState().value,
        onValueChange = {it -> viewModel.updateFirstName(it) },
        shape = RoundedCornerShape(100),
        label = {
            Text("Name",
                color = blue,
                style = MaterialTheme.typography.bodyLarge,
            ) },
        placeholder = { Text(text = "Name") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = blue,
            unfocusedBorderColor = blue),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.8f),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        )

    )
}


//phone
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterLastName(viewModel: SharedViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = viewModel.firstname.collectAsState().value,
        onValueChange = { viewModel.updateLastName(it) },
        shape = RoundedCornerShape(100),
        label = {
            Text("Name",
                color = blue,
                style = MaterialTheme.typography.bodyLarge,
            ) },
        placeholder = { Text(text = "Name") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = blue,
            unfocusedBorderColor = blue),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.8f),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        )

    )
}


//email id
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterEmail(viewModel: SharedViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = viewModel.mail.collectAsState().value,
        onValueChange = { viewModel.updateEmail(it)},
        shape = RoundedCornerShape(100),
        label = {
            Text("Email Address",
                color = blue,
                style = MaterialTheme.typography.bodyLarge,
            ) },
        placeholder = { Text(text = "Email Address") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = blue,
            unfocusedBorderColor = blue),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.8f),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        )

    )
}

//password
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterPassword(viewModel: SharedViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }


    OutlinedTextField(
        value = viewModel.password.collectAsState().value,
        onValueChange = { viewModel.updatePassword(it) },
        shape = RoundedCornerShape(100),
        label = {
            Text("Enter Password",
                color = blue,
                style = MaterialTheme.typography.bodyLarge,
            ) },
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = blue,
            unfocusedBorderColor = blue),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                // Please provide localized description for accessibility services
                val description = if (passwordHidden) "Show password" else "Hide password"
                Icon(imageVector = Icons.Filled.Lock, contentDescription = description)
            }
        },
        modifier = Modifier.fillMaxWidth(0.8f),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        )
    )
}

//password confirm
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterPasswordConfirm() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        shape = RoundedCornerShape(100),
        label = {
            Text("Confirm Password",
                color = blue,
                style = MaterialTheme.typography.bodyLarge,
            ) },
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = blue,
            unfocusedBorderColor = blue),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {

                // Please provide localized description for accessibility services
                val description = if (passwordHidden) "Show password" else "Hide password"
                Icon(imageVector = Icons.Filled.Lock, contentDescription = description)
            }
        },
        modifier = Modifier.fillMaxWidth(0.8f),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        )
    )
}