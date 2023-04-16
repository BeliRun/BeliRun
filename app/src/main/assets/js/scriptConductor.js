function agregarConductor() {
  let nombres = document.getElementById("nombre").value;
  let apellidos = document.getElementById("apellido").value;
  let telefono = document.getElementById("telefono").value;

  Android.AgregarConductor(nombres, apellidos, telefono);
  window.location.href = "file:///android_asset/Conductores.html";
}

function BuscarConductor() {
  let search = document.getElementById("search");
  Android.buscarConductor(search.value);
}

function actualizarConductor() {
  let modal = {
    "nombres": document.getElementById("nombreEditar").value,
    "apellidos": document.getElementById("apellidoEditar").value,
    "telefono": document.getElementById("telefonoEditar").value
  };
  Android.EditarConductor(modal.nombres, modal.apellidos, modal.telefono);
  window.location.href = "file:///android_asset/Conductores.html";
}

function mostrarDatos(conductor) {
  let modal = {
    "nombres": document.getElementById("nombreEditar"),
    "apellidos": document.getElementById("apellidoEditar"),
    "telefono": document.getElementById("telefonoEditar"),
    "vehiculo": document.getElementById("numero"),
  };

  // Asigna los valores correspondientes a los campos del formulario
  modal.nombres.value = conductor.nombres;
  modal.apellidos.value = conductor.apellidos;
  modal.telefono.value = conductor.telefono;
  modal.vehiculo.value = conductor.vehiculoId;
}

function eliminarConductor(telefono) {
  let eliminarDato = document.getElementById("eliminarDato");
  eliminarDato.onclick = function () {
    Android.EliminarConductor(telefono);
    window.location.href = "file:///android_asset/Conductores.html";
  };
}

function mostrarBusetica(Conductores) {
  let selectVehiculos = document.querySelector('#numeroEditar select');
  selectVehiculos.innerHTML = '';
  let opciones = '';
  if (Conductores) {
    Conductores.forEach(conductor => {
      opciones += `<option value="${conductor.vehiculoId}">${conductor.vehiculoId}</option>`;
    });
    selectVehiculos.innerHTML = opciones;
  }
}



function mostrarConductor(Conductores) {
  let tablaConductores = document.getElementById("tablaConductores");
  tablaConductores.innerHTML = "";
  let raw = "";
  if (Conductores) {
    Conductores.forEach(Conductor => {
      raw = `
          <tr>
            <td>${Conductor.nombres}</td>
            <td>${Conductor.apellidos}</td>
            <td>${Conductor.telefono}</td>
            <td>${Conductor.vehiculoId}</td>
            <td>
              <button id="${Conductor.telefono}" onclick="Android.ObtenerDatosConductor(this.id);" type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editarModal">
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

