package com.phinion.bloggy.ui.screens.home.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.phinion.bloggy.R
import com.phinion.bloggy.domain.models.BlogItem
import com.phinion.bloggy.ui.theme.grey
import com.phinion.bloggy.ui.theme.lightGrey
import com.phinion.bloggy.ui.theme.poppins_semiBold
import com.phinion.bloggy.ui.theme.primaryColor

@Composable
fun BlogItemLayout(
    blogItem: BlogItem,
    onBlogItemClick: (blogUrl: String) -> Unit
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(grey, shape = RoundedCornerShape(12.dp))
            .clickable {
                onBlogItemClick(blogItem.link)
            }
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            model = blogItem.jetpackFeaturedMediaUrl,
            contentScale = ContentScale.Crop,
            contentDescription = "Blog Thumbnail"
        )

        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            Text(
                text = blogItem.title.rendered,
                maxLines = 2,
                style = MaterialTheme.typography.titleMedium.copy(lineHeight = 28.sp, fontFamily = poppins_semiBold),
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = blogItem.title.rendered,
                maxLines = 3,
                style = MaterialTheme.typography.bodyMedium.copy(color = lightGrey),
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = "Like Icon",
                    tint = primaryColor
                )
                Icon(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(id = R.drawable.ic_comment),
                    contentDescription = "Comment Icon",
                    tint = primaryColor
                )
                Icon(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = "Share Icon",
                    tint = primaryColor
                )

            }

            Spacer(modifier = Modifier.height(16.dp))
            
            Text(text = "View all ${blogItem.commentStatus.length} comments.", style = MaterialTheme.typography.bodyMedium )

        }


    }
}