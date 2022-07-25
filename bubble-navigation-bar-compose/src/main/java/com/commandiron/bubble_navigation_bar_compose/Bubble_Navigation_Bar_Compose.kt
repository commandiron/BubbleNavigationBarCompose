package com.commandiron.bubble_navigation_bar_compose

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BubbleNavigationBar(
    modifier: Modifier = Modifier,
    navigationHeight: Dp = 64.dp,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = containerColor,
        contentColor = contentColor,
        tonalElevation = 4.dp,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 24.dp)
                .height(navigationHeight)
                .padding(horizontal = navigationHeight / 4)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}

@Composable
fun RowScope.BubbleNavigationBarItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    @DrawableRes icon: Int,
    selectedColor: Color,
    unSelectedBackgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    unSelectedIconColor: Color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.1f),
    title: String
) = BubbleNavigationBarItem(
    modifier,
    selected,
    onClick,
    painterResource(icon),
    selectedColor,
    unSelectedBackgroundColor,
    unSelectedIconColor,
    title,
)

@Composable
fun RowScope.BubbleNavigationBarItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    selectedColor: Color,
    unSelectedBackgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    unSelectedIconColor: Color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.1f),
    title: String
) = BubbleNavigationBarItem(
    modifier,
    selected,
    onClick,
    rememberVectorPainter(icon),
    selectedColor,
    unSelectedBackgroundColor,
    unSelectedIconColor,
    title,
)

@Composable
fun RowScope.BubbleNavigationBarItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    iconPainter: Painter,
    selectedColor: Color,
    unSelectedBackgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    unSelectedIconColor: Color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.1f),
    title: String
) {
    val interactionSource =  remember { MutableInteractionSource() }
    BoxWithConstraints(
        modifier = modifier
            .fillMaxHeight()
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        val navigationHeight = maxHeight
        Surface(
            color = if(selected) selectedColor.copy(alpha = 0.2f) else unSelectedBackgroundColor,
            shape = RoundedCornerShape(navigationHeight / 2)
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        vertical = navigationHeight / 12,
                        horizontal = navigationHeight / 4
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.height(navigationHeight / 2),
                    painter = iconPainter,
                    contentDescription = null,
                    tint = if(selected) selectedColor else unSelectedIconColor
                )
                AnimatedVisibility(
                    visible = selected
                ) {
                    Spacer(modifier = Modifier.width(navigationHeight / 24))
                    Text(
                        text = title,
                        color = selectedColor,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1
                    )
                }
            }
        }
    }
}





















