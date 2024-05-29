package com.vnc.flashscorex.ui.detailMatch.matchPlayerStatistic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.databinding.FragmentPlayerStatisticBinding

class PlayerStatisticFragment : Fragment() {
    private var _binding: FragmentPlayerStatisticBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PlayerStatisticViewModel
    companion object {
        private const val TAG = "PlayerStatisticFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[PlayerStatisticViewModel::class.java]
        _binding = FragmentPlayerStatisticBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}