// Ejecuta tres funciones
$(document).ready(function() {
    //Petición GET a la API para obtener la lista de usuarios y mostrarla en una tabla
    cargaUsuarios();
    $('#usuarios').DataTable();
    //Aparece arriba a la derecha el correo del usuario logueado
    actualizarEmailDelUsuario();
});

//Función que obtiene el elemento con id 'txt-email-usuario' y lo guarda en el localStorage como el valor de email
function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

//Función que carga los usuarios
async function cargaUsuarios() {
    //Obtenemos los usuarios
    const response = await fetch('api/usuarios', {
        method: 'GET',
        headers: getHeaders()
    });
    //Guardamos los usuarios como json
    const usuarios = await request.json();

    //Listado HTML con la info de cada usuario que después usamos para formar la tabla
    let listadoHTML = '';
    //Por cada usuario
    for (let usuario of usuarios) {
        let botonEliminar = '<a href="#" onclick = "eliminarUsuario ('+ usuario.id +')" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i></a>'
        //Si no hay teléfono muestra un guión
        let telefono = usuario.telefono == null ? '-': usuario.telefono;
        //En esta variable se guarda la fila de la tabla del usuario con su info y el botón de eliminar
        let usuarioHTML = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>'
        + usuario.email + '</td><td>' + telefono + '</td><td>' + botonEliminar +'</td></tr>'
        //El usuarioHTML se agrega a listadoHTML
        listadoHTML += usuarioHTML;
    }
    //La lista de usuariosHTML se agrega y pinta en la tabla
    document.querySelector('#usuarios tbody').outerHTML = listadoHTML;
}

//Función para ahorrarse escribir los headers todo el rato
function getHeaders() {
    return {
        'Accept': 'application/json',
        'Context-Type': 'application/json',
        'Authorization': localStorage.token
    };
}
/*Función que te pregunta si quieres eliminar el usuario y si lo confirmas
  hace una petición DELETE a la API para eliminar al usuario con el id indicado*/
async function eliminarUsuario(id) {
    if (!confirm('¿Desea eliminar este usuario?')){
        return;
    }

    const request = await fetch('api/usuarios/' + id, {
            method: 'DELETE',
            headers: getHeaders()
    });
    //Recarga la página para que se vea el cambio
    location.reload()
}