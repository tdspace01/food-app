package com.example.cart.presentation.view_model

import androidx.lifecycle.viewModelScope
import com.example.cart.presentation.contract.CartEvent
import com.example.cart.presentation.contract.CartState
import com.example.domain.usecase.ClearCartUseCase
import com.example.domain.usecase.GetCartItemsUseCase
import com.example.domain.usecase.RemoveFromCartUseCase
import com.example.domain.usecase.UpdateCartQuantityUseCase
import com.example.ui.base.BaseViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CartViewModel(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val updateCartQuantityUseCase: UpdateCartQuantityUseCase,
    private val removeFromCartUseCase: RemoveFromCartUseCase,
    private val clearCartUseCase: ClearCartUseCase
) : BaseViewModel<CartState, CartEvent, Unit>(CartState()) {

    init {
        observeCartItems()
    }

    private fun observeCartItems() {
        getCartItemsUseCase()
            .onEach { items ->
                updateState { copy(cartItems = items) }
            }
            .launchIn(viewModelScope)
    }

    override fun onEvent(event: CartEvent) {
        when (event) {
            is CartEvent.OnIncrementQuantity -> handleIncrement(event.itemId, event.currentQty)
            is CartEvent.OnDecrementQuantity -> handleDecrement(event.itemId, event.currentQty)
            is CartEvent.OnCheckoutClicked -> handleCheckout()
            is CartEvent.OnResetSuccess -> updateState { copy(isSuccess = false) }
        }
    }

    private fun handleIncrement(itemId: Int, currentQty: Int) {
        if (currentQty >= 10) return
        viewModelScope.launch {
            updateCartQuantityUseCase(itemId, currentQty + 1)
        }
    }

    private fun handleDecrement(itemId: Int, currentQty: Int) {
        viewModelScope.launch {
            if (currentQty <= 1) {
                removeFromCartUseCase(itemId)
            } else {
                updateCartQuantityUseCase(itemId, currentQty - 1)
            }
        }
    }

    private fun handleCheckout() {
        viewModelScope.launch {
            clearCartUseCase()
            updateState { copy(isSuccess = true) }
        }
    }
}