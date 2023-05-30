package com.example.kalorize_project.ui

import androidx.navigation.NavHostController

import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kalorize_project.R
import com.example.kalorize_project.SplashPreview
import com.example.kalorize_project.navigation.Screen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.example.kalorize_project.ui.theme.*
import com.google.accompanist.pager.rememberPagerState
import com.uistack.onboarding.OnBoardingData
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnboardingScreen(navController: NavHostController) {
    val items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            R.drawable.onboarding1,
            "Manage your Diet",
            "The best solution to control your diet",
            backgroundColor = Color(0xFF0189C5),
            mainColor = Color(0xFFF94917)
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.onboarding2,
            "Schedule your Time",
            "The best solution to control your diet",
            backgroundColor = Color(0xFFE4AF19),
            mainColor = Color(0xFFF94917)
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.onboarding3,
            "Choose your Food",
            "The best solution to control your food",
            backgroundColor = Color(0xFF96E172),
            mainColor = Color(0xFFF94917)
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0,
    )

    OnBoardingPager(
        navController = navController,
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    navController: NavHostController,
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Align content vertically in the center
        ) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(item[page].backgroundColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center // Align content vertically in the center
                ) {
                    Image(
                        painter = painterResource(id = item[page].image),
                        contentDescription = item[page].title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1920.dp)
                            .clip(RectangleShape),
                        contentScale = ContentScale.Crop
                    )
                }

            }
        }

        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                backgroundColor = Color.White,
                elevation = 0.dp,
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
            ) {
                Box() {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally // Align content horizontally in the center
                    ) {
                        PagerIndicator(items = item, currentPage = pagerState.currentPage)
                        Text(
                            text = item[pagerState.currentPage].title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            color = item[pagerState.currentPage].mainColor,
                            fontFamily = RobotoBold,
                            textAlign = TextAlign.Center, // Align text in the center
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = item[pagerState.currentPage].desc,
                            modifier = Modifier.padding(top = 8.dp),
                            color = Color.Black,
                            fontFamily = RobotoRegular,
                            fontSize = 17.sp,
                            textAlign = TextAlign.Center, // Align text in the center
                            fontWeight = FontWeight.ExtraLight
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            if (pagerState.currentPage != 2) {
                                TextButton(onClick = {
                                    //skip
                                }) {
                                    Text(
                                        text = "Skip Now",
                                        color = Color(0xFF292D32),
                                        fontFamily = RobotoBold,
                                        textAlign = TextAlign.Right,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }

                                NextPageButton(
                                    pagerState = pagerState,
                                    item = item[pagerState.currentPage]
                                )
                            } else {
                                Button(
                                    onClick = {
                                        navController.navigate(Screen.Login.route)
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = item[pagerState.currentPage].mainColor
                                    ),
                                    contentPadding = PaddingValues(vertical = 12.dp),
                                    elevation = ButtonDefaults.elevation(
                                        defaultElevation = 0.dp
                                    )
                                ) {
                                    Text(
                                        text = "Get Started",
                                        color = Color.White,
                                        fontSize = 16.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun PagerIndicator(currentPage: Int, items: List<OnBoardingData>) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        repeat(items.size) {
            Indicator(isSelected = it == currentPage, color = items[it].mainColor)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean, color: Color) {
    val width = animateDpAsState(targetValue = if (isSelected) 40.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) color else Color.Gray.copy(alpha = 0.5f)
            )
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NextPageButton(
    pagerState: PagerState,
    item: OnBoardingData
) {
    val coroutineScope = rememberCoroutineScope()

    OutlinedButton(
        onClick = {
            coroutineScope.launch {
                pagerState.scrollToPage(
                    pagerState.currentPage + 1,
                    pageOffset = 0f
                )
            }
        },
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 8.dp),
        shape = RoundedCornerShape(50),
        border = BorderStroke(1.dp, item.mainColor),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = item.mainColor
        )
    ) {
        Text(
            text = "Next",
            color = item.mainColor,
            fontSize = 14.sp,
            fontFamily = RobotoBold
        )
    }
}