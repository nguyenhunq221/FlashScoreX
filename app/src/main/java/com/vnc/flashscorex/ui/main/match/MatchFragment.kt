package com.vnc.flashscorex.ui.main.match

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.adapter.MatchAdapter
import com.vnc.flashscorex.databinding.FragmentMatchBinding
import com.vnc.flashscorex.model.fixture.ResponseDetail

class MatchFragment(var idLeague: Int) : Fragment() {
    private var _binding: FragmentMatchBinding? = null
    private lateinit var matchAdapter: MatchAdapter
    private lateinit var matchViewModel: MatchViewModel
    private val TAG = "hung"
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        matchViewModel = ViewModelProvider(this)[MatchViewModel::class.java]
        _binding = FragmentMatchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "idFragment: " + idLeague)
        matchViewModel.showMatch(idLeague, 2023)
        setObserve()
    }

    private fun setObserve() {
        matchViewModel.getListMatch().observe(viewLifecycleOwner) {
            getStanding(it)
        }
        matchViewModel.getListMatchError().observe(viewLifecycleOwner){
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getStanding(mList: List<ResponseDetail>) {
        matchAdapter = MatchAdapter(mList, requireActivity())
        binding.rcvMatch.adapter = matchAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}