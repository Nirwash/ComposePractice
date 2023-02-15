package com.nirwashh.android.composepractice.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nirwashh.android.composepractice.R


@Composable
fun ExpandableCard(
    title: String,
    body: String,
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(4.dp), modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(horizontalAlignment = CenterHorizontally) {
            Text(text = title, fontSize = 14.sp)
            if (expanded) {
                Text(text = body, fontSize = 12.sp)
                IconButton(onClick = { expanded = false }) {
                    Icon(
                        painter = painterResource(id = R.drawable.expand_less),
                        contentDescription = "Collapse"
                    )
                }
            } else {
                IconButton(onClick = { expanded = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.expand_more),
                        contentDescription = "Collapse"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableCardPreview() {
    val title = stringResource(id = R.string.title)
    val body = stringResource(id = R.string.body)
    Surface(
        modifier = Modifier
            .width(200.dp)
            .height(300.dp),
        color = Color.White
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            ExpandableCard(title = title, body = body)
        }

    }
}