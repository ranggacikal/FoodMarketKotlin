package com.ranggacikal.foodmarketkotlin.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ranggacikal.foodmarketkotlin.R
import com.ranggacikal.foodmarketkotlin.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.fragment_signup.*

class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnContinue.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_signup_address, null)

            (activity as AuthActivity).toolbarSignUpAddres()
        }
    }


}