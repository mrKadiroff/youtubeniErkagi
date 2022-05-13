package com.example.youtube_clone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.youtube_clone.R
import com.example.youtube_clone.YouTubeFailureRecoveryActivity
import com.example.youtube_clone.databinding.FragmentHomeBinding
import com.example.youtube_clone.databinding.FragmentPlayerBinding
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlayerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayerFragment : YouTubeFailureRecoveryActivity() {
    lateinit var binding: PlayerFragment
    lateinit var videoId: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_player)


        videoId = intent.getStringExtra("video_id") ?: ""

        val fragment =
            fragmentManager.findFragmentById(R.id.youtube_fragment) as YouTubePlayerFragment
        fragment.initialize("AIzaSyBwqkWWk4o9gfMggm1Kz8sWfnuPZySMGrg", this)


}

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        if (!p2) {
            p1?.cueVideo(videoId)
        }
    }

    override fun getYouTubePlayerProvider(): YouTubePlayer.Provider {
        return fragmentManager.findFragmentById(R.id.youtube_fragment) as YouTubePlayerFragment
    }

}