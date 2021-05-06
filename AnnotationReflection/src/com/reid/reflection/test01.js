function f(){
    //var万能，可以表示任何类型
    var x = "var a=3; var b=5; alert(a+b)"; //执行完后x的值变成a+b
    //eval用来执行代码
    eval(x);    //JavaScript是动态语言，可以在程序运行时改变某些自身结构
                // 如：改变x的值：由String变为int
}

f();