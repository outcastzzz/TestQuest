package com.example.testquest.presentation.roomsScreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testquest.databinding.FragmentRoomsBinding
import com.example.testquest.presentation.HotelApp
import com.example.testquest.presentation.ViewModelFactory
import javax.inject.Inject

class RoomsFragment: Fragment() {

    private lateinit var viewModel: RoomsViewModel

    private val component by lazy {
        (requireActivity().application as HotelApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentRoomsBinding? = null
    private val binding: FragmentRoomsBinding
        get() = _binding ?: throw RuntimeException("FragmentRoomsBinding == null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[RoomsViewModel::class.java]
    }

    private fun setupRecyclerView() {
        val adapter = RoomItemAdapter(requireActivity().applicationContext)
        binding.rvRoom.adapter = adapter
        viewModel.roomsList.observe(this) {
            adapter.submitList(it)
        }
    }


}