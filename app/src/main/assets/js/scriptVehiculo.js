function agregarAutomovil() {
  let placa = document.getElementById("placa").value;
  let numeroInterno = document.getElementById("numeroInterno").value;
  let marca = document.getElementById("marca").value;

  Android.AgregarVehiculo(placa, marca, numeroInterno);
  window.location.href = "file:///android_asset/Vehiculos.html";
}

function buscarVehiculo() {
  let search = document.getElementById("search");
  Android.BuscarVehiculo(search.value);
}

function actualizarVehiculo() {
  let modal = {
    "placa": document.getElementById("placaEditar").value,
    "numeroInterno": document.getElementById("numeroInternoEditar").value,
    "marca": document.getElementById("marcaEditar").value
  };
  Android.EditarVehiculo(modal.placa, modal.marca, modal.numeroInterno);
  window.location.href = "file:///android_asset/Vehiculos.html";
}

function mostrarDatos(vehiculo) {
  let modal = {
    "placa": document.getElementById("placaEditar"),
    "numeroInterno": document.getElementById("numeroInternoEditar"),
    "marca": document.getElementById("marcaEditar")
  };

  // Asigna los valores correspondientes a los campos del formulario
  modal.placa.value = vehiculo.placa;
  modal.numeroInterno.value = vehiculo.numero;
  modal.marca.value = vehiculo.marca;
}

function eliminarVehiculo(placa) {
  let eliminarDato = document.getElementById("eliminarDato");
  eliminarDato.onclick = function () {
    Android.EliminarVehiculo(placa);
    window.location.href = "file:///android_asset/Vehiculos.html";
  };
}

function mostrarVehiculo(vehiculos) {
  let tablaAutomoviles = document.getElementById("tablaAutomoviles");
  tablaAutomoviles.innerHTML = "";
  let raw = "";
  if (vehiculos) {
    vehiculos.forEach(vehiculo => {
      raw = `
        <tr>
          <td>${vehiculo.placa}</td>
          <td>${vehiculo.numero}</td>
          <td>${vehiculo.marca}</td>
          <td>
            <button id="${vehiculo.placa}" onclick="Android.ObtenerDatos(this.id);" type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editarModal">
              <i class="fas fa-edit"></i>
            </button>
            <button id="${vehiculo.placa}" onclick="eliminarVehiculo(this.id)" type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#eliminarModal">
              <i class="fas fa-trash"></i>
            </button>
          </td>
        </tr>
      `;
      tablaAutomoviles.innerHTML += raw;
    });
  }
}

Android.MostrarVehiculo();

