// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargaUsuario();
  $('#usuarios').DataTable();
});

async function cargaUsuario() {
    const request = await fetch('usuarios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Context-Type': 'application/json'
        }
    });
    const usuarios = await request.json();

    let listadoHTML = '';
    for (let usuario of usuarios) {
        let usuarioHTML = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.email + '</td><td>'
            + usuario.telefono + '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i></a></td></tr>'
        listadoHTML += usuarioHTML;
    }
    document.querySelector('#usuarios tbody').outerHTML = listadoHTML;
}