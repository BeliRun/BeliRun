function mostrarOpciones(vehiculo) {
    // Obtener el ID del vehículo seleccionado
    let idVehiculo = vehiculo;
  
    // Definir las acciones a tomar para cada opción del modal
    let acciones = {
      "Mantenimiento": () => {
        // Abrir la ventana de mantenimiento para el vehículo seleccionado
        window.location.href = `file:///android_asset/MantenimientoP.html?id=${idVehiculo}`;
      },
      "Producido": () => {
        // Abrir la ventana de producido para el vehículo seleccionado
        window.location.href = `file:///android_asset/ProducidoP.html?id=${idVehiculo}`;
      },
      "Rodamiento": () => {
        // Abrir la ventana de rodamiento para el vehículo seleccionado
        window.location.href = `file:///android_asset/RodamientoP.html?id=${idVehiculo}`;
      }
    };
  
    // Definir el evento click para cada opción del modal
    let opciones = document.querySelectorAll(".menu-option");
    opciones.forEach(opcion => {
      opcion.onclick = function() {
        let accion = acciones[this.id];
        if (accion) {
          accion();
        }
      };
    });
  }
  
function mostrarVehiculo(vehiculos){
    let tablaAutomoviles = document.getElementById("tablaAutomovilesC");
    tablaAutomoviles.innerHTML = "";
    let raw = "";
    if(vehiculos){
      vehiculos.forEach(vehiculo => {
        raw = `
        <div  class="col-md-4 mt-4" id="${vehiculo.placa}" onclick='mostrarOpciones(this.id)' data-bs-toggle="modal" data-bs-target="#menuModal">
            <div style="border: none;" class="card box">
                <div class="card-header">
                    <center>
                    <h5 class="card-title"> ${vehiculo.placa}  #${vehiculo.numero}</h5>
                    </center>
                </div>
                <div class="card-body">
                    <center>
                    <img style="width: 250px; height: 250px;" src="img/bus.png">
                    </center>
                </div>
            </div>
        </div>
        `;
        tablaAutomoviles.innerHTML+=raw;
      });
    }// data-bs-toggle="modal" data-bs-target="#editarModal"
  }

  Android.MostrarVehiculo();