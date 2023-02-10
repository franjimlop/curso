// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargaUsuario();
  $('#usuarios').DataTable();
});

async function cargaUsuario() {
    const request = await fetch('usuario/2312', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Context-Type': 'application/json'
        }
    });
    const usuarios = await request.json();
    console.log(usuarios);
}