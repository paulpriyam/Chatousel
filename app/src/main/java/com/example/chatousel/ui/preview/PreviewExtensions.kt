package com.example.chatousel.ui.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices.PIXEL_7
import androidx.compose.ui.tooling.preview.Preview

const val LIGHT = "light"
const val DARK = "dark"


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, device = PIXEL_7, name = "pixel 7 dark", group = DARK)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO, device = PIXEL_7, name = "pixel 7 light", group = LIGHT)
annotation class EqualPreview