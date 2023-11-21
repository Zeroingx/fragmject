package com.example.fragment.project.ui.my_demo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fragment.project.R
import com.example.fragment.project.components.WheelPicker
import kotlinx.coroutines.launch

@Composable
fun WheelPickerScreen() {
    val hour = remember { mutableStateOf("") }
    val minute = remember { mutableStateOf("") }
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    SnackbarHost(hostState = snackState, Modifier)
    Column {
        Box(modifier = Modifier.weight(1f))
        Row(
            Modifier
                .background(colorResource(R.color.white))
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .width(50.dp)
                    .height(25.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.gray),
                    contentColor = colorResource(R.color.text_666)
                ),
                elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp, 0.dp),
                border = BorderStroke(1.dp, colorResource(R.color.gray)),
                contentPadding = PaddingValues(5.dp, 3.dp, 5.dp, 3.dp)
            ) {
                Text(text = "取消", fontSize = 13.sp)
            }
            Spacer(Modifier.weight(1f))
            Button(
                onClick = {
                    snackScope.launch {
                        snackState.showSnackbar(
                            "Selected date timestamp: ${hour.value} / ${minute.value}"
                        )
                    }
                },
                modifier = Modifier
                    .width(50.dp)
                    .height(25.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.theme_orange),
                    contentColor = colorResource(R.color.text_fff)
                ),
                elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp, 0.dp),
                border = BorderStroke(1.dp, colorResource(R.color.gray)),
                contentPadding = PaddingValues(5.dp, 3.dp, 5.dp, 3.dp)
            ) {
                Text(text = "确定", fontSize = 13.sp)
            }
        }
        HorizontalDivider()
        Box(
            modifier = Modifier
                .background(colorResource(R.color.white))
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(175.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val pickerModifier = Modifier
                    .width(70.dp)
                    .height(175.dp)
                WheelPicker(
                    data = (0..23).map { it.toString().padStart(2, '0') },
                    selectIndex = 0,
                    visibleCount = 5,
                    modifier = pickerModifier,
                    onSelect = { _, item ->
                        hour.value = item
                    }
                ) {
                    Text(
                        text = it,
                        fontSize = 14.sp
                    )
                }
                Text(
                    text = "/",
                    fontSize = 15.sp
                )
                WheelPicker(
                    data = (0..59).map { it.toString().padStart(2, '0') },
                    selectIndex = 0,
                    visibleCount = 5,
                    modifier = pickerModifier,
                    onSelect = { _, item ->
                        minute.value = item
                    }
                ) {
                    Text(
                        text = it,
                        fontSize = 14.sp
                    )
                }
            }
            Column(Modifier.height(175.dp)) {
                val whiteMaskModifier = Modifier
                    .background(colorResource(R.color.bb_white))
                    .fillMaxWidth()
                    .weight(1f)
                Spacer(whiteMaskModifier)
                Spacer(
                    Modifier
                        .background(colorResource(R.color.one_b_black), RoundedCornerShape(5.dp))
                        .fillMaxWidth()
                        .height(30.dp)
                )
                Spacer(whiteMaskModifier)
            }
        }
    }
}