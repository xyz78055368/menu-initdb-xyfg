function   YYYYMMDDstart() 
{ 

	MonHead   =   [31,   28,   31,   30,   31,   30,   31,   31,   30,   31,   30,   31]; 

	//�ȸ������������� 
	var   y       =   new   Date().getFullYear(); 
	for   (var   i   =   (y-10);   i   <   (y+1);   i++){   //�Խ���Ϊ׼��ǰ30�꣬��30�� 
		document.form1.YYYY.options.add(new   Option( "   "+   i   + "   �� ",   i)); 
//		alert("*********");
	}
	//���·ݵ������� 
	for   (var   i   =   1;   i   <   13;   i++) 
		document.form1.MM.options.add(new   Option( "   "   +   i   +   "   �� ",   i)); 

	document.form1.YYYY.value   =   y; 
	document.form1.MM.value   =   new   Date().getMonth()   +   1; 
	var   n   =   MonHead[new   Date().getMonth()]; 
	if   (new   Date().getMonth()   ==1   &&   IsPinYear(YYYYvalue))   n++; 
	writeDay(n);   //������������Author:meizz 
	document.form1.DD.value   =   new   Date().getDate(); 
} 
function   YYYYDD(str)   //�귢���仯ʱ���ڷ����仯(��Ҫ���ж���ƽ��) 
{ 
	var   MMvalue   =   document.form1.MM.options[document.form1.MM.selectedIndex].value; 
	if   (MMvalue   ==   " "){   var   e   =   document.form1.DD;   optionsClear(e);   return;} 
	var   n   =   MonHead[MMvalue   -   1]; 
	if   (MMvalue   ==2   &&   IsPinYear(str))   n++; 
	writeDay(n) 
} 
function   MMDD(str)     //�·����仯ʱ�������� 
{ 
	var   YYYYvalue   =   document.form1.YYYY.options[document.form1.YYYY.selectedIndex].value; 
	if   (YYYYvalue   ==   " "){   var   e   =   document.form1.DD;   optionsClear(e);   return;} 
	var   n   =   MonHead[str   -   1]; 
	if   (str   ==2   &&   IsPinYear(YYYYvalue))   n++; 
	writeDay(n) 
} 
function   writeDay(n)     //������д���ڵ������� 
{ 
	var   e   =   document.form1.DD;   optionsClear(e); 
	for   (var   i=1;   i <(n+1);   i++) 
		e.options.add(new   Option( "   "+   i   +   "   �� ",   i)); 
} 
function   IsPinYear(year)//�ж��Ƿ���ƽ�� 
{       return(0   ==   year%4   &&   (year%100   !=0   ||   year%400   ==   0));} 
function   optionsClear(e) 
{ 
	e.options.length   =   1; 
} 




function   YYYYMMDDstart1() 
{ 

	MonHead   =   [31,   28,   31,   30,   31,   30,   31,   31,   30,   31,   30,   31]; 

	//�ȸ������������� 
	var   y       =   new   Date().getFullYear(); 
	for   (var   i   =   (y-10);   i   <   (y+1);   i++){   //�Խ���Ϊ׼��ǰ30�꣬��30�� 
		document.form1.YYYY1.options.add(new   Option( "   "+   i   + "   �� ",   i)); 
//		alert("*********");
	}
	//���·ݵ������� 
	for   (var   i   =   1;   i   <   13;   i++) 
		document.form1.MM1.options.add(new   Option( "   "   +   i   +   "   �� ",   i)); 

	document.form1.YYYY1.value   =   y; 
	document.form1.MM1.value   =   new   Date().getMonth()   +   1; 
	var   n   =   MonHead[new   Date().getMonth()]; 
	if   (new   Date().getMonth()   ==1   &&   IsPinYear1(YYYYvalue))   n++; 
	writeDay1(n);   //������������Author:meizz 
	document.form1.DD1.value   =   new   Date().getDate(); 
} 
function   YYYYDD1(str)   //�귢���仯ʱ���ڷ����仯(��Ҫ���ж���ƽ��) 
{ 
	var   MMvalue   =   document.form1.MM1.options[document.form1.MM1.selectedIndex].value; 
	if   (MMvalue   ==   " "){   var   e   =   document.form1.DD1;   optionsClear(e);   return;} 
	var   n   =   MonHead[MMvalue   -   1]; 
	if   (MMvalue   ==2   &&   IsPinYear1(str))   n++; 
	writeDay1(n) 
} 
function   MMDD1(str)     //�·����仯ʱ�������� 
{ 
	var   YYYYvalue   =   document.form1.YYYY1.options[document.form1.YYYY1.selectedIndex].value; 
	if   (YYYYvalue   ==   " "){   var   e   =   document.form1.DD1;   optionsClear(e);   return;} 
	var   n   =   MonHead[str   -   1]; 
	if   (str   ==2   &&   IsPinYear1(YYYYvalue))   n++; 
	writeDay1(n) 
} 
function   writeDay1(n)     //������д���ڵ������� 
{ 
	var   e   =   document.form1.DD1;   optionsClear(e); 
	for   (var   i=1;   i <(n+1);   i++) 
		e.options.add(new   Option( "   "+   i   +   "   �� ",   i)); 
} 
function   IsPinYear1(year)//�ж��Ƿ���ƽ�� 
{       return(0   ==   year%4   &&   (year%100   !=0   ||   year%400   ==   0));} 
function   optionsClear1(e) 
{ 
	e.options.length   =   1; 
} 



///���ʦ������Ϊ��
function check(){
	if(document.form1.YYYY.value==" "){
		alert("��ѡ��ʼ���");
		return false;
	}
	if(document.form1.MM.value==" "){
		alert("��ѡ��ʼ�·�");
		return false;
	}
	if(document.form1.DD.value==" "){
		alert("��ѡ��ʼ����");
		return false;
	}
	if(document.form1.YYYY1.value==" "){
		alert("��ѡ��������");
		return false;
	}
	if(document.form1.MM1.value==" "){
		alert("��ѡ������·�");
		return false;
	}
	if(document.form1.DD1.value==" "){
		alert("��ѡ���������");
		return false;
	}
	return true;
}

function choseCate(){
	if(document.form1.cate.value==" "){
		alert("��ѡ�����");
		return false;
	}
	return true;
}
