$(document).ready(function() {
});

async function RegistrarUsuario() {
    let datos = {};

    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let RepetirPassword = document.getElementById('txtRepetirPassword').value;
    if (RepetirPassword != datos.password) {
        alert('La contraseña no coincide');
        return;
    }

    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Context-Type': 'application/json'
        }
        body: JSON.stringify(datos)
    });
    const usuarios = await request.json();

}
