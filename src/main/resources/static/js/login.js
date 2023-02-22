/*Función que se ejecuta cuando se ha cargado el DOM.
  Vincula la función 'iniciarSesion()' al evento click del botón de inicio de sesión*/
$(document).ready(function() {
});
//Función que realiza la solicitud POST a la API de inicio de sesión
async function iniciarSesion() {
    //Definimos un objeto vacío que usamos para almacenar el correo y la contraseña ingresada por el usuario
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    //Solicitud POST a la API de inicio de sesión utilizando la función fetch
    const response = await fetch('api/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body:JSON.stringify(datos)
    });
    //Cuando la respuesta de la API se completa se almacena en la constante respuesta en forma de json
    const respuesta = await response.json();
        //Si en la respuesta no sale 'FAIL' almacena el token y el email en el localStorage
        if (respuesta != 'FAIL') {
            localStorage.token = respuesta;
            localStorage.email = datos.email;
            window.location.href = 'usuarios.html';
        }
        //Si sale, salta esta alerta
        else alert(' Credenciales erróneas, intente de nuevo');
}