/*Función que se ejecuta cuando se ha cargado el DOM.
  Vincula la función 'iniciarSesion()' al evento click del botón de inicio de sesión*/
$(document).ready(function() {
});
//Cuando se pulsa el botón de registrar usuario se ejecuta esta función
async function registrarUsuario() {
    //Objeto vacío que se usa para almacenar los datos del nuevo usuario
    let datos = {};

    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    //Obtenemos el valor del txtRepetirPassword y miramos si coincide con el Password
    let repetirPassword = document.getElementById('txtRepetirPassword').value;
    if (repetirPassword != datos.password) {
        //Muestra este mensaje si no son iguales
        alert('La contraseña no coincide');
        return;
    }
    //Solicitud POST a la API con fetch
    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body:JSON.stringify(datos)
      });
      //Recarga la página
      location.reload();
}