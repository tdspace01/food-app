package com.example.menu.presentation.view_model

import androidx.lifecycle.viewModelScope
import com.example.domain.model.CartItem
import com.example.domain.model.FoodFilter
import com.example.domain.usecase.AddToCartUseCase
import com.example.domain.usecase.GetCartItemsUseCase
import com.example.domain.usecase.GetMenuItemsUseCase
import com.example.domain.usecase.UpdateCartQuantityUseCase
import com.example.menu.presentation.contract.MenuEvent
import com.example.menu.presentation.contract.MenuState
import com.example.ui.base.BaseViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MenuViewModel(
    private val getMenuItemsUseCase: GetMenuItemsUseCase,
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val addToCartUseCase: AddToCartUseCase,
    private val updateCartQuantityUseCase: UpdateCartQuantityUseCase
) : BaseViewModel<MenuState, MenuEvent, Unit>(MenuState()) {

    init {
        loadMenuItems(FoodFilter.ALL)
        observeCartItems()
    }

    override fun onEvent(event: MenuEvent) {
        when (event) {
            is MenuEvent.OnFilterSelected -> loadMenuItems(event.filter)
            is MenuEvent.OnAddToCart -> handleAddToCart(event.item)
            is MenuEvent.OnIncrementQuantity -> {
                handleIncrementQuantity(event.itemId, event.newQuantity)
            }
        }
    }

    private fun loadMenuItems(filter: FoodFilter) {
        val filteredItems = getMenuItemsUseCase(filter)
        updateState {
            copy(
                selectedFilter = filter,
                menuItems = filteredItems
            )
        }
    }

    private fun observeCartItems() {
        getCartItemsUseCase()
            .onEach { cartList ->
                updateState { copy(cartItems = cartList) }
            }
            .launchIn(viewModelScope)
    }

    private fun handleAddToCart(item: CartItem) {
        viewModelScope.launch {
            addToCartUseCase(item)
        }
    }

    private fun handleIncrementQuantity(itemId: Int, newQuantity: Int) {
        if (newQuantity <= 10) {
            viewModelScope.launch {
                updateCartQuantityUseCase(itemId, newQuantity)
            }
        }
    }
}