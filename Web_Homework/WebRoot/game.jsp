<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'game.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script src="jquery-3.3.1.js"></script>
  <style>
    #d0 div {
        display: inline-block;
        float: left;
    }

    body {
        padding: 0px;
        background-color: gainsboro;
    }

    #d0 {
        margin: 0 auto;
        width: 60%;
    }

    #d2 {
        width: 250px;
        height: 450px;
        border-radius: 20px;
        border: white solid 2px;
        text-align: center;
        position: fixed;
        right: 10%;
        top: 10%;
        background-color: grey;
        color: white;
    }

    button {
        margin-top: 20%;
        text-align: center;
        width: 150px;
        letter-spacing: 2em;
        text-indent: 2em;
        margin-bottom: 10%;


    }

    .score {
        width: 200px;
        height: 100px;
        border-radius: 10px;
        border: white solid 2px;
        text-align: center;
        line-height: 100px;
        font-size: 50px;
        margin-left: 12%;
    }

    #d0 > p {
        text-indent: 8em;
        line-height: 10px;
    }

    .p1 {
        font-size: 30px;
        line-height: 30px;
        text-indent: 1.5em;

    }

    .p2 {
        font-size: 5px;
        text-indent: 0.6em;
    }
    input{
        margin-bottom: 50px;
    }
	.d4{
	padding-left:10px;
	}
</style>
<body>
<div id="d0">
    <p>贪食蛇（请使用 上、下、左、右键或者 W、S、A、D控制方向）</p>
    <div id="d1">
    </div>
    <div id="d2">
        <button>开始</button>
        <div class="d3">
            <p class="p1">分数</p>
            <div class="score">0</div>
        </div>
        <div class="d4">
            <p class="p2">请拖动滑块改变游戏窗口大小（默认500px）</p>
            小<input class="size" type="range" min=100 max=700 value=600 step=10>大
            <p class="p2">请拖动滑块改变块数（默认10）</p>
            少<input class="num" type="range" min=6 max=100 value=10 step=1>多
            <p class="p2">请拖动滑块改变移动速度（默认500ms）</p>
            快<input class="speed" type="range" min=10 max=1000 value=500 step=10>慢


        </div>

    </div>
</div>


<script>
    $(function () {
        load();
        set();
    });

    var size = $(".size").val();
    var speed = $(".speed").val();
    var num = $(".num").val();

    function set() {
        $(".size").mousemove(function () {
            size = $(".size").val();
            load();
        });
        $(".num").mousemove(function () {
            num = $(".num").val();
            load();
        });
        $(".speed").mousemove(function () {
            speed = $(".speed").val();
            load();
        });


    }

    function load() {
        $(".d3").hide();
        $("#d1").css({"width": size + "px", "height": size + "px", "background": "black"});
        var str = "";
        for (var i = 0; i < num; i++) {
            for (var j = 0; j < num; j++) {
                str += "<div class=\"d" + i + "_" + j + "\"></div>";
            }
        }
        $("#d1").html("");
        $("#d1").append(str);
        $("#d1 div").css({
            "width": size / num + "px",
            "height": size / num + "px",
            "background": "black"
        });
        $("button").html("开始").unbind().click(function () {
            start();
        })
    }

    var x1 = "5", y1 = "5";
    var x2 = "4", y2 = "5";
    var x3 = "3", y3 = "5";
    var x4 = "2", y4 = "5";

    var m = 1, n = 0;

    var arr = [y1 + "_" + x1, y2 + "_" + x2, y3 + "_" + x3, y4 + "_" + x4];

    var time;
    var flag = false;


    function start() {
        $(".d3").show();
        $(".d4").hide();
        $("button").html("暂停").unbind().click(function () {
            pause();
        })

        $(".d" + arr[0]).css("background", "white");
        $(".d" + arr[1]).css("background", "white");
        $(".d" + arr[2]).css("background", "white");
        $(".d" + arr[3]).css("background", "white");
        food();
        startMove();
    }

    function pause() {
        alert("已暂停，点击确定继续");
    }

    function startMove() {
        time = setInterval("move()", speed);
    }

    var position = "";
    var score = 0;

    function move() {
        flag = true;
        var xy = arr[0].split("_");
        var y = xy[0] - 0 + n;
        var x = xy[1] - 0 + m;
        if (x == num || y == num || x < 0 || y < 0) {
            gameOver();
        }
        var head = (y + "_" + x);
        if (arr.indexOf(head) != -1) {
            gameOver();
        }

        arr.unshift(head);
        $(".d" + arr[0]).css("background", "white");
        if (head == position) {
            score++;
            $(".score").html(score);
            food();
            return;
        }
        $(".d" + arr.pop()).css("background", "black");
    }


    $(document).keydown(function (e) {
            // console.log(flag);
            if (!flag) {
                return;
            }
            switch (e.keyCode) {
                case 37:
                case 65:
                    flag = false;
                    console.log("m:" + m + " n:" + n);//按键后依然打印？？？
                    // alert("左");
                    if (m) {
                        break;
                    }
                    m = -1;
                    n = 0;
                    break;

                case 38:
                case 87:
                    flag = false;
                    console.log("m:" + m + " n:" + n);
                    // alert("上");
                    if (n) {
                        break;
                    }
                    m = 0;
                    n = -1;
                    break;

                case 39:
                case 68:
                    console.log("m:" + m + " n:" + n);
                    // alert("右")
                    if (m) {
                        break;
                    }
                    m = 1;
                    n = 0;
                    break;

                case 40:
                case 83:
                    flag = false;
                    console.log("m:" + m + " n:" + n);
                    // alert("下");
                    if (n) {
                        break;
                    }
                    m = 0;
                    n = 1;
                    break;
            }
        }
    );

    function food() {
        do {
            var y = Math.floor(Math.random() * num);
            var x = Math.floor(Math.random() * num);
            position = y + "_" + x
        } while (arr.indexOf(position) != -1);
        $(".d" + position).css("background", "red");
        return position;

    }

    function gameOver() {
        clearInterval(time);
        alert("游戏结束，最终得分：" + score);
        $("button").html("重新开始").unbind().click(function () {
            location.reload();
        }).css({"letter-spacing": "1em", "text-indent": "1em"});
    }
</script>
  </body>
</html>
