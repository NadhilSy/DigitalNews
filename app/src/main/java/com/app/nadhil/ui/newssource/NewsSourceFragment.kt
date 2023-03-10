package com.app.nadhil.ui.newssource

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.nadhil.R
import com.app.nadhil.data.api.response.Source
import com.app.nadhil.databinding.FragmentNewsSourceBinding
import com.app.nadhil.ui.MainActivity
import com.app.nadhil.utils.Dialog
import com.app.nadhil.utils.ViewState
import com.app.nadhil.utils.isNetworkOnline
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class NewsSourceFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: NewsSourceViewModel
    private lateinit var adapter : NewsSourceViewAdapter
    private lateinit var binding: FragmentNewsSourceBinding
    private val safeArgs : NewsSourceFragmentArgs by navArgs()
    private lateinit var dialog : Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            safeArgs.category.uppercase()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewsSourceBinding.inflate(layoutInflater, container, false)
        val activity = activity as? MainActivity
        activity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity?.supportActionBar?.setHomeButtonEnabled(true)
        adapter = NewsSourceViewAdapter {
            onNavigateToArticle(it)
        }
        dialog = Dialog(requireActivity())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvSources.layoutManager = LinearLayoutManager(context)
            rvSources.adapter = adapter
        }
        initViewModel()
        subscribe()
        getNewsSource()


    }

    private fun getNewsSource(){
        if (requireActivity().isNetworkOnline()){
            binding.apply {
                btnRetry.visibility = View.GONE
            }
            viewModel.getNewsSourceByCategory(safeArgs.category)
        } else {
            binding.apply {
                btnRetry.visibility = View.VISIBLE
                btnRetry.setOnClickListener {
                    getNewsSource()
                }
            }
            Snackbar.make(requireView(), "Offline", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[NewsSourceViewModel::class.java]
    }

    private fun subscribe(){
        viewModel.sources.observe(viewLifecycleOwner) {
            it?.let {
                when (it) {
                    is ViewState.Loading -> {
                        Log.d("News-Source", "Loading")
                        dialog.show()
                    }
                    is ViewState.Success -> {
                        it.data?.let { data ->
                            adapter.submitData(data)
                            adapter.notifyDataSetChanged()
                        }
                        Log.d("News-Source", "Success")
                        dialog.dismiss()
                    }
                    is ViewState.Error -> {
                        Log.d("News-Source", it.errorMessage.toString())
                        dialog.dismiss()
                    }
                }
            }
        }
    }

    private fun onNavigateToArticle(data : Source) {
        val directions = NewsSourceFragmentDirections.actionNewsSourceFragmentToArticleFragment(sourceId = data.id)
        findNavController().navigate(directions)
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsSourceFragment()
    }
}