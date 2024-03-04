package com.iro.mygoapp.ui.screens.splash

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.iro.mygoapp.ui.theme.*
import com.iro.mygoapp.utils.extensions.boldTextStyle
import com.iro.mygoapp.utils.extensions.height
import com.iro.mygoapp.utils.extensions.radius
import com.iro.mygoapp.utils.extensions.secondaryTextStyle
import com.iro.mygoapp.utils.getWalkData
import com.usecases.gozem_app.navigation.NavigationRoutes


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WalkThroughScreen(navController: NavHostController) {
    val pagerState = rememberPagerState { getWalkData.size }
    Scaffold(
        content = {
            Box(
                modifier = androidx.compose.ui.Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                GradientColor1,
                                GradientColor3,
                                GradientColor4,
                                GradientColor5
                            )
                        )
                    )
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxSize()
                ) { page ->
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = getWalkData[page].image),
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .size(200.dp),
                            contentDescription = ""
                        )
                        20.height()
                        Text(
                            text = getWalkData[page].title,
                            style = boldTextStyle(fontSize = 26.sp, color = MaterialTheme.colorScheme.onSurface)
                        )
                        Text(
                            text = getWalkData[page].description,
                            style = secondaryTextStyle(textAlign = TextAlign.Center, fontSize = 16.sp, color = MaterialTheme.colorScheme.onSurface),
                            lineHeight = 22.sp,
                            modifier = Modifier.padding(
                                start = 24.dp,
                                bottom = 16.dp,
                                end = 24.dp,
                                top = 16.dp
                            )
                        )
                        8.height()
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(bottom = 35.dp, start = 16.dp, end = 16.dp),
                    content = {
                        Row(content = {
                            getWalkData.forEachIndexed { index, _ ->
                                EduDots(
                                    selected = index == pagerState.currentPage,
                                    MaterialTheme.colorScheme.primary
                                )
                            }
                        })
                        16.height()
                        if (pagerState.currentPage != getWalkData.size)
                            Button(
                                onClick = {
                                    navController.navigate(NavigationRoutes.SignInScreen.routes)
                                },
                                shape = 40.radius(),
                                content = {
                                    Text(
                                        "Get Started",
                                        style = boldTextStyle(color = Color.White),
                                        modifier = Modifier.padding(4.dp)
                                    )
                                }
                            )
                    },
                )
            }
        },
    )
}

@Composable
fun EduDots(selected: Boolean, color: Color) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clip(CircleShape)
            .background(if (selected) color else Color.Gray)
            .height(10.dp)
            .width(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    MyGoAppTheme {
        WalkThroughScreen(
            navController
        )
    }
}
