package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.*
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections


/**
 * A simple [Fragment] subclass.
 * Use the [InstructionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: InstructionsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.instructions_fragment, container, false)
        binding.lifecycleOwner = this

        binding.viewShoesButton.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsToList())
        }

        return binding.root
    }
}

