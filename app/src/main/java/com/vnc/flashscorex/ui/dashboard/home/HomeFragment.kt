package com.vnc.flashscorex.ui.dashboard.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smarteist.autoimageslider.SliderView
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.BannerAdapter
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.FragmentHomeBinding
import com.vnc.flashscorex.ui.main.LeagueActivity

class HomeFragment : Fragment(),View.OnClickListener {

    private var bannerList:ArrayList<Int> = ArrayList()
    private  var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bannerList.add(R.drawable.ic_champion_league)
        bannerList.add(R.drawable.ic_europaleague)
        bannerList.add(R.drawable.euro)
        bannerList.add(R.drawable.quata)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()

    }

    private fun setUpView() = with(binding){

        var adapter = BannerAdapter(requireContext(),bannerList)
        slider.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        slider.setSliderAdapter(adapter)
        slider.scrollTimeInSec = 4
        slider.isAutoCycle = true
        slider.startAutoCycle()

        PremierLeague.setOnClickListener(this@HomeFragment)
        laliga.setOnClickListener(this@HomeFragment)
        seria.setOnClickListener(this@HomeFragment)
        bundesliga.setOnClickListener(this@HomeFragment)
        league1.setOnClickListener(this@HomeFragment)

    }

    override fun onClick(v: View?) {
        when(v!!.id){

            R.id.PremierLeague -> {
                val intent = Intent(requireActivity(),LeagueActivity::class.java)
                intent.putExtra(Constants.KEY.LEAGUE_TITLE,getString(R.string.premier_league_title))
                intent.putExtra(Constants.KEY.LEAGUE_ID,Constants.KEY.ID_PREMIER_LEAGUE)
                startActivity(intent)
            }

            R.id.laliga -> {
                val intent = Intent(requireActivity(),LeagueActivity::class.java)
                intent.putExtra(Constants.KEY.LEAGUE_TITLE,getString(R.string.laliga_title))
                intent.putExtra(Constants.KEY.LEAGUE_ID,Constants.KEY.ID_LALIGA)
                startActivity(intent)
            }

            R.id.seria -> {
                val intent = Intent(requireActivity(),LeagueActivity::class.java)
                intent.putExtra(Constants.KEY.LEAGUE_TITLE,getString(R.string.seria_title))
                intent.putExtra(Constants.KEY.LEAGUE_ID,Constants.KEY.ID_SERIA)
                startActivity(intent)
            }

            R.id.bundesliga -> {
                val intent = Intent(requireActivity(),LeagueActivity::class.java)
                intent.putExtra(Constants.KEY.LEAGUE_TITLE,getString(R.string.bundesliga_title))
                intent.putExtra(Constants.KEY.LEAGUE_ID,Constants.KEY.ID_BUNDESLIGA)
                startActivity(intent)
            }

            R.id.league1 -> {
                val intent = Intent(requireActivity(),LeagueActivity::class.java)
                intent.putExtra(Constants.KEY.LEAGUE_TITLE,getString(R.string.league1_title))
                intent.putExtra(Constants.KEY.LEAGUE_ID,Constants.KEY.ID_LEAGUE1)
                startActivity(intent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}