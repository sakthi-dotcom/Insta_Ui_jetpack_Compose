package com.example.composeui.main_feed_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeui.R
import com.example.composeui.model.User

@Composable

fun StroyWidget(
    user: User
){
  Box (
      modifier = Modifier.padding(10.dp),
      contentAlignment = Alignment.TopCenter
          ){
           Canvas(modifier = Modifier.size(80.dp)){
               val instaColors = listOf(Color.Yellow,Color.Red,Color.Magenta)
               drawCircle(
                   brush = Brush.linearGradient(colors = instaColors),
                   style = Stroke(width = 15f)
               )
           }
      Column(
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
           Image(
               painter = user.profilePic,
               contentDescription ="ProfilePic",
               modifier = Modifier
                   .size(80.dp)
                   .clip(CircleShape)
                   .border(
                       width = 3.dp,
                       color = Color.White,
                       shape = CircleShape
                   )
           )
          Spacer(modifier = Modifier.height(10.dp))

          Text(
              text = user.userName,
              color = Color.DarkGray,
              fontFamily = FontFamily(Font(R.font.robotocondensed))
          )
      }
  }
}

@Preview(showBackground = true)

@Composable
fun StoryWidgetPreview(){
    StroyWidget(
        User(
            profilePic = painterResource(R.drawable.daenerys_targaryen),
            userName = "queen_daenerys",
            postPic = painterResource(R.drawable.daenerys_targaryen_post),
            location = "Captain America",
            likeCount = 1,
            caption = "Hey check out my post!!!",
            commentCount = 0
        ),
    )
}