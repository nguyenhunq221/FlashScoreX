package com.vnc.flashscorex.ui.main.topassist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.adapter.TopAssistAdapter
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.FragmentTopAssistBinding
import com.vnc.flashscorex.model.topScore.Player
import com.vnc.flashscorex.model.topScore.ResponseDetail
import com.vnc.flashscorex.ui.player.DetailPlayerActivity
import com.vnc.flashscorex.utils.GetCurrent

class TopAssistFragment(var idLeague: Int) : Fragment(),TopAssistAdapter.ItemClickListener {
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
        topAssistViewModel.showListTopAssist(idLeague, GetCurrent.getCurrentYear())
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
        topAssistAdapter.setClickListener(this)
        binding.rcvTopAssist.adapter = topAssistAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClickLikePlayer(player: Player) {
        TODO("Not yet implemented")
    }

    override fun onClickDetailPlayer(responseDetail: ResponseDetail) {
        val intent = Intent(requireActivity(), DetailPlayerActivity ::class.java)
        intent.putExtra(Constants.PUTDATA.DETAIL_PLAYER,responseDetail)
        startActivity(intent)
    }

}