package com.example.graduationproject.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.graduationproject.R
import com.example.graduationproject.data.presestance.SharedObject
import com.example.graduationproject.presentation.components.DropDownShow
import com.example.graduationproject.presentation.components.Loading
import com.example.graduationproject.presentation.components.TextShow
import com.example.graduationproject.presentation.list
import com.example.graduationproject.presentation.ui.theme.CustomColor


@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun ConvertScreen(
    openAddToFav: () -> Unit
) {
    var amountValue by remember {
        mutableStateOf("1")
    }
    var loading by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("1")
    }
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {

                TextShow(
                    text = "Amount",
                    color = CustomColor.black,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 14
                )
                Spacer(modifier = Modifier.width(130.dp))
                TextShow(
                    text = "From",
                    color = CustomColor.black,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 14
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFF9F9F9),
                            shape = RoundedCornerShape(size = 20.dp)
                        )
                        .fillMaxWidth(.4f),
                    value = amountValue, onValueChange = {
                        amountValue = it
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(Color(0xFF000000)),

                    shape = RoundedCornerShape(20.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )
                Spacer(modifier = Modifier.width(8.dp))
                DropDownShow(
                    list = list, modifier = Modifier
                        .background(
                            color = Color(0xFFF9F9F9),
                            shape = RoundedCornerShape(size = 20.dp)
                        )
                        .fillMaxWidth()
                )
            }
            Icon(
                painter = painterResource(R.drawable.baseline_sync_24),
                contentDescription = "Swap Currency",
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 12.dp)
                    .size(25.dp)
                    .align(Alignment.CenterHorizontally),
                tint = MaterialTheme.colorScheme.onSurface
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                TextShow(
                    text = "To",
                    color = CustomColor.black,
                    fontFamily = FontFamily.Default,
                    fontSize = 14
                )
                Spacer(modifier = Modifier.width(175.dp))
                TextShow(
                    text = "Amount",
                    color = CustomColor.black,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 14
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                DropDownShow(
                    list = list, modifier = Modifier
                        .background(
                            color = Color(0xFFF9F9F9),
                            shape = RoundedCornerShape(size = 20.dp)
                        )
                        .fillMaxWidth(.5f)

                )
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = Color(0xFFF9F9F9),
                            shape = RoundedCornerShape(size = 20.dp)
                        ),
                    value = result, onValueChange = {},
                    colors = TextFieldDefaults.outlinedTextFieldColors(Color(0xFF000000)),

                    enabled = false,
                    shape = RoundedCornerShape(20.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )

            }
            Loading(isDisplayed = true)
            Button(
                onClick = {
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF363636)),
                shape = RoundedCornerShape(size = 20.dp)
            ) {
                Text(
                    text = "Convert",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(800),
                        color = Color.White
                    )
                )
            }
            Row(
                horizontalArrangement = Arrangement.Start,
            ) {
                TextShow(
                    modifier=Modifier.align(alignment = Alignment.CenterVertically),
                    text = "live exchange rates",
                    color = Color.Black,
                    fontFamily = FontFamily.Default,
                    fontSize = 18,
                    weight = 700
                )
                Spacer(modifier = Modifier.weight(1f))
                OutlinedButton(
                    onClick = {
                        openAddToFav.invoke()
                    },
                    colors = ButtonDefaults.outlinedButtonColors(Color.White),
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(50)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_add_circle_outline_24),
                        contentDescription = "Add to favourite",contentScale = ContentScale.None
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    TextShow(
                        text = "Add to Favorites",
                        color = Color(0xFF363636),
                        fontFamily = FontFamily.Default,
                        fontSize = 12
                    )
                }
            }
            Card(
                shape = CardDefaults.outlinedShape,
                colors = CardDefaults.cardColors(CustomColor.lightGray),
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.Start)
            ) {
                TextShow(
                    text = "My Portofolio",
                    color = Color(0xFF121212),
                    fontFamily = FontFamily.Default,
                    fontSize = 20,
                    weight = 400,
                    modifier = Modifier.padding(10.dp)
                )

                LazyColumn(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    items(6) {
                        Row(
                            Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                        ) {

                            GlideImage(
                                model = SharedObject.url,
                                contentDescription = "image of currency",
                                modifier = Modifier.size(42.dp)
                            ) {
                                it.load(
                                    SharedObject.url
                                )
                                it.placeholder(R.drawable.baseline_flag_24)
                                it.error(R.drawable.baseline_dehaze_24)
                                it.circleCrop()
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                TextShow(
                                    text = "USA",
                                    color = CustomColor.black,
                                    fontFamily = FontFamily.Default,
                                    fontSize = 15
                                )
                                TextShow(
                                    text = "CURRENCY",
                                    color = Color(0xFFB8B8B8),
                                    fontFamily = FontFamily.Default,
                                    fontSize = 13
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            TextShow(
                                text = "",
                                color = Color(0xFF121212),
                                fontFamily = FontFamily.Default
                            )
                        }
                    }
                }
            }
        }
    }

}