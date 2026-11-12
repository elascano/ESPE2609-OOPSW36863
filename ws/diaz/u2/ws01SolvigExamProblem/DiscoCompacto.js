class DiscoCompacto {
   
   constructor(id, title, artist,duracion){
       this.id = id;
       this.title = title;
       this.artist = artist;
       this.duracion = duracion;
   }
   
   mostrarInformacion(){
       console.log("ID:" + this.id);
       console.log("Artist:" + this.artist);
       console.log("Title:" + this.title);
       console.log("Duracion:" + this.duracion + " minutes");
   }
}
module.exports = DiscoCompacto;