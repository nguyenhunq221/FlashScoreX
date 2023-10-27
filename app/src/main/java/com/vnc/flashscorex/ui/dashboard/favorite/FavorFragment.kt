package com.vnc.flashscorex.ui.dashboard.favorite

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.vnc.flashscorex.R
import com.vnc.flashscorex.utils.SwipeToDeleteCallback
import com.vnc.flashscorex.adapter.FavoritePlayerAdapter
import com.vnc.flashscorex.database.FavorPlayerDatabase
import com.vnc.flashscorex.databinding.FragmentFavorBinding
import com.vnc.flashscorex.model.topScore.Player

class FavorFragment : Fragment(), FavoritePlayerAdapter.ItemClickListener {
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
        _binding = FragmentFavorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        favorViewModel.loadListFavorPlayer(requireActivity())

        val swipeDelete = object : SwipeToDeleteCallback(requireActivity()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val player = adapter.getListPlayer()[viewHolder.adapterPosition]

                AlertDialog.Builder(requireActivity())
                    .setTitle(getString(R.string.delete_player, player.name))
                    .setPositiveButton(getString(R.string.accept)) { _, _ ->
                        FavorPlayerDatabase.getDatabase(requireActivity()).playerDao()
                            .deletePlayer(player)
                        Toast.makeText(requireActivity(), context?.getString(R.string.delete_player_notice), Toast.LENGTH_SHORT).show()
                        favorViewModel.loadListFavorPlayer(requireActivity())
                    }.setNegativeButton(getString(R.string.cancel)) { _, _ ->
                        adapter.notifyDataSetChanged()
                    }
                    .setCancelable(false).create().show()
            }
        }
        val swipeLeftToDelete = ItemTouchHelper(swipeDelete)
        swipeLeftToDelete.attachToRecyclerView(binding.rcvFavorPlayer)

        binding.btSearch.setOnClickListener{
            if (binding.search.text.toString().isEmpty()){
                favorViewModel.loadListFavorPlayer(requireActivity())
            }
            else{
                favorViewModel.searchPlayer(requireActivity(),binding.search.text.toString())
            }
        }
    }

    private fun setObserver() {
        favorViewModel.getListFavorPlayer().observe(viewLifecycleOwner) {
            if (it.isEmpty()){
                binding.nothing.visibility = View.VISIBLE
            }else{
                binding.nothing.visibility = View.GONE
                getFavorPlayer(it)
            }
        }

        favorViewModel.getListSearchPlayer().observe(viewLifecycleOwner){
            if (it.isEmpty()){
                binding.nothing.visibility = View.VISIBLE
            }else{
                binding.nothing.visibility = View.GONE
                getFavorPlayer(it)
            }
        }
    }

    private fun getFavorPlayer(mList: List<Player>) {
        adapter = FavoritePlayerAdapter(mList, requireActivity())
        adapter.setClickListener(this)
        binding.rcvFavorPlayer.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClickDeletePlayer(player: Player) {

    }

}