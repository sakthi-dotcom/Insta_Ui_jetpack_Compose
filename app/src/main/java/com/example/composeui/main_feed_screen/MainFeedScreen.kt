package com.example.composeui.main_feed_screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composeui.R
import com.example.composeui.model.User

@Composable
fun MainFeedScreen() {

    val users = listOf(
        User(
            profilePic = painterResource(R.drawable.jon_snow),
            userName = "jon_snow",
            postPic = painterResource(R.drawable.jon_snow_post),
            location = "Coimbatore,Tamilnadu",
            likeCount = 150,
            caption = "Hey check out this post!!!",
            commentCount = 15
        ),
        User(
            profilePic = painterResource(R.drawable.daenerys_targaryen),
            userName = "queen_daenerys",
            postPic = painterResource(R.drawable.daenerys_targaryen_post),
            location = "Captain America",
            likeCount = 1,
            caption = "Hey check out my post!!!",
            commentCount = 0
        ),
        User(
            profilePic = painterResource(R.drawable.arya_stark),
            userName = "arya",
            postPic = painterResource(R.drawable.arya_stark_post),
            location = "Chennai,Tamilnadu",
            likeCount = 100,
            caption = "New one",
            commentCount = 12
        ),
        User(
            profilePic = painterResource(R.drawable.jorah_mormont),
            userName = "jorah_m",
            postPic = painterResource(R.drawable.jorah_mormont_post),
            location = "Florida,USA",
            likeCount = 150,
            caption = "",
            commentCount = 15
        ),
        User(
            profilePic = painterResource(R.drawable.rob_stark),
            userName = "rob",
            postPic = painterResource(R.drawable.robb_stark_post),
            location = "Kerala",
            likeCount = 80,
            caption = "learn to live alone",
            commentCount = 15
        ),
        User(
            profilePic = painterResource(R.drawable.sansa_stark),
            userName = "sansa",
            postPic = painterResource(R.drawable.sansa_stark_post),
            location = "Tamilnadu",
            likeCount = 10,
            caption = "Hey check out this post!!!",
            commentCount = 0
        ),
    )
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar()
        },
        backgroundColor = Color.White,

        ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {

            item{
                LazyRow{
                    items(users){ item ->
                        StroyWidget(user = item)
                    }
                }
            }
            item{Divider()}
            items(users){   User ->
                PostWidget(user = User)
                Spacer(modifier = Modifier.height(15.dp))
            }

        }
    }
}