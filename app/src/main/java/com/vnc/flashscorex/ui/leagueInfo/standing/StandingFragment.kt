package com.vnc.flashscorex.ui.leagueInfo.standing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.adapter.StandingParentAdapter
import com.vnc.flashscorex.databinding.FragmentStandingBinding
import com.vnc.flashscorex.model.standing.StandingDetail
import com.vnc.flashscorex.utils.GetCurrent

class StandingFragment(var idLeague: Int) : Fragment() {
    private  var _binding: FragmentStandingBinding? = null
    private lateinit var viewModel: StandingViewModel
    private lateinit var adapterParentStanding:StandingParentAdapter
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[StandingViewModel::class.java]
        _binding = FragmentStandingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (idLeague == 1 ){
            viewModel.showStandings(idLeague, 2022)
        }else if (idLeague == 4){
            viewModel.showStandings(idLeague, 2024)
        }else{
            viewModel.showStandings(idLeague, GetCurrent.getCurrentYear())
        }

        setObserve()
    }

    private fun setObserve(){

        viewModel.getParentStanding().observe(viewLifecycleOwner){
            getParentStanding(it)
        }

        viewModel.getStandingError().observe(viewLifecycleOwner){
            Toast.makeText(requireActivity(),it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getParentStanding(mList:List<List<StandingDetail>>){
        adapterParentStanding = StandingParentAdapter(mList,requireActivity())
        binding.rcvStanding.adapter = adapterParentStanding
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}