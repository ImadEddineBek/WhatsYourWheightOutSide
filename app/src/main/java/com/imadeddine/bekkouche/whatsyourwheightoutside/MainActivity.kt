package com.imadeddine.bekkouche.whatsyourwheightoutside

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.RadioGroup
import android.widget.TextView
import com.imadeddine.bekkouche.whatsyourwheightoutside.R.id.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var checked:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val empty=weightNbr.text.toString()
        weightNbr.addTextChangedListener(MyTextWatch(place,result,empty))
        place.setOnCheckedChangeListener({group: RadioGroup?, checkedId: Int ->
            change(weightNbr.text,place,result,empty)
        })
    }

    class MyTextWatch(var place:RadioGroup,var result: TextView?,var editable: String) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            change(s,place,result,editable)
        }

    }
}
fun change(s:CharSequence?,place: RadioGroup,result: TextView?,editable: String){
    var f=0.0
    if (s!!.toString() != editable){
        when(place.checkedRadioButtonId){
            marsRBtn->{f=0.379}
            jupyterRBtn->{f=2.528}
            uranusRBtn->{f=0.889}
        }
    result!!.text = "Your ${s.toString().toInt() * f}"
    }else
    result!!.text = "0"
}
