package com.example.tnytnewsapplication.ui.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tnytnewsapplication.R
import com.example.tnytnewsapplication.databinding.FragmentRegistrationBinding
import com.example.tnytnewsapplication.databinding.FragmentSignInBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    private val viewModel by viewModel<AuthorizationViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.outlinedButton.setOnClickListener(){
            viewModel.signIn(binding.emailTextFieeld.editText?.text.toString(), binding.passwordTextField.editText?.text.toString(), requireActivity())


        }

        viewModel.toast = {
            Toast.makeText(
                requireContext(),
                if (it) {
                    findNavController().navigate(R.id.navigation_home)
                    "Sign In complete"
                } else {
                    "Sign In failed"
                }, Toast.LENGTH_SHORT

            ).show()
        }

        binding.clickableText.setOnClickListener(){
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToRegistrationFragment())
        }
    }



}