const agregarAutomovil = ()=>{
    let placa = document.getElementById("placa").value;
    let numeroInterno = document.getElementById("numeroInterno").value;
    let marca = document.getElementById("marca").value;

    Android.AgregarVehiculo(placa, marca, numeroInterno);
    window.location.href = "file:///android_asset/Vehiculos.html"
}
function eliminarVehiculo(placa){
    
}
function mostrarVehiculo(vehiculos){
  let tablaAutomoviles = document.getElementById("tablaAutomoviles");
  let raw = "";
  vehiculos.forEach(vehiculo => {
    raw = `
        <tr>
            <td>${vehiculo.placa}</td>
            <td>${vehiculo.numero}</td>
            <td>${vehiculo.marca}</td>
            <td>
          <button class="btn btn-primary btn-sm data-bs-toggle=" modal" data-bs-target="#editarModal"><i
              class="fas fa-edit"></i></button>
          <button id='${vehiculo.placa}' onclick='eliminarVehiculo(this.id)' class="btn btn-danger btn-sm" onclick=><i class="fas fa-trash"></i></button>
        </td>
        </tr>
    `;
    tablaAutomoviles.innerHTML+=raw;
  });
}

Android.MostrarVehiculo();

