package com.vnc.flashscorex.ui.detailMatch.matchEvent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.base.BaseFragment
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.customView.EventLine
import com.vnc.flashscorex.databinding.FragmentMatchEventBinding

class MatchEventFragment : BaseFragment() {

    private var _binding: FragmentMatchEventBinding? = null
    private lateinit var listMinutest: ArrayList<Int>
    private lateinit var listEvent: ArrayList<String>
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

        val bundle = this.arguments
        bundle?.let {
            val idFixture = it.getInt(Constants.PUTDATA.ID_FIXTURE,0)
            viewModel.getEvent(idFixture)
        }

        _binding = FragmentMatchEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setObserver() {
        val eventLine = EventLine(requireActivity())
        listMinutest = ArrayList()
        listEvent = ArrayList()
        viewModel.getListEvent().observe(viewLifecycleOwner){
            if (it.isNotEmpty()){
                for ( i in it.indices){
                    listMinutest.add(it[i].time.minuteGoal)
                    listEvent.add(it[i].type.toString())
                }
                eventLine.setData(listEvent,listMinutest)
            }
        }

    }

    override fun initView() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}