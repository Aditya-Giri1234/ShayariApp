package com.aditya.shayariapp.ui_layer.screen

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.CopyAll
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Whatsapp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aditya.shayariapp.data_layer.model.AllShayariDTO
import com.aditya.shayariapp.data_layer.util.Constants


@Composable
fun ShayariScreen(navController: NavController, list: List<AllShayariDTO>) {

    val context= LocalContext.current

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        topBar = {
            Card(
                modifier = Modifier
                    .height(56.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp

                        )
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBackIosNew,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Shayari ", style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
            }
        }) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
        ) {


            items(list) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(5.dp)
                        .clip(
                            RoundedCornerShape(
                                10.dp
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = it.shayari.toString(), textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.height(10.dp))
                        Spacer(
                            modifier = Modifier
                                .height(2.dp)
                                .fillMaxWidth()
                                .background(Color.Black)
                        )
                        Spacer(
                            modifier = Modifier
                                .height(3.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Icon(imageVector = Icons.Rounded.ContentCopy, contentDescription = null , modifier = Modifier.clickable {
                                copyToClipboard(context,it.shayari.toString())
                            })
                            Icon(imageVector = Icons.Rounded.Whatsapp, contentDescription = null , modifier = Modifier.clickable {
                                shareToWhatsApp(context,it.shayari.toString())
                            })
                            Icon(imageVector = Icons.Rounded.Share, contentDescription = null , modifier = Modifier.clickable {
                                shareData(context,it.shayari.toString())
                            })
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }

}


fun copyToClipboard(context: Context, text: String) {
    // Get the clipboard manager
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    // Create a ClipData object
    val clip = ClipData.newPlainText("Copied Text", text)

    // Set the created ClipData to the clipboard
    clipboard.setPrimaryClip(clip)

    Toast.makeText(context, "Text is copied by ${context.getAppName()}", Toast.LENGTH_SHORT).show()

}

private fun shareToWhatsApp(context: Context,message: String) {
    // Create an intent with the action ACTION_SEND
    val sendIntent = Intent()
    sendIntent.action = Intent.ACTION_SEND

    // Set the type of data to text/plain
    sendIntent.type = "text/plain"

    // Set the message you want to share
    sendIntent.putExtra(Intent.EXTRA_TEXT, message)

    // Set the package name of WhatsApp
    sendIntent.`package` = "com.whatsapp"

    // Check if WhatsApp is installed on the device
    if (sendIntent.resolveActivity(context.packageManager) != null) {
        // Start the activity with the share intent
        context.startActivity(sendIntent)
    } else {
        // WhatsApp is not installed, show a toast message
        Toast.makeText(context, "WhatsApp is not installed", Toast.LENGTH_SHORT).show()
    }


}

fun shareData(context: Context, message: String) {
    // Create an intent with the action ACTION_SEND
    val sendIntent = Intent()
    sendIntent.action = Intent.ACTION_SEND

    // Set the type of data to text/plain
    sendIntent.type = "text/plain"

    // Set the message you want to share
    sendIntent.putExtra(Intent.EXTRA_TEXT, message)

    // Start the activity with the share intent
    context.startActivity(sendIntent)
}

fun Context.getAppName(): String {
    // Get the application's package name
    val packageName = packageName

    // Get the application's label (name) using the package manager
    val packageManager = packageManager
    val applicationInfo = packageManager.getApplicationInfo(packageName, 0)
    return packageManager.getApplicationLabel(applicationInfo).toString()
}