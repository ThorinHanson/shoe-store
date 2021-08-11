package com.udacity.shoestore.screens.shoelist

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.ShoeModel




class ShoeListFragment : Fragment() {
    private lateinit var binding: ShoeListFragmentBinding
    private val viewModel: ShoeModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            shoes.forEach() { shoe ->
                val name = TextView(this.context)
                val size = TextView(this.context)
                val company = TextView(this.context)
                val description = TextView(this.context)
                val shoeSize = shoe.size.toString()

                name.text = shoe.name
                name.setBackgroundColor(Color.parseColor("#CCCCCC"))
                size.text = "Size: $shoeSize"
                size.setBackgroundColor(Color.parseColor("#CCCCCC"))
                company.text = shoe.company
                company.setBackgroundColor(Color.parseColor("#CCCCCC"))
                description.text = shoe.description
                description.setBackgroundColor(Color.parseColor("#CCCCCC"))


                val parentLayout = LinearLayout(this.context)
                val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(5, 0, 5, 25)
                parentLayout.orientation = LinearLayout.VERTICAL
                parentLayout.setPadding(10, 10, 10, 10)
                parentLayout.addView(name)
                parentLayout.addView(size)
                parentLayout.addView(company)
                parentLayout.addView(description)

                binding.shoeLayout.addView(parentLayout, params)
            }

        })
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)
        binding.lifecycleOwner = this
        binding.addShoeButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListToShoeDetai())
        }


        return binding.root
    }


}