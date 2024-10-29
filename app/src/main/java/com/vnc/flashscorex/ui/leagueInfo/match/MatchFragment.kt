package com.vnc.flashscorex.ui.leagueInfo.match

import android.content.Intent
import android.os.Bundle
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
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.FragmentMatchBinding
import com.vnc.flashscorex.model.fixture.ResponseDetail
import com.vnc.flashscorex.utils.GetCurrent

class MatchFragment(var idLeague: Int) : Fragment(),MatchAdapter.ItemClickListener {
    private var _binding: FragmentMatchBinding? = null
    private lateinit var matchAdapter: MatchAdapter
    private lateinit var matchViewModel: MatchViewModel
    private val binding get() = _binding!!
    companion object {
        private const val TAG = "MatchFragment"
    }

    enum class League(val id:Int, val leagueName:String){
        UEFA_EURO(4,"euro"),
        WORLD_CUP(1,"world cup")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        matchViewModel = ViewModelProvider(this)[MatchViewModel::class.java]
        _binding = FragmentMatchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserve()
        if (idLeague == League.UEFA_EURO.id){
            matchViewModel.showMatch(idLeague, 2024)
            matchViewModel.getRound(idLeague,2024)
        }else if (idLeague == League.WORLD_CUP.id){
            matchViewModel.showMatch(idLeague, 2022)
            matchViewModel.getRound(idLeague,2022)
        }else {
            matchViewModel.showMatch(idLeague, GetCurrent.getCurrentYear())
            matchViewModel.getRound(idLeague,GetCurrent.getCurrentYear())
        }
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
            Toast.makeText(requireActivity(), getString(R.string.call_api_fail_default), Toast.LENGTH_SHORT).show()
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
                    if (idLeague == League.UEFA_EURO.id){
                        matchViewModel.showMatch(idLeague, 2024,null,StatusMatch.NS.toString())
                    }else if (idLeague == League.WORLD_CUP.id){
                        matchViewModel.showMatch(idLeague, 2022,null,StatusMatch.NS.toString())
                    }else {
                        matchViewModel.showMatch(idLeague, GetCurrent.getCurrentYear(),parent?.getItemAtPosition(position).toString())
                    }
                }
            }

        }

        binding.notStart.setOnClickListener{
            if (idLeague == League.UEFA_EURO.id){
                matchViewModel.showMatch(idLeague, 2024,null,StatusMatch.NS.toString())
            }else if (idLeague == League.WORLD_CUP.id){
                matchViewModel.showMatch(idLeague, 2022,null,StatusMatch.NS.toString())
            }else {
                matchViewModel.showMatch(idLeague, GetCurrent.getCurrentYear(),null,StatusMatch.NS.toString())
            }
        }

        binding.swiperefresh.setOnRefreshListener {
            if (idLeague == League.UEFA_EURO.id){
                matchViewModel.showMatch(idLeague, 2024)
            }else if (idLeague == League.WORLD_CUP.id){
                matchViewModel.showMatch(idLeague, 2022)
            }else {
                matchViewModel.showMatch(idLeague, GetCurrent.getCurrentYear())
            }
        }
    }

    private fun getStanding(mList: List<ResponseDetail>) = with(binding) {
        if(mList.isEmpty()){
            shimmerFrameLayout.startShimmer()
        }else{
            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.visibility = View.GONE
            matchAdapter = MatchAdapter(mList, requireActivity())
            matchAdapter.setClickListener(this@MatchFragment)
            rcvMatch.adapter = matchAdapter
        }
    }

    private fun getRound(listRound:List<String>){
        binding.spinnerRound.adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1,listRound)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClickMatch(responseDetail: ResponseDetail) {
        val intent = Intent(requireActivity(),DetailMatchActivity::class.java)
        intent.putExtra(Constants.KEY.KEY_MATCH,responseDetail.fixture.id)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerFrameLayout.startShimmer()
    }

    override fun onPause() {
        binding.shimmerFrameLayout.stopShimmer()
        super.onPause()
    }
}