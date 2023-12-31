package com.example.graduationproject.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomCheckBox() {
    var isCheck by remember{
        mutableStateOf(false)
    }

      Card(
          colors = CardDefaults.cardColors(Color.Black),
       elevation = CardDefaults.cardElevation(0.dp),
          shape = RoundedCornerShape((12.dp)),

      ) {


        Box(modifier= Modifier
            .background(
                if (isCheck) Color.Black else Color.White
            ).clickable {
                isCheck=!isCheck
            }
            .size(25.dp),
            contentAlignment = Alignment.Center
        ){
            if(isCheck)
Icon(Icons.Default.Check, contentDescription = "", tint = Color.White)

      }

    }
}