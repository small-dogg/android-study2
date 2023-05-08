package com.smalldogg.study.androidstudy2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.smalldogg.study.androidstudy2.databinding.ActivityPreferencesScreenBinding

class ResultFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref = PreferenceManager.getDefaultSharedPreferences(requireContext())

        val data1 = pref?.getString("data1", null)

        val text : TextView? = getView()?.findViewById(R.id.textView12)

        text?.text = "data1 : $data1\n"

        val data2 = pref?.getBoolean("data2", false)
        text?.append("data2 : $data2\n")

    }
}