package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn0: Button =findViewById(R.id.btn0)
        val btn1: Button =findViewById(R.id.btn1)
        val btn2: Button =findViewById(R.id.btn2)
        val btn3: Button =findViewById(R.id.btn3)
        val btn4: Button =findViewById(R.id.btn4)
        val btn5: Button =findViewById(R.id.btn5)
        val btn6: Button =findViewById(R.id.btn6)
        val btn7: Button =findViewById(R.id.btn7)
        val btn8: Button =findViewById(R.id.btn8)
        val btn9: Button =findViewById(R.id.btn9)
        val btn_point: Button =findViewById(R.id.btn_point)
        val btn_div: Button =findViewById(R.id.btn_div)
        val btn_mul: Button =findViewById(R.id.btn_mul)
        val btn_min: Button =findViewById(R.id.btn_min)
        val btn_add: Button =findViewById(R.id.btn_add)
        val btn_eql: Button =findViewById(R.id.btn_eql)
        val btn_per: Button =findViewById(R.id.btn_per)
        val btn_opp: Button =findViewById(R.id.btn_opp)
        val btn_AC: Button =findViewById(R.id.btn_AC)
        val mon1:EditText=findViewById(R.id.mon1)
        val mon2:EditText=findViewById(R.id.mon2)

        mon1.setKeyListener(null)
        mon2.setKeyListener(null)

        val calculator=Calculator()
        var display1:String=""                         //显示屏1要输出的字符串
        var display2:String="0"                        //显示屏2要输出的字符串
        var status=1                                   //输入状态(按中序表达式排序1:数字，2:符号，3:结果)
        var pointed=false                              //是否输入过小数点
        var isNeg=false                                //是否为负数
        var isAc=true                                  //(true:清理全部输入，false:清理当前输入)

        fun AC2C(){                                    //AC和C之间切换
            isAc=false
            btn_AC.setText("C")
        }

        fun setMon(){
            mon1.setText(display1)
            mon2.setText(display2)
        }

        btn0.setOnClickListener {
            when(status){
                1->{
                    if(display2!="0"&&display2!="-0"){ display2+="0" }
                }
                2->{
                    display1+=("$display2 ")
                    display2="0"
                    status=1
                }
            }
            AC2C()
            setMon()
        }

        btn1.setOnClickListener {
            when(status){
                1->{
                    when (display2) {
                        "0" -> { display2="1" }
                        "-0" -> { display2="-1" }
                        else -> {display2+="1"}
                    }
                }
                2->{
                    display1+=("$display2 ")
                    display2="1"
                    status=1
                }
            }
            AC2C()
            setMon()
        }

        btn2.setOnClickListener {
            when(status){
                1->{
                    when (display2) {
                        "0" -> { display2="2" }
                        "-0" -> { display2="-2" }
                        else -> {display2+="2"}
                    }
                }
                2->{
                    display1+=("$display2 ")
                    display2="2"
                    status=1
                }
            }
            AC2C()
            setMon()
        }

        btn3.setOnClickListener {
            when(status){
                1->{
                    when (display2) {
                        "0" -> { display2="3" }
                        "-0" -> { display2="-3" }
                        else -> {display2+="3"}
                    }
                }
                2->{
                    display1+=("$display2 ")
                    display2="3"
                    status=1
                }
            }
            AC2C()
            setMon()
        }

        btn4.setOnClickListener {
            when(status){
                1->{
                    when (display2) {
                        "0" -> { display2="4" }
                        "-0" -> { display2="-4" }
                        else -> {display2+="4"}
                    }
                }
                2->{
                    display1+=("$display2 ")
                    display2="4"
                    status=1
                }
            }
            AC2C()
            setMon()
        }

        btn5.setOnClickListener {
            when(status){
                1->{
                    when (display2) {
                        "0" -> { display2="5" }
                        "-0" -> { display2="-5" }
                        else -> {display2+="5"}
                    }
                }
                2->{
                    display1+=("$display2 ")
                    display2="5"
                    status=1
                }
            }
            AC2C()
            setMon()
        }

        btn6.setOnClickListener {
            when(status){
                1->{
                    when (display2) {
                        "0" -> { display2="6" }
                        "-0" -> { display2="-6" }
                        else -> {display2+="6"}
                    }
                }
                2->{
                    display1+=("$display2 ")
                    display2="6"
                    status=1
                }
            }
            AC2C()
            setMon()
        }

        btn7.setOnClickListener {
            when(status){
                1->{
                    when (display2) {
                        "0" -> { display2="7" }
                        "-0" -> { display2="-7" }
                        else -> {display2+="7"}
                    }
                }
                2->{
                    display1+=("$display2 ")
                    display2="7"
                    status=1
                }
            }
            AC2C()
            setMon()
        }

        btn8.setOnClickListener {
            when(status){
                1->{
                    when (display2) {
                        "0" -> { display2="8" }
                        "-0" -> { display2="-8" }
                        else -> {display2+="8"}
                    }
                }
                2->{
                    display1+=("$display2 ")
                    display2="8"
                    status=1
                }
            }
            AC2C()
            setMon()
        }

        btn9.setOnClickListener {
            when(status){
                1->{
                    when (display2) {
                        "0" -> { display2="9" }
                        "-0" -> { display2="-9" }
                        else -> {display2+="9"}
                    }
                }
                2->{
                    display1+=("$display2 ")
                    display2="9"
                    status=1
                }
            }
            AC2C()
            setMon()
        }

        btn_point.setOnClickListener {
            if(!pointed) {
                when (status) {
                    1 -> display2 += "."
                    2 -> {
                        display1 += ("$display2 ")
                        display2 = "0."
                        AC2C()
                        status = 1
                    }
                }
                pointed=true
                setMon()
            }
        }

        btn_div.setOnClickListener {
            when(status){
                1->{
                    display1+=("$display2 ")
                    display2="÷"
                    status=2
                    AC2C()
                    setMon()
                }
                3->
                {
                    display1+=("$display2 ")
                    display2="÷"
                    status=2
                    AC2C()
                    setMon()
                }
            }
        }

        btn_mul.setOnClickListener {
            when(status) {
                1 -> {
                    display1 += ("$display2 ")
                    display2 = "×"
                    status = 2
                    AC2C()
                    setMon()
                }
                3-> {
                    display1 += ("$display2 ")
                    display2 = "×"
                    status = 2
                    AC2C()
                    setMon()
                }
            }
        }

        btn_add.setOnClickListener {
            when(status) {
                1 -> {
                    display1 += ("$display2 ")
                    display2 = "+"
                    status = 2
                    AC2C()
                    setMon()
                }
                3->{
                    display1 += ("$display2 ")
                    display2 = "+"
                    status = 2
                    AC2C()
                    setMon()
                }
            }
        }

        btn_min.setOnClickListener {
            when(status) {
                1 -> {
                    display1 += ("$display2 ")
                    display2 = "-"
                    status = 2
                    AC2C()
                    setMon()
                }
                3-> {
                    display1 += ("$display2 ")
                    display2 = "-"
                    status = 2
                    AC2C()
                    setMon()
                }
            }
        }

        btn_opp.setOnClickListener {
            if(status==1){
                if(!isNeg){
                    display2= "-$display2"
                    isNeg=true
                }
                else{
                    display2=display2.substring(1)
                    isNeg=false
                }
                mon2.setText(display2)
            }
        }

        btn_per.setOnClickListener {
            when(status){
                1->{
                    display2=(display2.toDouble()/100).toString()
                }
            }
            mon2.setText(display2)
        }

        btn_eql.setOnClickListener {
            when(status) {
                1->{
                    display1+=display2
                    display2=calculator.getResult(display1)
                }
                2->display2=calculator.getResult(display1)
            }
            status=3
            display1=""
            setMon()
        }

        btn_AC.setOnClickListener {
            if(isAc){
                display1=""
                display2="0"
                status=1
            }
            else{
                when(status){
                    1->display2="0"
                    2->{
                        display2=""
                        status--
                    }
                }
                isAc=true
                btn_AC.text = "AC"
            }
            setMon()
        }
    }
}