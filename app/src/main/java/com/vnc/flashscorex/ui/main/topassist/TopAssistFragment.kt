package com.vnc.flashscorex.ui.main.topassist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.adapter.TopAssistAdapter
import com.vnc.flashscorex.databinding.FragmentTopAssistBinding
import com.vnc.flashscorex.model.topScore.ResponseDetail

class TopAssistFragment(var idLeague: Int) : Fragment() {
    private  var _binding: FragmentTopAssistBinding? = null
    private lateinit var topAssistAdapter: TopAssistAdapter
    private lateinit var topAssistViewModel: TopAssistViewModel
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        topAssistViewModel = ViewModelProvider(this)[TopAssistViewModel::class.java]
        _binding = FragmentTopAssistBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topAssistViewModel.showListTopAssist(idLeague,2023)
        setObserve()
    }

    private fun setObserve(){
        topAssistViewModel.getTopAssistList().observe(viewLifecycleOwner){
            getTopAssist(it)
        }
        topAssistViewModel.getTopAssistError().observe(viewLifecycleOwner){
            Toast.makeText(requireActivity(),it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getTopAssist(mList:List<ResponseDetail>){
        topAssistAdapter = TopAssistAdapter(mList,requireActivity())
        binding.rcvTopAssist.adapter = topAssistAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}