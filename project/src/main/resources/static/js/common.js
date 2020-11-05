/*水平导航工具栏js*/
function showsub(li){
	var submenu=li.getElementsByTagName("ul")[0];  /*这里的ul是内侧的ul*/
	submenu.style.display="block";
}
function hidesub(li){
	var submenu=li.getElementsByTagName("ul")[0];
	submenu.style.display="none";
}
/*左侧导航工具栏js 点击打开再点击关闭*/
/*$(document).ready(function(){
	$(".clickmenu").click(function(){
	    $(this).next("dl").slideToggle();实现二级菜单的展开收缩功能
	})
})*/
/*$(document).ready(function(){
	$(".clickmenu").click(function(){
		let x= $(this).next();
        if(x.is(":hidden")){
            x.show();
        }else{
            x.hide();
        } 
    })    
})*/

