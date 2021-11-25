package org.md.squareofftask.ui.screen.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import org.md.squareofftask.domain.model.Trn

@Composable
fun TrnList(trns: List<Trn>) {
    val configuration = LocalConfiguration.current.orientation

    if (configuration == Configuration.ORIENTATION_LANDSCAPE) {
        // show grid
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(trns.windowed(2, 2, true)) { trnSubList ->
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    trnSubList.forEach {
                        TrnItemLandscape(it)
                    }
                }
            }
        }
    } else {
        // show normal list
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(trns) {
                TrnItemPortrait(trn = it)
            }
        }
    }


}

@Composable
private fun TrnItemPortrait(trn: Trn) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(text = trn.name)
            Text(text = trn.slug)
            Text(text = "Year: ${trn.year}")
            Text(text = "Dashes: ${trn.dashesCount}")
            if (trn.img != null) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = rememberImagePainter(data = trn.img), contentDescription = null, modifier = Modifier
                            .size(256.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                }
            }
        }
    }
}

@Composable
private fun TrnItemLandscape(trn: Trn) {
    BoxWithConstraints {
        Card(
            modifier = Modifier
                .requiredWidth(300.dp)
                .requiredHeight(120.dp)
                .padding(8.dp)
        ) {
            Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(text = trn.name)
                if (trn.img != null) {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Image(
                            painter = rememberImagePainter(data = trn.img), contentDescription = null, modifier = Modifier
                                .size(200.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                    }
                }
            }
        }
    }

}