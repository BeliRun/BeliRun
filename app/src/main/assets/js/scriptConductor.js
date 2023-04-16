function agregarConductor() {
  let nombres = document.getElementById("nombre").value;
  let apellidos = document.getElementById("apellido").value;
  let telefono = document.getElementById("telefono").value;
  let vehiculo = document.getElementById("numeroSeleccionado").value;

  Android.AgregarConductor(nombres, apellidos, telefono, parseInt(vehiculo));
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
    "telefono": document.getElementById("telefonoEditar").value,
    "vehiculo": document.getElementById("numeroSeleccionadoEditar").value,
  };
  Android.EditarConductor(modal.nombres, modal.apellidos, modal.telefono, parseInt(modal.vehiculo));
  window.location.href = "file:///android_asset/Conductores.html";
}

function mostrarDatos(datos) {
  let modal = {
    "nombres": document.getElementById("nombreEditar"),
    "apellidos": document.getElementById("apellidoEditar"),
    "telefono": document.getElementById("telefonoEditar"),
    "vehiculo": document.getElementById("numeroSeleccionadoEditar"),
  };

  // Asigna los valores correspondientes a los campos del formulario
  modal.nombres.value = datos.conductores[0].nombres;
  modal.apellidos.value = datos.conductores[0].apellidos;
  modal.telefono.value = datos.conductores[0].telefono;
  modal.vehiculo.value = datos.vehiculo.vehiculoId;
}

function eliminarConductor(telefono) {
  let eliminarDato = document.getElementById("eliminarDato");
  eliminarDato.onclick = function () {
    Android.EliminarConductor(telefono);
    window.location.href = "file:///android_asset/Conductores.html";
  };
}


function mostrarBusetica(vehiculos, esEditar) {
  let selectVehiculos;
  if (esEditar) {
    selectVehiculos = document.getElementById("numeroSeleccionadoEditar");
  } else {
    selectVehiculos = document.getElementById("numeroSeleccionado");
  }
  selectVehiculos.innerHTML = '';
  let opciones = '';
  if (vehiculos!=null) {
    vehiculos.forEach(vehiculo => {
      opciones += `<option value="${vehiculo.vehiculoId}">${vehiculo.numero}</option>`;
    });
    selectVehiculos.innerHTML = opciones;
  }else{
    Android.showToast("tamos mal")
  } 
}

function mostrarConductor(datos) {
  let tablaConductores = document.getElementById("tablaConductores");
  tablaConductores.innerHTML = "";
  let raw = "";
  if (datos) {
    datos.forEach(dato => {
      raw = `
          <tr>
            <td>${dato.conductores[0].nombres}</td>
            <td>${dato.conductores[0].apellidos}</td>
            <td>${dato.conductores[0].telefono}</td>
            <td>${dato.vehiculo.placa}</td>
            <td>
              <button id="${dato.conductores[0].telefono}" onclick="Android.ObtenerVehiculo(true); Android.ObtenerDatosConductor(this.id);" type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editarModal">
              <i class="fas fa-edit"></i>
              </button>
              <button id="${dato.conductores[0].telefono}" onclick="eliminarConductor(this.id)" type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#eliminarModal">
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

