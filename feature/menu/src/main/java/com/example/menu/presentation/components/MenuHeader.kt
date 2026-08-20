package com.example.menu.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystem.theme.FoodGoTheme

@Composable
fun MenuHeader(
    cartCount: Int,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = "FoodGo",
            style = FoodGoTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = FoodGoTheme.colors.textPrimary
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "what would you like to eat?",
                style = FoodGoTheme.typography.bodyMedium,
                color = FoodGoTheme.colors.textSecondary
            )

            Box(
                contentAlignment = Alignment.TopEnd
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(FoodGoTheme.colors.primaryBlue)
                        .clickable(onClick = onCartClick)
                        .padding(horizontal = 18.dp, vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Cart",
                        color = FoodGoTheme.colors.white,
                        style = FoodGoTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (cartCount > 0) {
                    Box(
                        modifier = Modifier
                            .offset(x = 6.dp, y = (-6).dp)
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(FoodGoTheme.colors.badgeRed),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (cartCount > 99) "99+" else cartCount.toString(),
                            color = FoodGoTheme.colors.white,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}