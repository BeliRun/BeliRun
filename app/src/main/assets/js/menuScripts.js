const menuHTML = `
<div class='name__page'>
  <i class='fas fa-bus'></i>
  <h4>BeliRun</h4>
</div>

<div class='options__menu'>

  <a href='#' id='menuOpt1'>
    <div class='option'>
      <i class='fas fa-home' title='Inicio'></i>
      <h4>Inicio</h4>
    </div>
  </a>

  <a href='#' id='menuOpt2'>
    <div class='option'>
      <i class='fas fa-money-bill' title='Producido'></i>
      <h4>Producido</h4>
    </div>
  </a>

  <a href='#' id='menuOpt3'>
    <div class='option'>
      <i class='fas fa-wrench' title='Mantenimiento'></i>
      <h4>Mantenimiento</h4>
    </div>
  </a>

  <a href='#' id='menuOpt4'>
    <div class='option'>
      <i class='fas fa-boxes' title='Rodamiento'></i>
      <h4>Rodamiento</h4>
    </div>
  </a>

  <a href='#' id='menuOpt5'>
    <div class='option'>
      <i class='fas fa-car' title='Vehiculos'></i>
      <h4>Vehiculos</h4>
    </div>
  </a>

  <a href='#' id='menuOpt6'>
    <div class='option'>
      <i class='fas fa-user' title='Conductores'></i>
      <h4>Conductores</h4>
    </div>
  </a>

</div>
`;
document.getElementById("menu_side").innerHTML = menuHTML;
let ruta = window.location.pathname;
let partes = ruta.split("/");
let nombreArchivo = partes[partes.length - 1];

let optionesFiles = [
    "index.html",
    "Producido.html",
    "Mantenimiento.html",
    "Rodamiento.html",
    "Vehiculos.html",
    "Conductores.html"
];

let optionSeleted = optionesFiles.indexOf(nombreArchivo);

let menuOptions = [
    document.getElementById("menuOpt1"),
    document.getElementById("menuOpt2"),
    document.getElementById("menuOpt3"),
    document.getElementById("menuOpt4"),
    document.getElementById("menuOpt5"),
    document.getElementById("menuOpt6"),
]

menuOptions[optionSeleted].className = "selected";

menuOptions[0].addEventListener('click', ()=> window.location.href = "file:///android_asset/index.html");
menuOptions[1].addEventListener('click', ()=> window.location.href = "file:///android_asset/Producido.html");
menuOptions[2].addEventListener('click', ()=> window.location.href = "file:///android_asset/Mantenimiento.html");
menuOptions[3].addEventListener('click', ()=> window.location.href = "file:///android_asset/Rodamiento.html");
menuOptions[4].addEventListener('click', ()=> window.location.href = "file:///android_asset/Vehiculos.html");
menuOptions[5].addEventListener('click', ()=> window.location.href = "file:///android_asset/Conductores.html");


