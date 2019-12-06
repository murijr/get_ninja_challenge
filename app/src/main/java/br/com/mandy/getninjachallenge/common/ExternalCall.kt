package br.com.mandy.getninjachallenge.common

import android.content.Context
import android.content.Intent
import android.net.Uri

class ExternalCall(private val context: Context) {

    fun performPhoneCall(number: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    fun sendMessageWithWhatsApp(number: String) {
        val uri = Uri.parse("smsto:$number")
        val sendIntent = Intent(Intent.ACTION_SENDTO, uri)
        sendIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        sendIntent.setPackage("com.whatsapp")
        context.startActivity(sendIntent)
    }
}