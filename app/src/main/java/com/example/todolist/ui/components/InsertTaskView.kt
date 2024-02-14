package com.example.todolist.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.R


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InsertTaskView() {

    var text by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        TextField(
            value = text,
            onValueChange =  { newText ->
                text = newText
            },
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .background(Color.Transparent),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            ),

            label = { Text("Add a task...", color = Color.Black)}
        )

        Spacer(modifier = Modifier.width(16.dp))

        IconButton(
            onClick = { /*TODO*/ },

            ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Preview
@Composable
fun InsertTaskPreview() {
    InsertTaskView()
}