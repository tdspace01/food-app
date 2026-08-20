package com.example.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.CartItem
import com.example.ui.mapper.toDrawableRes

@Composable
fun MenuItemCard(
    item: CartItem,
    cartQuantity: Int,
    onAddToCart: (CartItem) -> Unit,
    onIncrementQuantity: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val imageBackgroundColor = Color(0xFFFDE8E0)
    val cardShape = RoundedCornerShape(
        topStart = CornerSize(0.dp),
        topEnd = CornerSize(0.dp),
        bottomStart = CornerSize(16.dp),
        bottomEnd = CornerSize(16.dp)
    )

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = cardShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(115.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = CornerSize(0.dp),
                            topEnd = CornerSize(0.dp),
                            bottomEnd = CornerSize(0.dp),
                            bottomStart = CornerSize(0.dp)
                        )
                    )
                    .background(imageBackgroundColor)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF1E2761),
                        shape = RoundedCornerShape(
                            topStart = CornerSize(0.dp),
                            topEnd = CornerSize(0.dp),
                            bottomEnd = CornerSize(0.dp),
                            bottomStart = CornerSize(0.dp)
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = item.imageResId.toDrawableRes()),
                    contentDescription = item.name,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(80.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    ),
                    color = Color(0xFF1E2761),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 11.sp,
                        lineHeight = 14.sp
                    ),
                    color = Color(0xFF6B7280),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.height(28.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "₾ ${"%.2f".format(item.price)}",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        ),
                        color = Color(0xFF1E2761)
                    )

                    if (cartQuantity == 0) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF378ADD))
                                .clickable { onAddToCart(item) }
                                .padding(horizontal = 14.dp, vertical = 7.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Add +",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFE6F4EA))
                                .clickable { onIncrementQuantity(item.id, cartQuantity + 1) }
                                .padding(horizontal = 10.dp, vertical = 7.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Added ✓",
                                color = Color(0xFF2D9D78),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}