package com.example.menu.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.components.FoodFilterRow
import com.example.designsystem.components.MenuItemCard
import com.example.domain.model.FoodFilter
import com.example.menu.presentation.components.MenuHeader
import com.example.menu.presentation.contract.MenuEvent
import com.example.menu.presentation.contract.MenuState
import com.example.menu.presentation.view_model.MenuViewModel
import com.example.navigation.app_navigator.LocalNavigator
import com.example.navigation.cart.CartRoute
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    viewModel: MenuViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val navigator = LocalNavigator.current

    MenuScreenContent(
        uiState = state,
        onEvent = viewModel::onEvent,
        onNavigateToCart = { navigator.navigateTo(CartRoute) },
        modifier = modifier
    )
}

@Composable
private fun MenuScreenContent(
    uiState: MenuState,
    onEvent: (MenuEvent) -> Unit,
    onNavigateToCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        MenuHeader(
            cartCount = uiState.totalCartCount,
            onCartClick = onNavigateToCart
        )

        Spacer(modifier = Modifier.height(8.dp))

        FoodFilterRow(
            items = FoodFilter.entries,
            selectedItem = uiState.selectedFilter,
            itemLabel = { it.label },
            onItemSelected = { filter ->
                onEvent(MenuEvent.OnFilterSelected(filter))
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(
                items = uiState.menuItems.chunked(2),
                key = { pair -> pair.first().id }
            ) { pair ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    pair.forEach { item ->
                        MenuItemCard(
                            item = item,
                            cartQuantity = uiState.getQuantityFor(item.id),
                            onAddToCart = { onEvent(MenuEvent.OnAddToCart(it)) },
                            onIncrementQuantity = { itemId, newQty ->
                                onEvent(MenuEvent.OnIncrementQuantity(itemId, newQty))
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    if (pair.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}