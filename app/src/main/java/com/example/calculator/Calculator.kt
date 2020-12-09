package com.example.calculator
import java.util.Stack
import android.util.Log

class Calculator{
    private var numStack=Stack<Double>()
    private var optStack=Stack<String>()

    private fun icp(opt:String):Int{                   //栈外优先数
        return if (opt=="×"||opt=="÷") 3
        else 1
    }

    private fun isp(opt:String):Int{                   //栈内优先数
        return if (opt=="×"||opt=="÷") 4
        else 2
    }

    private fun isOpt(check:String):Boolean{
        return check=="×"||check=="÷"||check=="+"||check=="-"
    }

    private fun calculate(first:Double, opt:String, second:Double):String{
        var result=""
        when(opt){
            "+"-> result=(first+second).toString()
            "-"-> result=(first-second).toString()
            "×"-> result=(first*second).toString()
            "÷"-> {
                if(second==0.0) result="错误"
                else result=(first/second).toString()
            }
        }
        return result
    }

    fun getResult(exp: String):String{
        numStack.clear()
        optStack.clear()
        var i=0
        var temp:String                                        //暂存结果
        var first:Double
        var second:Double
        val token= exp.split(" ")
        val max=token.count()
        while(i<max) {
            if (!isOpt(token[i])) numStack.push(token[i].toDouble())
            else{
                if(optStack.empty()) optStack.push(token[i])
                else {
                    if(icp(token[i])>isp(optStack.peek())){
                        first=numStack.pop()
                        temp=calculate(first,token[i],token[++i].toDouble())
                        Log.d("icp>isp",temp)
                        if(temp=="错误")return temp
                        else numStack.push(temp.toDouble())
                    }
                    else{
                        second=numStack.pop()
                        first=numStack.pop()
                        temp=calculate(first,optStack.pop(),second)
                        Log.d("icp<isp",temp)
                        if(temp=="错误")return temp
                        else {
                            numStack.push(temp.toDouble())
                            optStack.push(token[i])
                        }
                    }
                }
            }
            i++
        }
        if(optStack.empty()) return numStack.pop().toString()
        else{
            second=numStack.pop()
            first=numStack.pop()
            Log.d("calculator","final")
            return calculate(first,optStack.pop(),second)
        }
    }

}