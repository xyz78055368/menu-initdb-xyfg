function   YYYYMMDDstart() 
{ 

	MonHead   =   [31,   28,   31,   30,   31,   30,   31,   31,   30,   31,   30,   31]; 

	//先给年下拉框赋内容 
	var   y       =   new   Date().getFullYear(); 
	for   (var   i   =   (y-10);   i   <   (y+1);   i++){   //以今年为准，前30年，后30年 
		document.form1.YYYY.options.add(new   Option( "   "+   i   + "   年 ",   i)); 
//		alert("*********");
	}
	//赋月份的下拉框 
	for   (var   i   =   1;   i   <   13;   i++) 
		document.form1.MM.options.add(new   Option( "   "   +   i   +   "   月 ",   i)); 

	document.form1.YYYY.value   =   y; 
	document.form1.MM.value   =   new   Date().getMonth()   +   1; 
	var   n   =   MonHead[new   Date().getMonth()]; 
	if   (new   Date().getMonth()   ==1   &&   IsPinYear(YYYYvalue))   n++; 
	writeDay(n);   //赋日期下拉框Author:meizz 
	document.form1.DD.value   =   new   Date().getDate(); 
} 
function   YYYYDD(str)   //年发生变化时日期发生变化(主要是判断闰平年) 
{ 
	var   MMvalue   =   document.form1.MM.options[document.form1.MM.selectedIndex].value; 
	if   (MMvalue   ==   " "){   var   e   =   document.form1.DD;   optionsClear(e);   return;} 
	var   n   =   MonHead[MMvalue   -   1]; 
	if   (MMvalue   ==2   &&   IsPinYear(str))   n++; 
	writeDay(n) 
} 
function   MMDD(str)     //月发生变化时日期联动 
{ 
	var   YYYYvalue   =   document.form1.YYYY.options[document.form1.YYYY.selectedIndex].value; 
	if   (YYYYvalue   ==   " "){   var   e   =   document.form1.DD;   optionsClear(e);   return;} 
	var   n   =   MonHead[str   -   1]; 
	if   (str   ==2   &&   IsPinYear(YYYYvalue))   n++; 
	writeDay(n) 
} 
function   writeDay(n)     //据条件写日期的下拉框 
{ 
	var   e   =   document.form1.DD;   optionsClear(e); 
	for   (var   i=1;   i <(n+1);   i++) 
		e.options.add(new   Option( "   "+   i   +   "   日 ",   i)); 
} 
function   IsPinYear(year)//判断是否闰平年 
{       return(0   ==   year%4   &&   (year%100   !=0   ||   year%400   ==   0));} 
function   optionsClear(e) 
{ 
	e.options.length   =   1; 
} 




function   YYYYMMDDstart1() 
{ 

	MonHead   =   [31,   28,   31,   30,   31,   30,   31,   31,   30,   31,   30,   31]; 

	//先给年下拉框赋内容 
	var   y       =   new   Date().getFullYear(); 
	for   (var   i   =   (y-10);   i   <   (y+1);   i++){   //以今年为准，前30年，后30年 
		document.form1.YYYY1.options.add(new   Option( "   "+   i   + "   年 ",   i)); 
//		alert("*********");
	}
	//赋月份的下拉框 
	for   (var   i   =   1;   i   <   13;   i++) 
		document.form1.MM1.options.add(new   Option( "   "   +   i   +   "   月 ",   i)); 

	document.form1.YYYY1.value   =   y; 
	document.form1.MM1.value   =   new   Date().getMonth()   +   1; 
	var   n   =   MonHead[new   Date().getMonth()]; 
	if   (new   Date().getMonth()   ==1   &&   IsPinYear1(YYYYvalue))   n++; 
	writeDay1(n);   //赋日期下拉框Author:meizz 
	document.form1.DD1.value   =   new   Date().getDate(); 
} 
function   YYYYDD1(str)   //年发生变化时日期发生变化(主要是判断闰平年) 
{ 
	var   MMvalue   =   document.form1.MM1.options[document.form1.MM1.selectedIndex].value; 
	if   (MMvalue   ==   " "){   var   e   =   document.form1.DD1;   optionsClear(e);   return;} 
	var   n   =   MonHead[MMvalue   -   1]; 
	if   (MMvalue   ==2   &&   IsPinYear1(str))   n++; 
	writeDay1(n) 
} 
function   MMDD1(str)     //月发生变化时日期联动 
{ 
	var   YYYYvalue   =   document.form1.YYYY1.options[document.form1.YYYY1.selectedIndex].value; 
	if   (YYYYvalue   ==   " "){   var   e   =   document.form1.DD1;   optionsClear(e);   return;} 
	var   n   =   MonHead[str   -   1]; 
	if   (str   ==2   &&   IsPinYear1(YYYYvalue))   n++; 
	writeDay1(n) 
} 
function   writeDay1(n)     //据条件写日期的下拉框 
{ 
	var   e   =   document.form1.DD1;   optionsClear(e); 
	for   (var   i=1;   i <(n+1);   i++) 
		e.options.add(new   Option( "   "+   i   +   "   日 ",   i)); 
} 
function   IsPinYear1(year)//判断是否闰平年 
{       return(0   ==   year%4   &&   (year%100   !=0   ||   year%400   ==   0));} 
function   optionsClear1(e) 
{ 
	e.options.length   =   1; 
} 



///检查师傅输入为空
function check(){
	if(document.form1.YYYY.value==" "){
		alert("请选择开始年份");
		return false;
	}
	if(document.form1.MM.value==" "){
		alert("请选择开始月份");
		return false;
	}
	if(document.form1.DD.value==" "){
		alert("请选择开始日期");
		return false;
	}
	if(document.form1.YYYY1.value==" "){
		alert("请选择结束年份");
		return false;
	}
	if(document.form1.MM1.value==" "){
		alert("请选择结束月份");
		return false;
	}
	if(document.form1.DD1.value==" "){
		alert("请选择结束日期");
		return false;
	}
	return true;
}

function choseCate(){
	if(document.form1.cate.value==" "){
		alert("请选择菜类");
		return false;
	}
	return true;
}
