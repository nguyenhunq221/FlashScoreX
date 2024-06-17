package com.vnc.flashscorex.ui.main.topscore

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.TopScoreAdapter
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.database.FavorPlayerDatabase
import com.vnc.flashscorex.databinding.FragmentTopScoreBinding
import com.vnc.flashscorex.model.topScore.Player
import com.vnc.flashscorex.model.topScore.ResponseDetail
import com.vnc.flashscorex.ui.player.DetailPlayerActivity
import com.vnc.flashscorex.utils.GetCurrent

class TopScoreFragment(var idLeague: Int) : Fragment(),TopScoreAdapter.ItemClickListener {
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
        if (idLeague == 1){
            topScoreViewModel.showListTopScore(idLeague,2022)
        }else if (idLeague == 4){
            topScoreViewModel.showListTopScore(idLeague,2024)
        }else{
            topScoreViewModel.showListTopScore(idLeague,GetCurrent.getCurrentYear())
        }
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
        topScoreAdapter.setClickListener(this)
        binding.rcvTopScore.adapter = topScoreAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClickLikePlayer(player: Player) {
        if ( FavorPlayerDatabase.getDatabase(requireActivity()).playerDao().checkPlayer(player.id).isEmpty()){
            FavorPlayerDatabase.getDatabase(requireActivity()).playerDao().savePlayer(player)
            Toast.makeText(requireActivity(),requireContext().getString(R.string.have_player_added), Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireActivity(),requireContext().getString(R.string.player_added), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClickDetailPlayer(responseDetail: ResponseDetail) {
       val intent = Intent(requireActivity(), DetailPlayerActivity ::class.java)
        intent.putExtra(Constants.PUTDATA.DETAIL_PLAYER,responseDetail)
        startActivity(intent)
    }
}