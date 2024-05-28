package com.vnc.flashscorex.ui.detailMatch.matchEvent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.R
import com.vnc.flashscorex.databinding.FragmentMatchEventBinding

class MatchEventFragment : Fragment() {

    private var _binding: FragmentMatchEventBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MatchEventViewModel
    companion object {
        private const val TAG = "MatchEventFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[MatchEventViewModel::class.java]
        _binding = FragmentMatchEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}