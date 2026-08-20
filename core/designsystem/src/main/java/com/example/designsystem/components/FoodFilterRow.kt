package com.example.designsystem.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.FoodGoTheme

enum class FoodFilter(val label: String) {
    ALL("All"),
    PIZZA("Pizza"),
    SALADS("Salads"),
    DRINKS("Drinks")
}

@Composable
fun FoodFilterRow(
    selected: FoodFilter,
    modifier: Modifier = Modifier,
    onFilterSelected: (FoodFilter) -> Unit
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(FoodFilter.entries) { filter ->
            FilterChipItem(
                label = filter.label,
                isSelected = filter == selected,
                onClick = { onFilterSelected(filter) }
            )
        }
    }
}

@Composable
private fun FilterChipItem(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val textColor by animateColorAsState(
        targetValue = if (isSelected) FoodGoTheme.colors.white else FoodGoTheme.colors.textSecondary,
        label = "TextColorAnimation"
    )
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) FoodGoTheme.colors.primaryBlue else FoodGoTheme.colors.white,
        label = "BackgroundColorAnimation"
    )
    val borderColor = if (isSelected) Color.Transparent else FoodGoTheme.colors.borderNeutral

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .border(1.dp, borderColor, CircleShape)
            .clickable(onClick = onClick)
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(
            text = label,
            color = textColor,
            style = FoodGoTheme.typography.bodyMedium,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}

@Composable
@Preview
private fun FilterChipItemPreview() {
    FoodGoTheme {
        FilterChipItem("Pizza", false) { }
    }
}

@Composable
@Preview
private fun FilterChipRowPreview() {
    FoodGoTheme {
        FoodFilterRow(
            selected = FoodFilter.ALL,
            modifier = Modifier
        ) { }
    }
}