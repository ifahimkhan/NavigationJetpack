package com.fahim.navigationjetpack

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {


    private val args : LoginFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val deepLink=args.username
        txt_username.setText(deepLink)

        button_confirm.setOnClickListener{

            val usernameString=txt_username.text.toString()
            val passwordString=txt_password.text.toString()

            val action=LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(usernameString,passwordString)
            findNavController().navigate(action)
        }
    }
}