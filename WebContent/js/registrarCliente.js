console.log("HOLA MUNDO")

const botonRegistrar=document.getElementById("botonRegistrar");

const nombre=document.getElementById("nombre");
const apellido=document.getElementById("apellido");

const telefono=document.getElementById("telefono");
const direccion=document.getElementById("direccion");
const usuario=document.getElementById("usuario");
const correo=document.getElementById("correo");
const contrasena=document.getElementById("contrasena");
const confirmar=document.getElementById("confirmar");

const formulario=document.getElementById("formulario");
const vacio="";



formulario.addEventListener("submit",(e)=>{

	
	
	if(!nombre.value.trim()||!apellido.value.trim()||!telefono.value.trim()||!direccion.value.trim()
	||!usuario.value.trim()||!contrasena.value.trim()||!confirmar.value.trim()){
		Swal.fire({
  icon: 'error',
  title: 'Datos incompletos',
  text: 'Complete sus datos porfavor',
  footer: '<a href="">Complete sus datos porfavor</a>'
})
e.preventDefault();
		return;
	}else if(contrasena.value!==confirmar.value){
				Swal.fire({
  icon: 'error',
  title: 'Contraseñas diferentes',
  text: 'Las contraseñas deben ser iguales',
  footer: '<a href="">Las contraseñas deben ser iguales</a>'
  
})
e.preventDefault();
return;
	}
	else{
		

		
							Swal.fire({
  position: 'center',
  icon: 'success',
  title: 'Registrado Correctamente',
  showConfirmButton: false,
  timer: 3000
  
})
		
		
	
	

		
			
	}

	

			


})

