package com.vivek.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vivek.jetpackcompose.list.ListOfQuotes
import com.vivek.jetpackcompose.models.Quote

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            displayQuotes {  }

        }
    }

    @Composable
    fun scrollableColumn() {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            for (i in 1..100) {
                Text(
                    text = "Item $i",
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.labelSmall
                )
                Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
            }
        }
    }

    @Composable
    fun lazyColumDemo2(selectableItem : (String) -> Unit) {
        LazyColumn {
            items(100) {
                Text(
                    text = "Item $it",
                    modifier = Modifier.padding(10.dp).clickable {
                        selectableItem("$it")
                    },
                    style = MaterialTheme.typography.labelSmall
                )
                Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
            }
        }
    }

    @Composable
    fun displayQuotes(selectableItem: (Quote) -> Unit) {
        val quotes = remember { ListOfQuotes.quotes }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            items(quotes.size) {
                quoteListItem(quotes[it],selectableItem)
            }
        }
    }

    @Composable
    fun quoteListItem(quote: Quote,selectableItem: (Quote) -> Unit){
        Card(
            modifier = Modifier.padding(8.dp, 4.dp).fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(18))
        ) {
            Column(modifier = Modifier.padding(16.dp).clickable {
                selectableItem(quote)
            }) {
                Text(text = quote.quote, style = MaterialTheme.typography.labelMedium)
                Text(text = quote.author, style = MaterialTheme.typography.labelSmall)
            }
        }
    }

}


