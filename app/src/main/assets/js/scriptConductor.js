function agregarConductor() {
    let nombre = document.getElementById("nombre").value;
    let apellido = document.getElementById("apellido").value;
    let telefono = document.getElementById("telefono").value;
  
    Android.AgregarConductor(nombre, apellido, telefono);
    window.location.href = "file:///android_asset/Conductores.html";
  }
  
  function BuscarConductor() {
    let search = document.getElementById("search");
    Android.buscarConductor(search.value);
  }
  
  function actualizarVehiculo() {
    let modal = {
      "nombre": document.getElementById("nombreEditar").value,
      "apellido": document.getElementById("apellidoEditar").value,
      "telefono": document.getElementById("telefonoEditar").value
    };
    Android.EditarConductor(modal.nombre, modal.apellido, modal.telefono);
    window.location.href = "file:///android_asset/Conductores.html";
  }
  
  function mostrarDatos(conductor) {
    let modal = {
      "nombre": document.getElementById("nombreEditar"),
      "apellido": document.getElementById("apellidoEditar"),
      "telefono": document.getElementById("telefonoEditar")
    };
  
    // Asigna los valores correspondientes a los campos del formulario
    modal.placa.value = conductor.placa;
    modal.numeroInterno.value = conductor.numero;
    modal.marca.value = conductor.marca;
  }
  
  function eliminarConductor(telefono) {
    let eliminarDato = document.getElementById("eliminarDato");
    eliminarDato.onclick = function () {
      Android.EliminarConductor(telefono);
      window.location.href = "file:///android_asset/Conductores.html";
    };
  }
  
  function mostrarConductor(Conductores) {
    let tablaConductores = document.getElementById("tablaConductores");
    tablaConductores.innerHTML = "";
    let raw = "";
    if (Conductores) {
        Conductores.forEach(Conductor => {
        raw = `
          <tr>
            <td>${Conductor.nombre}</td>
            <td>${Conductor.apellido}</td>
            <td>${Conductor.telefono}</td>
            <td>
              <button id="${Conductor.telefono}" onclick="Android.ObtenerDatos(this.id);" type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editarModal">
                <i class="fas fa-edit"></i>
              </button>
              <button id="${Conductor.telefono}" onclick="eliminarConductor(this.id)" type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#eliminarModal">
                <i class="fas fa-trash"></i>
              </button>
            </td>
          </tr>
        `;
        tablaConductores.innerHTML += raw;
      });
    }
  }
  
  Android.MostrarConductor();
  
  