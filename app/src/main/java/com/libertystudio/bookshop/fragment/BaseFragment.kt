package com.libertystudio.bookshop.fragment

import androidx.fragment.app.Fragment
import com.libertystudio.bookshop.MainActivity

open class BaseFragment : Fragment() {
    fun startFragment(fragment: Fragment) {
        activity?.let {
            (it as MainActivity).startFragment(fragment)
        }
    }
}