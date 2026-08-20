package com.example.domain.usecase

import com.example.domain.model.CartItem
import com.example.domain.model.FoodFilter

class GetMenuItemsUseCase {
    private val mockMenuList = listOf(
        CartItem(
            id = 1,
            name = "Margherita Pizza",
            description = "Classic tomato sauce, fresh mozzarella, and basil",
            price = 16.00,
            imageResId = 101
        ),
        CartItem(
            id = 2,
            name = "Caesar Salad",
            description = "Crispy romaine lettuce, croutons, and Parmesan cheese",
            price = 9.50,
            imageResId = 103
        ),
        CartItem(
            id = 3,
            name = "Iced Cola",
            description = "Refreshing chilled beverage 330ml",
            price = 3.00,
            imageResId = 102
        ),
        CartItem(
            id = 4,
            name = "Iced Cola 2",
            description = "Refreshing chilled beverage 330ml",
            price = 3.00,
            imageResId = 102
        ),
        CartItem(
            id = 5,
            name = "Caesar Salad 2",
            description = "Crispy romaine lettuce, croutons, and Parmesan cheese",
            price = 9.50,
            imageResId = 103
        ),
    )

    operator fun invoke(filter: FoodFilter = FoodFilter.ALL): List<CartItem> {
        return when (filter) {
            FoodFilter.ALL -> mockMenuList
            FoodFilter.PIZZA -> mockMenuList.filter {
                it.name.contains("Pizza", ignoreCase = true)
            }
            FoodFilter.SALADS -> mockMenuList.filter {
                it.name.contains("Salad", ignoreCase = true)
            }
            FoodFilter.DRINKS -> mockMenuList.filter {
                it.name.contains("Cola", ignoreCase = true)
            }
        }
    }
}