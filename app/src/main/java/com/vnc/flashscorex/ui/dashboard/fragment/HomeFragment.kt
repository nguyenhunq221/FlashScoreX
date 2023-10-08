package com.vnc.flashscorex.ui.dashboard.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smarteist.autoimageslider.SliderView
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.BannerAdapter
import com.vnc.flashscorex.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var bannerList:ArrayList<Int> = ArrayList()
    private lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()

    }

    fun setUpView() = with(binding){
        bannerList.add(R.drawable.ic_champion_league)
        bannerList.add(R.drawable.ic_europaleague)
        bannerList.add(R.drawable.euro)
        bannerList.add(R.drawable.quata)

        var adapter = BannerAdapter(requireContext(),bannerList)
        binding.slider.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        binding.slider.setSliderAdapter(adapter)
        binding.slider.scrollTimeInSec = 4
        binding.slider.isAutoCycle = true
        binding.slider.startAutoCycle()

    }
}