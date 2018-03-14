<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html> 
<head> 
	<title></title> 
	<style type="text/css">
		table.hovertable {
			font-family: verdana,arial,sans-serif;
			font-size:11px;
			color:#333333;
			border-width: 1px;
			border-color: #999999;
			border-collapse: collapse;
		}
		table.hovertable th {
			background-color:#c3dde0;
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #a9c6c9;
		}
		table.hovertable tr {
			background-color:#d4e3e5;
		}
		table.hovertable td {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #a9c6c9;
		}
	</style>
	<script type="text/javascript" src="js/jquery.js"></script> 
	<link rel="stylesheet" type="text/css" href="styles.css" />
    <link rel="stylesheet" type="text/css" href="demo.css"  />
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"61964",secure:"61969"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head> 

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/mytime/src/main/WebRoot/WEB-INF/jsp/time.jsp">
<form data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/mytime/src/main/WebRoot/WEB-INF/jsp/time.jsp">
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
var take = null;
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
	take=timeDifference(startTime);
	startTime=timeFormat(startTime);
	finishTime=timeFormat(finishTime);
	window.location="tomato_save?startTime="+startTime+"&finishTime="+finishTime+"&name="+txt+"&take="+take+"&plan="+toplan;
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
	var timeDifference = null;
	if(days>0) timeDifference = days+"天";
	if(hours>0) timeDifference = timeDifference + hours+"小时";
	if(minutes>0) timeDifference = timeDifference + minutes+"分钟";
	timeDifference = timeDifference + seconds+"秒";
	
	return timeDifference;
}
//时间格式转化
function timeFormat(myDate){
	var month = myDate.getMonth()+1;
	var date = myDate.getFullYear() + "-" + month + "-" + myDate.getDate();
	var time = myDate.getHours() + ":" + myDate.getMinutes() + ":" + myDate.getSeconds();
	return date + " " + time;
}		
</script>
今天已完成的任务：</br>
<div id="fdw-pricing-table">
<table class="hovertable">
	<tr>
		<th>任务</th>
		<th>历时</th>
		<th>开始时间</th>
		<th>结束时间</th>
	</tr>	
<c:forEach var="fitomato" items="${fitomatos}">	
	<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
		<td>${fitomato.name}</td>
		<td>${fitomato.take}</td>
		<td>${fitomato.startTime}</td>
		<td>${fitomato.finishTime}</td>
	</tr>	
</c:forEach> 
</table>

</br>

今天需要复习的任务：
<c:forEach var="plans" items="${plans}">
 ${plans} &nbsp;
</c:forEach>
</div>
</body> 
</html> 