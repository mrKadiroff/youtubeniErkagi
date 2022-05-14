package com.example.youtube_clone.bottom_nav

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.youtube_clone.MainActivity
import com.example.youtube_clone.PlayActivity
import com.example.youtube_clone.R
import com.example.youtube_clone.adapters.MainAdapter
import com.example.youtube_clone.adapters.PhotoAdapter
import com.example.youtube_clone.databinding.FragmentHomeBinding
import com.example.youtube_clone.fragments.PlayerFragment
import com.example.youtube_clone.models2.YoutubeApiData
import com.example.youtube_clone.pager.UserViewModel
import com.example.youtube_clone.utils.Status
import com.example.youtube_clone.viewmodel.YoutubeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var binding: FragmentHomeBinding
    private val TAG = "HomeFragment"
    lateinit var list: ArrayList<String>
    lateinit var youtubeViewModel: YoutubeViewModel
    lateinit var userViewModel: UserViewModel
    lateinit var mainAdapter: MainAdapter
    var data: YoutubeApiData? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        if (data!=null){
            Log.d(TAG, "onCreateView: ${data!!.items}")
        }



        binding.editMicrpophone.setOnClickListener {
            val toString = binding.editSerach.text.toString()
            Log.d(TAG, "onCreateView: $toString")
            GlobalScope.launch(Dispatchers.Main) {
                userViewModel.getWord(toString)
                    .observe(viewLifecycleOwner) {






                        when (it.status) {
                            Status.LOADING -> {

                            }

                            Status.ERROR -> {
                                Toast.makeText(
                                    binding.root.context,
                                    "Word not found",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            Status.SUCCESS -> {

                                try {


                                    data = it.data
                                    mainAdapter = MainAdapter(data!!.items,object :MainAdapter.OnItemClickListener{
                                        override fun onItemClick(videoId: String) {
                                            val intent = Intent(binding.root.context,PlayActivity::class.java)
                                            intent.putExtra("video_id",videoId)
                                            startActivity(intent)
                                        }

                                    })
                                    binding.rvKurs.adapter = mainAdapter

                                    var list = it.data

                                }catch (e:java.lang.Exception){
                                    Toast.makeText(
                                        binding.root.context,
                                        "Word not found",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }






                            }
                        }



                    }



            }
        }




        return binding.root
    }

    private fun setRv() {

    }

    override fun onResume() {
        super.onResume()
        val toString = binding.editSerach.text.toString()
        GlobalScope.launch(Dispatchers.Main) {
            userViewModel.getWord(toString)
                .observe(viewLifecycleOwner) {






                    when (it.status) {
                        Status.LOADING -> {

                        }

                        Status.ERROR -> {
                            Toast.makeText(
                                binding.root.context,
                                "Word not found",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        Status.SUCCESS -> {

                            try {


                                mainAdapter = MainAdapter(data!!.items,object :MainAdapter.OnItemClickListener{
                                    override fun onItemClick(videoId: String) {
                                        val intent = Intent(binding.root.context,PlayActivity::class.java)
                                        intent.putExtra("video_id",videoId)
                                        startActivity(intent)
                                    }

                                })
                                binding.rvKurs.adapter = mainAdapter

                                var list = it.data

                            }catch (e:java.lang.Exception){
                                Toast.makeText(
                                    binding.root.context,
                                    "Word not found",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }






                        }
                    }



                }



        }

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}