package com.example.artspace

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var artImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var yearTextView: TextView
    private lateinit var previousButton: View
    private lateinit var nextButton: View

    private lateinit var artworks: Array<String>
    private lateinit var titles: Array<String>
    private lateinit var years: Array<String>
    private var currentArtIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artImageView = findViewById(R.id.art_img)
        titleTextView = findViewById(R.id.textView)
        yearTextView = findViewById(R.id.year)
        previousButton = findViewById(R.id.button)
        nextButton = findViewById(R.id.button2)

        artworks = arrayOf(
            "artwork1",
            "artwork2",
            "artwork3"
        )
        titles = arrayOf(
            getString(R.string.title1),
            getString(R.string.title2),
            getString(R.string.title3)
        )
        years = arrayOf(
            getString(R.string.year1),
            getString(R.string.year2),
            getString(R.string.year3)
        )

        updateArtwork()

        previousButton.setOnClickListener {
            showPreviousArtwork()
        }

        nextButton.setOnClickListener {
            showNextArtwork()
        }
    }

    private fun showPreviousArtwork() {
        if (currentArtIndex > 0) {
            currentArtIndex--
        } else {
            currentArtIndex = artworks.size - 1
        }
        updateArtwork()
    }

    private fun showNextArtwork() {
        if (currentArtIndex < artworks.size - 1) {
            currentArtIndex++
        } else {
            currentArtIndex = 0
        }
        updateArtwork()
    }

    private fun updateArtwork() {
        val imageResourceId = resources.getIdentifier(artworks[currentArtIndex], "drawable", packageName)
        artImageView.setImageResource(imageResourceId)
        titleTextView.text = titles[currentArtIndex]
        yearTextView.text = years[currentArtIndex]
    }
}