package com.example.retrofitexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.retrofitexample.databinding.FragmentFirstBinding
import com.example.retrofitexample.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel: MarsViewModel by activityViewModels()
    private var idPic: String = ""
    private var idType: String = ""
    private var idPrice: Long = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idPic = it.getString("id", "")
            idPrice = it.getLong("price", -1)
            idType = it.getString("type", "")


        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(binding.imageView2).load(idPic).into(binding.imageView2)
        binding.textViewPrice.text = idPrice.toLong().toString()
        binding.textViewType.text = idType

//       viewModel.getTaskById(idPic).observe(viewLifecycleOwner, Observer {
//           it?.let {
//               binding.textViewPrice.text.toString().toLong()
//               binding.textViewType.setText(it.type)
//                Glide.with(binding.imageView2).load(idPic).into(binding.imageView2)
//
//           }
//       })

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}