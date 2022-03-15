package com.mms.awebview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_WebView.loadUrl("https://www.bing.com")
        var webSetting = main_WebView.settings
        webSetting.javaScriptEnabled = true
        main_WebView.webViewClient = WebViewClient()
        main_Refresh.setOnRefreshListener {
            main_WebView.reload()
            main_Refresh.isRefreshing = false
        }
    }

    override fun onBackPressed() {
        if (main_WebView.canGoBack()){
            main_WebView.goBack()
        }else{
            onBackPressed()
        }
    }
}