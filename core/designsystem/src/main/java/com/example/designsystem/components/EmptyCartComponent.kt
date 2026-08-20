package com.example.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.designsystem.design.Spacing
import com.example.designsystem.theme.FoodGoTheme.colors
import com.example.designsystem.theme.FoodGoTheme.typography

@Composable
fun EmptyCartComponent(
    onBrowseMenuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val containerShape = RoundedCornerShape(20.dp)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(containerShape)
            .background(colors.white)
            .border(
                width = 1.dp,
                color = colors.borderNeutral,
                shape = containerShape
            )
            .padding(vertical = Spacing.spacing22, horizontal = Spacing.spacing16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(
                    color = colors.borderNeutral.copy(alpha = 0.2f),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "🛒",
                style = typography.titleLarge
            )
        }

        Spacer(modifier = Modifier.height(Spacing.spacing20))

        Text(
            text = "Your cart is empty",
            style = typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = colors.textPrimary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Spacing.spacing6))

        Text(
            text = "Add items from the menu to start your order",
            style = typography.bodyMedium,
            color = colors.textSecondary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Spacing.spacing36))

        FoodGoPrimaryButton(
            text = "Browse menu",
            onClick = onBrowseMenuClick,
            modifier = Modifier.fillMaxWidth(0.85f)
        )
    }
}