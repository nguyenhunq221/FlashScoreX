package com.vnc.flashscorex.ui.main.topscore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.TopAssistAdapter
import com.vnc.flashscorex.adapter.TopScoreAdapter
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.FragmentTopScoreBinding
import com.vnc.flashscorex.model.topScore.ResponseDetail

class TopScoreFragment(var idLeague: Int) : Fragment() {
    private  var _binding: FragmentTopScoreBinding?= null
    private lateinit var topScoreViewModel: TopScoreViewModel
    private lateinit var topScoreAdapter: TopScoreAdapter
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        topScoreViewModel = ViewModelProvider(this)[TopScoreViewModel::class.java]
        _binding = FragmentTopScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topScoreViewModel.showListTopScore(idLeague,2023)
        setObserve()
    }

    private fun setObserve(){
        topScoreViewModel.getTopScoreList().observe(viewLifecycleOwner){
            getTopScore(it)
        }
        topScoreViewModel.getTopScoreError().observe(viewLifecycleOwner){
            Toast.makeText(requireActivity(),it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getTopScore(mList:List<ResponseDetail>){
        topScoreAdapter = TopScoreAdapter(mList,requireActivity())
        binding.rcvTopScore.adapter = topScoreAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}