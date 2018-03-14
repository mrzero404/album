<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html> 
<head> 
	<title></title> 
	<script type="text/javascript" src="js/jquery.js"></script> 
	<link rel="stylesheet" type="text/css" href="styles.css" />
    <link rel="stylesheet" type="text/css" href="demo.css"  />
</head> 

<body>
<form>
是否加入复习计划
<br/>
<br/>
<input id="yes" type="radio" name="select" value="yes" />是
<input type="radio" name="select" value="no" checked/>否
</form> 

<input type="text"  id="te" >
<input type="button" id="btn1" value="开始计时"  onclick="settime(this)" /> 
<p id="p"></p>

<script type="text/javascript"> 
var startTime = null;
var finishTime = null;
var onOff = true;
var btn =document.getElementById("btn");
var btn1 =document.getElementById("btn1");

function settime(val) { 
	if(onOff == true){
		onOff = false;
		startTime = new Date();
		timer(val);
	}else{
		onOff = true;
		send();
	}
} 

function send() {
	var toplan;
	var txt = document.getElementById("te").value;
	if(document.getElementById("yes").checked){
		toplan = '1';
	} else {
		toplan = '0';
	}
	startTime=timeFormat(startTime);
	finishTime=timeFormat(finishTime);
	window.location="tomato_save?sttime="+startTime+"&fitime="+finishTime+"&name="+txt+"&plan="+toplan;
}


/*计时器*/
function timer(val){
	//用于在指定的毫秒数后调用函数或计算表达式 
	setTimeout(function() { 
	//修改按钮文字 		
	val.value="提交(" + timeDifference(startTime) + ")"; 
	timer(val);
	},1000) 
}
function timeDifference(startTime) {
	var date1=startTime;  //开始时间
	finishTime = new Date(); //结束时间
	var date3 = finishTime.getTime()-date1.getTime()  //时间差的毫秒数
	//计算出相差天数
	var days=Math.floor(date3/(24*3600*1000))
	//计算出小时数
	var leave1=date3%(24*3600*1000)    //计算天数后剩余的毫秒数
	var hours=Math.floor(leave1/(3600*1000))
	//计算相差分钟数
	var leave2=leave1%(3600*1000)        //计算小时数后剩余的毫秒数
	var minutes=Math.floor(leave2/(60*1000))
	//计算相差秒数
	var leave3=leave2%(60*1000)      //计算分钟数后剩余的毫秒数
	var seconds=Math.round(leave3/1000)
	var timeDifference = days+"天"+hours+"小时"+minutes+"分钟"+seconds+"秒";
	return timeDifference;
}
//时间格式转化
function timeFormat(myDate){
	var date = myDate.getFullYear() + "-" + myDate.getMonth() + "-" + myDate.getDate();
	var time = myDate.getHours() + ":" + myDate.getMinutes() + ":" + myDate.getSeconds();
	return date + " " + time;
}		
</script>
今天已完成的任务：</br>
<div id="fdw-pricing-table">
<c:forEach var="fitomato" items="${fitomatos}">
${fitomato.name} &nbsp; ${fitomato.startTime} &nbsp; ${fitomato.finishTime} </br>
</c:forEach> 
</br>

今天需要复习的任务：
<c:forEach var="plans" items="${plans}">
 ${plans} &nbsp;
</c:forEach>
</div>
</body> 
</html> 