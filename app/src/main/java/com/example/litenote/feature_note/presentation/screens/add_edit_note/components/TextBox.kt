package com.example.litenote.feature_note.presentation.screens.add_edit_note.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import com.example.litenote.feature_note.presentation.screens.add_edit_note.utils.TextType

@Composable
fun TextBox(
    modifier: Modifier = Modifier,
    textType: TextType,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardActions: KeyboardActions,
    keyboardOptions: KeyboardOptions,
    focusRequester: FocusRequester? = null
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = when (textType) {
            TextType.Title -> {
                modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester!!)
            }

            else -> modifier.fillMaxWidth()
        },
        singleLine = textType == TextType.Title,
        textStyle = if (textType == TextType.Title) {
            MaterialTheme.typography.titleMedium
        } else {
            MaterialTheme.typography.titleSmall
        },
        placeholder = {
            Text(
                text = if (textType == TextType.Title) "Title" else "Body",
                style = if (textType == TextType.Title) {
                    MaterialTheme.typography.titleMedium
                } else {
                    MaterialTheme.typography.titleSmall
                }
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.background,
            unfocusedSupportingTextColor = MaterialTheme.colorScheme.onBackground,
            focusedContainerColor = MaterialTheme.colorScheme.background,
            focusedIndicatorColor = MaterialTheme.colorScheme.background,
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            errorContainerColor = MaterialTheme.colorScheme.errorContainer,
            cursorColor = MaterialTheme.colorScheme.primary
        ),
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions
    )

    if (textType == TextType.Title) {
        LaunchedEffect(Unit) {
            focusRequester!!.requestFocus()
        }
    }
}