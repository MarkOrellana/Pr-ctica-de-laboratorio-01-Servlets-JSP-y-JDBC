/**
 * 
 */
window.addEventListener('load',function(){
	document.getElementById('btninicio').addEventListener('click',function(){
		var nombre=document.getElementById('txtcorreo').value;
		var contrasena=document.getElementById('txtcontra').value;
		var bandera=false;
		if(nombre.length>0&&contrasena.length>0){
			bandera=true;
		}
		if(bandera){
			document.getElementById('forminicio').submit();
		}else{
			alert('Por rellene todo los campos');
		}
	});
});