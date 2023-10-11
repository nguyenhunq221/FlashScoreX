package com.vnc.flashscorex.ui.main.standing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.adapter.StandingAdapter
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.FragmentStandingBinding
import com.vnc.flashscorex.model.standing.StandingDetail

class StandingFragment(var idLeague: Int) : Fragment() {
    private  var _binding: FragmentStandingBinding? = null
    private lateinit var viewModel: StandingViewModel
    private lateinit var adapter:StandingAdapter
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
        viewModel.showStandings(idLeague,2023)
        setObserve()
    }

    private fun setObserve(){
        viewModel.getStanding().observe(viewLifecycleOwner){
            getStanding(it)
        }
    }

    private fun getStanding(mList:List<StandingDetail>){
        adapter = StandingAdapter(mList,requireActivity())
        binding.rcvStanding.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}