package com.example.composeui.main_feed_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeui.R
import com.example.composeui.model.User

@Composable

fun PostWidget(
  user: User
){
   Column(
       modifier = Modifier.fillMaxWidth()
   ) {
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(10.dp),
           horizontalArrangement = Arrangement.SpaceBetween

       ) {
           Row(
               verticalAlignment = Alignment.CenterVertically
           ) {
               Image(
                   painter = user.profilePic,
                   contentDescription ="Profile Pic",
                   modifier = Modifier
                       .size(40.dp)
                       .clip(CircleShape)
               )
               Spacer(modifier = Modifier.width(10.dp))
               Column {
                   Text(
                       text = user.userName,
                       fontWeight = FontWeight.Bold,
                       fontSize = 18.sp
                   )
                   Text(
                       text = user.location,
                       fontSize = 14.sp
                   )
               }

           }
           IconButton(onClick = { /*TODO*/ }) {
               Icon(
                   painter = painterResource(R.drawable.ic_more),
                   contentDescription = "More Option"
               )
               
           }
       }
       Image(

           painter = user.postPic,
           contentDescription = "Post Pic",
           modifier = Modifier.fillMaxWidth(),
           contentScale = ContentScale.FillWidth
       )
       Row(
          modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween
       ) {
          Row {
              IconButton(onClick = { /*TODO*/ }) {
                  Icon(
                      painter = painterResource(R.drawable.ic_like_outline) ,
                      contentDescription ="Like Post",
                      tint = Color.Black,
                      modifier = Modifier.size(25.dp)
                  )

              }
              IconButton(onClick = { /*TODO*/ }) {
                  Icon(
                      painter = painterResource(R.drawable.ic_comment) ,
                      contentDescription ="Comment Post",
                      tint = Color.Black,
                      modifier = Modifier.size(25.dp)
                  )

              }
              IconButton(onClick = { /*TODO*/ }) {
                  Icon(
                      painter = painterResource(R.drawable.ic_send) ,
                      contentDescription ="Share Post",
                      tint = Color.Black,
                      modifier = Modifier.size(25.dp)
                  )
              }
          }
           IconButton(onClick = { /*TODO*/ }) {
               Icon(
                   painter = painterResource(R.drawable.ic_save) ,
                   contentDescription ="Save Post",
                   tint = Color.Black,
                   modifier = Modifier.size(25.dp)
               )

           }
       }
       Column(
           modifier = Modifier.padding(horizontal = 10.dp)
       ) {
           Text(text = "${user.likeCount} likes")
           Text(
               text = buildAnnotatedString {
                   append(
                       AnnotatedString(
                           text = "${user.userName}",
                           spanStyle = SpanStyle(fontWeight = FontWeight.Bold)
                       )
                   )
                   append(user.caption)
               }
           )
           Spacer(modifier = Modifier.height(5.dp))
           Text(
               text = "View all ${user.commentCount} comments",
               color = Color.DarkGray,
               fontSize = 13.sp
           )



       }
   }
}


@Preview(showBackground = true)

@Composable
fun PostWidgetPreview(){
    PostWidget(
        User(
            profilePic = painterResource(R.drawable.arya_stark),
            userName = "jon_snow",
            postPic = painterResource(R.drawable.jon_snow_post),
            location = "Coimbatore,Tamilnadu",
            likeCount = 150,
            caption = "Hey check out this post!!!",
            commentCount = 15
        ),
    )
}