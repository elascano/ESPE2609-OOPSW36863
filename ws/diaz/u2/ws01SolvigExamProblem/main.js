const DiscoCompacto = require('./DiscoCompacto');
const fs = require('fs');

let datos = fs.readFileSync('discos.json', 'utf8');

let discosGuardados = JSON.parse(datos);

console.log("Disks of the files JSON");

discosGuardados.forEach(function(disco) {

    let nuevoDisco = new DiscoCompacto(
        disco.id,
        disco.title,
        disco.artist,
        disco.duracion
    );

    console.log("----------------------");
    nuevoDisco.mostrarInformacion();
});

