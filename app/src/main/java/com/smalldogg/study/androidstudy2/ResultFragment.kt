package com.smalldogg.study.androidstudy2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager

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

        val text = view.findViewById<TextView>(R.id.textView14)

        text.text = "data1 : $data1\n"

        val data2 = pref?.getBoolean("data2", false)
        text?.append("data2 : $data2\n")

        val data3 = pref?.getBoolean("data3", false)
        text?.append("data3 : $data3\n")

        val data4 = pref?.getString("data4", null)
        text?.append("data4 : $data4\n")

        val data5 = pref?.getStringSet("data5", null)
        for (str in data5!!) {
            text.append("data5 : $str\n")
        }
    }
}