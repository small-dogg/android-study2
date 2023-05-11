package com.smalldogg.study.androidstudy2

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smalldogg.study.androidstudy2.databinding.ActivityResBasicBinding

class ResBasic : AppCompatActivity() {
    lateinit var b: ActivityResBasicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityResBasicBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.button34.setOnClickListener {
//            b.textView15.text="반갑습니다."
//            b.textView15.setText(R.string.str2)
//            val str2 = resources.getString(R.string.str2)
            val str2 = getString(R.string.str2)
            b.textView15.text = str2
        }

        b.button35.setOnClickListener {
            val str3 = getString(R.string.str3)
            val str4 = String.format(str3, "홍길동", 30)
            b.textView15.text = str4
        }

        b.button36.setOnClickListener {
            val data_list = resources.getStringArray(R.array.data_array)

            b.textView15.text = ""
            for (str1 in data_list) {
                b.textView15.append("$str1\n")
            }
        }

        b.button37.setOnClickListener {
//            b.textView15.setTextColor(Color.BLUE)
//            val color = Color.rgb(26,106,129)
//            val color = Color.argb(50,26,106,129)
//            val color = getColor(R.color.color2)
//            val color = getColor(R.color.color3)
            val color = getColor(R.color.color4)
            b.textView15.setTextColor(color)
        }

        b.button38.setOnClickListener {
            val px = resources.getDimension(R.dimen.px)
            val dp = resources.getDimension(R.dimen.dp)
            val sp = resources.getDimension(R.dimen.sp)
            val inch = resources.getDimension(R.dimen.inch)
            val mm = resources.getDimension(R.dimen.mm)
            val pt = resources.getDimension(R.dimen.pt)

            b.textView15.text="px :$px\n"
            b.textView15.append("dp :$dp\n")
            b.textView15.append("sp :$sp\n")
            b.textView15.append("inch :$inch\n")
            b.textView15.append("mm :$mm\n")
            b.textView15.append("pt :$pt\n")

            b.textView15.textSize = 20 * sp
        }
    }
}