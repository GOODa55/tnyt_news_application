package com.example.tnytnewsapplication.ui.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.tnytnewsapplication.R
import com.example.tnytnewsapplication.databinding.FragmentRegistrationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding

    private val viewModel by viewModel<AuthorizationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.toast = {
            Toast.makeText(
                requireContext(),
                if (it) {
                    findNavController().navigate(R.id.navigation_home)
                    "Registation complete"
                } else {
                    "Registartion failed"
                }, Toast.LENGTH_SHORT

            ).show()
        }

        binding.outlinedButton.setOnClickListener(){
            if (validateEmail() && validatePassword()){
                viewModel.registration(binding.emailTextFieeld.editText?.text.toString(), binding.passwordTextField.editText?.text.toString(), requireActivity())
            }
        }

        binding.clickableText.setOnClickListener(){
            findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToSignInFragment())
        }
    }



    fun validateEmail(): Boolean{

        if(viewModel.validateEmail(binding.emailTextFieeld.editText?.text.toString())){
            return true
        }else{
            binding.emailTextFieeld.error = "Invalid Email"
            return false
        }

    }

    fun validatePassword():Boolean{
        if(viewModel.validatePassowrd(binding.passwordTextField.editText?.text.toString(), binding.confirmPasswordTextField.editText?.text.toString())){
            return true
        }else{
            binding.passwordTextField.error = "Invalid Password"
            return false
        }
    }

}