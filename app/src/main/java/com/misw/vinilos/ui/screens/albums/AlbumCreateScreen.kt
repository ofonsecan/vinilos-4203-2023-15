package com.misw.vinilos.ui.screens.albums

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumCreateScreen() {
    var albumName by remember { mutableStateOf("") }
    var albumCover by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) }
    var coverError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = albumName,
            onValueChange = {
                albumName = it
                nameError = it.isBlank() // Validates the album name
            },
            label = { Text("Album Name") },
            isError = nameError,
            singleLine = true,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            supportingText = {
                if (nameError) {
                    Text("Album name cannot be empty", color = MaterialTheme.colorScheme.error)
                }
            }
        )
        OutlinedTextField(
            value = albumCover,
            onValueChange = {
                albumCover = it
                coverError = it.isBlank() // Validates the album cover URL
            },
            label = { Text("Album Cover URL") },
            isError = coverError,
            singleLine = true,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            supportingText = {
                if (coverError) {
                    Text("Album cover URL cannot be empty", color = MaterialTheme.colorScheme.error)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                nameError = albumName.isBlank()
                coverError = albumCover.isBlank()
                if (!nameError && !coverError) {
                    // TODO: Handle album creation logic with albumName and albumCover
                }
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text("Create Album")
        }
    }
}