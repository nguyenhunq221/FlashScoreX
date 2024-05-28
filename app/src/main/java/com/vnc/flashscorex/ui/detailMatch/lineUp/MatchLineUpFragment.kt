package com.vnc.flashscorex.ui.detailMatch.lineUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.databinding.FragmentMatchStatisticBinding

class MatchLineUpFragment : Fragment() {
    private var _binding:FragmentMatchStatisticBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel:MatchLineUpViewModel
    companion object {
        private const val TAG = "MatchLineUpFragment"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[MatchLineUpViewModel::class.java]
        _binding = FragmentMatchStatisticBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}