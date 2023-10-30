package com.misw.vinilos.ui.screens.albums

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.misw.vinilos.data.remote.models.Album
import com.misw.vinilos.viewmodels.AlbumsViewModel

@Composable
fun AlbumsListScreen(viewModel: AlbumsViewModel) {
    val albums = viewModel.albums.value

    LazyColumn {
        items(albums) { album ->
            AlbumListItem(album = album)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumListItem(album: Album) {
    ListItem(
        headlineText = { Text(album.name) },
        supportingText = { Text(album.genre) },
        leadingContent = {
            Image(
                painter = rememberAsyncImagePainter(model = album.cover),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        },
        trailingContent = {
            Icon(
                imageVector = Icons.Filled.ArrowRight,
                contentDescription = null
            )
        }
    )
}