package com.example.retrofitexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitexample.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: MarsViewModel by activityViewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        val adapter = MarsAdapter()
        binding.rVMars.adapter = adapter
        binding.rVMars.layoutManager = GridLayoutManager(context,2)


        viewModel.allTask.observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("PRUEBA", "$it")
                adapter.update(it)
            }
        })

        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                val bundle = Bundle()
                bundle.putString("id",it.id)
                bundle.putLong("price",it.price)
                bundle.putString("type",it.type)
                bundle.putString("imagen",it.imgSrc)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
            }
        })


       /*
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        */
    }
}