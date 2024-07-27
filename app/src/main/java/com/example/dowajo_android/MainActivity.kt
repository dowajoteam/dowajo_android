package com.example.dowajo_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dowajo_android.ui.theme.Dowajo_androidTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dowajo_androidTheme {
                // 예시로 nickname을 "홍길동"으로 설정
                RecommenderSystemScreen(nickname = "홍길동")
            }
        }
    }
}

@Composable
fun RecommenderSystemScreen(nickname: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()                                      // Column이 부모의 전체 크기를 채우도록 설정
            .background(Color.Black),                           // 배경색을 검은색으로 설정
        verticalArrangement = Arrangement.Center,               // Column 내에서 항목들을 수직 방향으로 중앙에 정렬
        horizontalAlignment = Alignment.CenterHorizontally      // Column 내에서 항목들을 수평 방향으로 중앙에 정렬
    ) {
        // 버튼
        Button(
            onClick = { /* 버튼 클릭 시 동작 코드를 작성하는 부분 */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent              // 버튼 배경을 투명하게 설정
            ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.recommender_system_ui),
                contentDescription = "Recommender System UI",   // contentDescription 작성
                modifier = Modifier.size(200.dp)                // 이미지 크기 설정
            )
        }
        // 텍스트
        Box(
            modifier = Modifier
                .fillMaxWidth()                 // Box가 부모의 가로 전체를 차지하도록 설정
        ) {
            Text(
                text = "안녕하세요 $nickname"+"님\n맛집 추천 AI 입니다.\n$nickname"+"님이 원하시는\n맛집 조건을 말씀해주세요.",
                color = Color.White,                                                        // 텍스트 색상
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,      // 텍스트 스타일
                textAlign = TextAlign.Center,                                               // 텍스트를 가로 방향으로 중앙 정렬
                modifier = Modifier.align(Alignment.Center)                                 // Box 내에서 텍스트를 중앙에 정렬
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecommenderSystemPreview() {
    Dowajo_androidTheme {
        RecommenderSystemScreen(nickname = "홍길동") // 미리보기용으로 nickname 설정
    }
}
