const agregarAutomovil = ()=>{
    let placa = document.getElementById("placa").value;
    let numeroInterno = document.getElementById("numeroInterno").value;
    let marca = document.getElementById("marca").value;

    Android.AgregarVehiculo(placa, marca, numeroInterno);
    window.location.href = "file:///android_asset/Vehiculos.html"
}
function eliminarVehiculo(placa){
    Android.EliminarVehiculo(placa);
}

function buscarVehiculo(){
  let search = document.getElementById("search");
  Android.BuscarVehiculo(search.value);
}

function mostrarVehiculo(vehiculos){
  let tablaAutomoviles = document.getElementById("tablaAutomoviles");
  tablaAutomoviles.innerHTML = "";
  let raw = "";
  if(vehiculos){
    vehiculos.forEach(vehiculo => {
      raw = `
          <tr>
              <td>${vehiculo.placa}</td>
              <td>${vehiculo.numero}</td>
              <td>${vehiculo.marca}</td>
              <td>
            <button id=${vehiculo.placa} onclick='' class="btn btn-primary btn-sm data-bs-toggle=" modal" data-bs-target="#editarModal"><i
                class="fas fa-edit"></i></button>
            <button id='${vehiculo.placa}' onclick='eliminarVehiculo(this.id)' class="btn btn-danger btn-sm" onclick=><i class="fas fa-trash"></i></button>
          </td>
          </tr>
      `;
      tablaAutomoviles.innerHTML+=raw;
    });
  }
}

Android.MostrarVehiculo();

