package com.iro.mygoapp.ui.screens.home.profil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iro.mygoapp.data.model.SectionModel
import com.iro.mygoapp.utils.extensions.LoadNetworkImage
import com.iro.mygoapp.utils.extensions.boldTextStyle
import com.iro.mygoapp.utils.extensions.height
import com.iro.mygoapp.utils.extensions.secondaryTextStyle


@Composable
fun ProfilView(section: SectionModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(),
        content = {
            20.height()
            section.content.image?.let {
                LoadNetworkImage(
                    image = it,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(80.dp)
                )
            }
            10.height()
            Text("${section.content.name}", style = boldTextStyle(fontSize = 18.sp))
            4.height()
            Text(
                "${section.content.email}",
                textAlign = TextAlign.Center,
                style = secondaryTextStyle()
            )
            20.height()
        })
    }
}