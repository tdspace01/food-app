package com.example.cart.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cart.presentation.components.CartHeader
import com.example.cart.presentation.components.CartSuccessComponent
import com.example.cart.presentation.contract.CartEvent
import com.example.cart.presentation.contract.CartState
import com.example.cart.presentation.view_model.CartViewModel
import com.example.designsystem.components.CartItemCard
import com.example.designsystem.components.EmptyCartComponent
import com.example.designsystem.components.FoodGoPrimaryButton
import com.example.designsystem.theme.FoodGoTheme.colors
import com.example.designsystem.theme.FoodGoTheme.typography
import com.example.navigation.app_navigator.LocalNavigator
import com.example.navigation.menu.MenuRoute
import org.koin.androidx.compose.koinViewModel

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val navigator = LocalNavigator.current

    CartScreenContent(
        uiState = state,
        onEvent = viewModel::onEvent,
        onNavigateToMenu = { navigator.navigateTo(MenuRoute) },
        onBackClick = { navigator.navigateBack() },
        modifier = modifier
    )
}

@Composable
private fun CartScreenContent(
    uiState: CartState,
    onEvent: (CartEvent) -> Unit,
    onNavigateToMenu: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        if (uiState.isSuccess) {
            CartSuccessComponent(
                onBackToMenuClick = {
                    onEvent(CartEvent.OnResetSuccess)
                    onNavigateToMenu()
                }
            )
        } else {
            CartHeader(onBackClick = onBackClick)

            if (uiState.isEmpty) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    EmptyCartComponent(onBrowseMenuClick = onNavigateToMenu)
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(
                        items = uiState.cartItems,
                        key = { item -> item.id }
                    ) { item ->
                        CartItemCard(
                            item = item,
                            onIncrement = {
                                onEvent(CartEvent.OnIncrementQuantity(item.id, item.quantity))
                            },
                            onDecrement = {
                                onEvent(CartEvent.OnDecrementQuantity(item.id, item.quantity))
                            }
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(colors.borderNeutral.copy(alpha = 0.2f))
                            .padding(horizontal = 20.dp, vertical = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total",
                            style = typography.titleLarge,
                            color = colors.textSecondary
                        )

                        Text(
                            text = "₾ ${"%.2f".format(uiState.totalPrice)}",
                            style = typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = colors.textPrimary
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    FoodGoPrimaryButton(
                        text = "Purchase",
                        onClick = { onEvent(CartEvent.OnCheckoutClicked) }
                    )
                }
            }
        }
    }
}