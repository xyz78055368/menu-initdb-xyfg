// JavaScript Document
/**
* js��ҳ��
* @param iAbsolute ÿҳ��ʾ��¼��
* @param sTableId ��ҳ�������IDֵ��ΪString
* @param sTBodyId ��ҳ���TBODY������IDֵ,ΪString,����ΪҪ��ҳ����������
* @Version 1.0.0
* @author ���ֱ� 2007-01-15 created
* var __variable__; private
* function __method__(){};private
*/
function Page(iAbsolute,sTableId,sTBodyId)
{
this.absolute = iAbsolute; //ÿҳ����¼��
this.tableId = sTableId;
this.tBodyId = sTBodyId;
this.rowCount = 0;//��¼��
this.pageCount = 0;//ҳ��
this.pageIndex = 0;//ҳ����
this.__oTable__ = null;//�������
this.__oTBody__ = null;//Ҫ��ҳ����
this.__dataRows__ = 0;//��¼������
this.__oldTBody__ = null;
this.__init__(); //��ʼ��;
};
/*
��ʼ��
*/
Page.prototype.__init__ = function(){
this.__oTable__ = document.getElementById(this.tableId);//��ȡtable����
this.__oTBody__ = this.__oTable__.tBodies[this.tBodyId];//��ȡtBody����
this.__dataRows__ = this.__oTBody__.rows;
this.rowCount = this.__dataRows__.length;
try{
this.absolute = (this.absolute <= 0) || (this.absolute>this.rowCount) ? this.rowCount : this.absolute; 
this.pageCount = parseInt(this.rowCount%this.absolute == 0 
? this.rowCount/this.absolute : this.rowCount/this.absolute+1);
}catch(exception){}

this.__updateTableRows__();
};
/*
��һҳ
*/
Page.prototype.nextPage = function(){
if(this.pageIndex + 1 < this.pageCount){
this.pageIndex += 1;
this.__updateTableRows__();
}
};
/*
��һҳ
*/
Page.prototype.prePage = function(){
if(this.pageIndex >= 1){
this.pageIndex -= 1;
this.__updateTableRows__();
}
};
/*
��ҳ
*/
Page.prototype.firstPage = function(){
if(this.pageIndex != 0){
this.pageIndex = 0;
this.__updateTableRows__();
} 
};
/*
βҳ
*/
Page.prototype.lastPage = function(){
if(this.pageIndex+1 != this.pageCount){
this.pageIndex = this.pageCount - 1;
this.__updateTableRows__();
}
};
/*
ҳ��λ����
*/
Page.prototype.aimPage = function(iPageIndex){
if(iPageIndex > this.pageCount-1){
this.pageIndex = this.pageCount - 1;
}else if(iPageIndex < 0){
this.pageIndex = 0;
}else{
this.pageIndex = iPageIndex;
}
this.__updateTableRows__();
};
/*
ִ�з�ҳʱ��������ʾ�������
*/
Page.prototype.__updateTableRows__ = function(){
var iCurrentRowCount = this.absolute * this.pageIndex;
var iMoreRow = this.absolute+iCurrentRowCount > this.rowCount ? this.absolute+iCurrentRowCount - this.rowCount : 0;
var tempRows = this.__cloneRows__();
//alert(tempRows === this.dataRows);
//alert(this.dataRows.length);
var removedTBody = this.__oTable__.removeChild(this.__oTBody__);
var newTBody = document.createElement("TBODY");
newTBody.setAttribute("id", this.tBodyId);

for(var i=iCurrentRowCount; i < this.absolute+iCurrentRowCount-iMoreRow; i++){
newTBody.appendChild(tempRows[i]);
}
this.__oTable__.appendChild(newTBody);
/*
this.dataRowsΪthis.oTBody��һ�����ã�
�Ƴ�this.oTBody��ôthis.dataRows���ý���ʧ,
code:this.dataRows = tempRows;�ָ�ԭʼ�����м���.
*/
this.__dataRows__ = tempRows;
this.__oTBody__ = newTBody;
//alert(this.dataRows.length);
//alert(this.absolute+iCurrentRowCount);
//alert("tempRows:"+tempRows.length);

};
/*
��¡ԭʼ�����м���
*/
Page.prototype.__cloneRows__ = function(){
var tempRows = [];
for(var i=0; i<this.__dataRows__.length; i++){
/*
code:this.dataRows[i].cloneNode(param), 
param = 1 or true:������ָ���ڵ㷢չ��ȥ�����нڵ�,
param = 0 or false:ֻ��ָ���Ľڵ���������Ա�����.
*/
tempRows[i] = this.__dataRows__[i].cloneNode(1);
}
return tempRows;
};
