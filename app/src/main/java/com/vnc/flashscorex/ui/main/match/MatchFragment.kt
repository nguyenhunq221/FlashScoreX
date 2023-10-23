package com.vnc.flashscorex.ui.main.match

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.MatchAdapter
import com.vnc.flashscorex.databinding.FragmentMatchBinding
import com.vnc.flashscorex.model.fixture.ResponseDetail
import com.vnc.flashscorex.utils.GetCurrent

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
        setObserve()
        matchViewModel.showMatch(idLeague, GetCurrent.getCurrentYear())
        matchViewModel.getRound(idLeague,GetCurrent.getCurrentYear())
        setUpView()
    }

    private fun setObserve() {
        matchViewModel.getListMatch().observe(viewLifecycleOwner) {
            getStanding(it)
        }
        matchViewModel.getListMatchError().observe(viewLifecycleOwner){
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        }

        matchViewModel.getListRoundError().observe(viewLifecycleOwner){
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        }

        matchViewModel.getListRound().observe(viewLifecycleOwner){
            getRound(it)
        }
    }

    private fun setUpView(){
        var isFirstSelection = true
        binding.spinnerRound.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (isFirstSelection) {
                    isFirstSelection = false
                }else{
                    matchViewModel.showMatch(idLeague,GetCurrent.getCurrentYear(),parent?.getItemAtPosition(position).toString(),null)
                }
            }

        }

        binding.notStart.setOnClickListener{
            matchViewModel.showMatch(idLeague, GetCurrent.getCurrentYear(),null,StatusMatch.NS.toString())
        }

        binding.swiperefresh.setOnRefreshListener {
            matchViewModel.showMatch(idLeague, GetCurrent.getCurrentYear(),null,null)
        }
    }

    private fun getStanding(mList: List<ResponseDetail>) {
        matchAdapter = MatchAdapter(mList, requireActivity())
        binding.rcvMatch.adapter = matchAdapter
    }

    private fun getRound(listRound:List<String>){
        binding.spinnerRound.adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1,listRound)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}