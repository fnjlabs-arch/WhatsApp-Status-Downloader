package com.sadsha.statussaver.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sadsha.statussaver.Models.MediaModel
import com.sadsha.statussaver.Utils.Constants
import com.sadsha.statussaver.Adapters.ImagePreviewAdapter
import com.sadsha.statussaver.databinding.ActivityImagePreviewBinding

class ImagePreviewActivity : AppCompatActivity() {
    private val activity = this
    private val binding by lazy {
        ActivityImagePreviewBinding.inflate(layoutInflater)
    }
    lateinit var adapter: ImagePreviewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            val list =
                intent.getSerializableExtra(Constants.MEDIA_LIST_KEY) as ArrayList<MediaModel>
            val scrollTo = intent.getIntExtra(Constants.MEDIA_SCROLL_KEY, 0)
            adapter = ImagePreviewAdapter(list, activity)
            imagesViewPager.adapter = adapter
            imagesViewPager.currentItem = scrollTo

            // Setup toolbar navigation
            toolBar.setNavigationOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }

        }
    }
}