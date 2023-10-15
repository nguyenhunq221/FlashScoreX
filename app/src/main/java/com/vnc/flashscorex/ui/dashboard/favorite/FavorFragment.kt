package com.vnc.flashscorex.ui.dashboard.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.FavoritePlayerAdapter
import com.vnc.flashscorex.databinding.FragmentFavorBinding
import com.vnc.flashscorex.model.topScore.Player

class FavorFragment : Fragment() {
    private var _binding: FragmentFavorBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: FavoritePlayerAdapter
    private lateinit var favorViewModel: FavorViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favorViewModel = ViewModelProvider(this)[FavorViewModel::class.java]
        _binding = FragmentFavorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        favorViewModel.loadListFavorPlayer(requireActivity())
    }

    fun setObserver(){
        favorViewModel.getListFavorPlayer().observe(viewLifecycleOwner){
            getFavorPlayer(it)
        }
    }

    fun getFavorPlayer(mList:List<Player>){
        adapter = FavoritePlayerAdapter(mList,requireActivity())
        binding.rcvFavorPlayer.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}