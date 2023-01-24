package com.app.nadhil.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.nadhil.R
import com.app.nadhil.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnBusiness.setOnClickListener {
                val directions = CategoryFragmentDirections.actionCategoryFragmentToNewsSourceFragment(category = "business")
                findNavController().navigate(directions)
            }
            btnEntertainment.setOnClickListener {
                val directions = CategoryFragmentDirections.actionCategoryFragmentToNewsSourceFragment(category = "entertainment")
                findNavController().navigate(directions)
            }
            btnGeneral.setOnClickListener {
                val directions = CategoryFragmentDirections.actionCategoryFragmentToNewsSourceFragment(category = "general")
                findNavController().navigate(directions)
            }
            btnScience.setOnClickListener {
                val directions = CategoryFragmentDirections.actionCategoryFragmentToNewsSourceFragment(category = "science" )
                findNavController().navigate(directions)
            }
            btnSport.setOnClickListener{
                val directions = CategoryFragmentDirections.actionCategoryFragmentToNewsSourceFragment(category = "sports")
                findNavController().navigate(directions)
            }
            btnTechnology.setOnClickListener {
                val directions = CategoryFragmentDirections.actionCategoryFragmentToNewsSourceFragment(category = "technology")
                findNavController().navigate(directions)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CategoryFragment()
    }
}