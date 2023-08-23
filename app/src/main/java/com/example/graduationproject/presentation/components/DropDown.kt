package com.example.graduationproject.presentation.components

import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownShow(list: List<Pair<String, Int>>, modifier: Modifier) {
    var text by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    Column {
        OutlinedTextField(
            value = text,
            onValueChange = {},
            enabled = false,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "drop down",
                    Modifier.clickable {
                        expanded = expanded.not()
                    }
                )
            },
            modifier = modifier,
            shape = RoundedCornerShape(20.dp)
        )
        DropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = false
        }) {
            list.forEach { item ->
                DropdownMenuItem(text = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = item.first)
                        Icon(painter = painterResource(id = item.second), contentDescription = "")
                    }
                }, onClick = {
                    text = item.first
                    expanded = false
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Perview() {

}