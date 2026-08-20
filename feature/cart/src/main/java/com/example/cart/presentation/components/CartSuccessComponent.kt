package com.example.cart.presentation.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.FoodGoPrimaryButton
import com.example.designsystem.theme.FoodGoTheme.colors
import com.example.designsystem.theme.FoodGoTheme.typography

@Composable
fun CartSuccessComponent(
    onBackToMenuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isAnimated by remember { mutableStateOf(false) }

    val scaleAnimation by animateFloatAsState(
        targetValue = if (isAnimated) 1f else 0.2f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "SuccessBadgeScale"
    )

    LaunchedEffect(Unit) {
        isAnimated = true
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .scale(scaleAnimation)
                .size(120.dp)
                .background(color = colors.primaryBlue, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "✓",
                style = typography.titleLarge,
                color = colors.white,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Payment Successful!",
            style = typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = colors.textPrimary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Your order has been placed successfully.\nWe are preparing your food!",
            style = typography.bodyMedium,
            color = colors.textSecondary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        FoodGoPrimaryButton(
            text = "Back to Menu",
            onClick = onBackToMenuClick,
            modifier = Modifier.fillMaxWidth(0.85f)
        )
    }
}