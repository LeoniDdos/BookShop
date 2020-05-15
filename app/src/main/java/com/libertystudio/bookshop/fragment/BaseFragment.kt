package com.libertystudio.bookshop.fragment

import androidx.fragment.app.Fragment
import com.libertystudio.bookshop.MainActivity

open class BaseFragment : Fragment() {
    fun startFragment(fragment: Fragment) {
        getMainActivity().startFragment(fragment)
    }

    fun setTitle(title: String) {
        getMainActivity().setTitle(title)
    }

    private fun getMainActivity(): MainActivity {
        return requireActivity() as MainActivity
    }
}