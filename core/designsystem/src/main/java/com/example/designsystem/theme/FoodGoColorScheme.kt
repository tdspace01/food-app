package com.example.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

private val PrimaryBlue = Color(0xFF378ADD)
private val BadgeRed = Color(0xFFE24B4A)
private val AddedGreenText = Color(0xFF2D9D78)
private val AddedGreenBg = Color(0xFFE6F4EA)
private val TextPrimary = Color(0xFF1E2761)
private val TextSecondary = Color(0xFF6B7280)
private val BgScreen = Color(0xFFF3F4F6)
private val CardBg = Color(0xFFFFFFFF)
private val BorderNeutral = Color(0xFFE5E7EB)
private val White = Color(0xFFFFFFFF)

@Immutable
data class FoodGoColorScheme(
    val isDark: Boolean,
    val primaryBlue: Color,
    val badgeRed: Color,
    val addedGreenText: Color,
    val addedGreenBg: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val bgScreen: Color,
    val cardBg: Color,
    val borderNeutral: Color,
    val white: Color
)

val LightColorScheme = FoodGoColorScheme(
    isDark = false,
    primaryBlue = PrimaryBlue,
    badgeRed = BadgeRed,
    addedGreenText = AddedGreenText,
    addedGreenBg = AddedGreenBg,
    textPrimary = TextPrimary,
    textSecondary = TextSecondary,
    bgScreen = BgScreen,
    cardBg = CardBg,
    borderNeutral = BorderNeutral,
    white = White
)

val DarkColorScheme = FoodGoColorScheme(
    isDark = false,
    primaryBlue = PrimaryBlue,
    badgeRed = BadgeRed,
    addedGreenText = AddedGreenText,
    addedGreenBg = AddedGreenBg,
    textPrimary = TextPrimary,
    textSecondary = TextSecondary,
    bgScreen = BgScreen,
    cardBg = CardBg,
    borderNeutral = BorderNeutral,
    white = White
)