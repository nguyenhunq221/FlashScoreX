package com.vnc.flashscorex.ui.main.standing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.StandingAdapter
import com.vnc.flashscorex.databinding.FragmentStandingBinding
import com.vnc.flashscorex.model.standing.StandingDetail

class StandingFragment : Fragment() {
    private lateinit var binding: FragmentStandingBinding
    private lateinit var viewModel: StandingViewModel
    private lateinit var adapter:StandingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[StandingViewModel::class.java]
        binding = FragmentStandingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showStandings(39,2023)
        setObserve()
    }

    fun setObserve(){
        viewModel.getStanding().observe(viewLifecycleOwner){
            getStanding(it)
        }
    }

    fun getStanding(mList:List<StandingDetail>){
        adapter = StandingAdapter(mList,requireActivity())
        binding.rcvStanding.adapter = adapter
    }

}