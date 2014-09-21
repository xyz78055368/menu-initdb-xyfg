
function changeBg(id){
	var doc1 = document.getElementById("demo1");
	var doc2 = document.getElementById("demo2");
	var doc3 = document.getElementById("demo3");
	var doc4 = document.getElementById("demo4");
	var e=document.getElementById("xyz");
	e.src = "baobiao/"+id+".jsp";
	if(id == "dishhits"){
		doc1.style.backgroundImage = "url(images/h02.jpg)";
		doc2.style.backgroundImage = "url(images/h01.jpg)";
		doc3.style.backgroundImage = "url(images/h01.jpg)";
		doc4.style.backgroundImage = "url(images/h01.jpg)";
	}
	if(id == "dishcatehits"){
		doc1.style.backgroundImage = "url(images/h01.jpg)";
		doc2.style.backgroundImage = "url(images/h02.jpg)";
		doc3.style.backgroundImage = "url(images/h01.jpg)";
		doc4.style.backgroundImage = "url(images/h01.jpg)";
	}
	if(id == "dianjilv"){
		doc1.style.backgroundImage = "url(images/h01.jpg)";
		doc2.style.backgroundImage = "url(images/h01.jpg)";
		doc3.style.backgroundImage = "url(images/h02.jpg)";
		doc4.style.backgroundImage = "url(images/h01.jpg)";
	}

}   
function shuaxinpic(){
	var doc4 = document.getElementById("demo4");
	doc4.style.backgroundImage = "url(images/h01.jpg)";
}
function shuaxin(){
	xyz.window.location.reload();
	document.getElementById("demo4").style.backgroundImage = "url(images/h02.jpg)";
	setTimeout("shuaxinpic()",800);
}
