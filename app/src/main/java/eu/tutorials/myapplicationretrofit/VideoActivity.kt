package eu.tutorials.myapplicationretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button


class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.videoactivity)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        // Load Trailer 1
        val webViewTrailer1: WebView = findViewById(R.id.webviewTrailer1)
        val videoTrailer1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Way9Dexny3w?si=BKQgPzcy75iUlEs2\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        webViewTrailer1.loadData(videoTrailer1, "text/html", "utf-8")
        webViewTrailer1.settings.javaScriptEnabled = true
        webViewTrailer1.webViewClient = WebViewClient()

        // Load Trailer 2
        val webViewTrailer2: WebView = findViewById(R.id.webviewTrailer2)
        val videoTrailer2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_inKs4eeHiI?si=w0_HFx9NslDquHmp\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        webViewTrailer2.loadData(videoTrailer2, "text/html", "utf-8")
        webViewTrailer2.settings.javaScriptEnabled = true
        webViewTrailer2.webViewClient = WebViewClient()

        // Load Trailer 3
        val webViewTrailer3: WebView = findViewById(R.id.webviewTrailer3)
        val videoTrailer3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/qqrpMRDuPfc?si=e21SOh2-j55b4Sg6\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        webViewTrailer3.loadData(videoTrailer3, "text/html", "utf-8")
        webViewTrailer3.settings.javaScriptEnabled = true
        webViewTrailer3.webViewClient = WebViewClient()

        // Load Trailer 4
        val webViewTrailer4: WebView = findViewById(R.id.webviewTrailer4)
        val videoTrailer4 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/54VXLy1YCUY?si=NgzJh5N_8nw8VMEG\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        webViewTrailer4.loadData(videoTrailer4, "text/html", "utf-8")
        webViewTrailer4.settings.javaScriptEnabled = true
        webViewTrailer4.webViewClient = WebViewClient()

        // Load Trailer 5
        val webViewTrailer5: WebView = findViewById(R.id.webviewTrailer5)
        val videoTrailer5 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/9SX-jF6dTPU?si=OeDUbN-ODZ5xSR8T\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        webViewTrailer5.loadData(videoTrailer5, "text/html", "utf-8")
        webViewTrailer5.settings.javaScriptEnabled = true
        webViewTrailer4.webViewClient = WebViewClient()

        // Load Trailer 6
        val webViewTrailer6: WebView = findViewById(R.id.webviewTrailer6)
        val videoTrailer6 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Y0ZsLudtfjI?si=jtQNJa3xgpcMtd-O\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        webViewTrailer6.loadData(videoTrailer6, "text/html", "utf-8")
        webViewTrailer6.settings.javaScriptEnabled = true

        // Bottom navigation buttons
        button1.setOnClickListener {
            startActivity(Intent(this@VideoActivity, MainActivity::class.java))
        }

        button2.setOnClickListener {
            // Start MainActivity
            startActivity(Intent(this@VideoActivity, VideoActivity::class.java))
        }

        button3.setOnClickListener {
            // Start MusicActivity
            startActivity(Intent(this@VideoActivity, MusicActivity::class.java))
    }



}

}

