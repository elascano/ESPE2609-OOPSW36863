class discCompact{
    constructor(id, title, artist, duracion){
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duracion= duracion;
    }
    mostrarInformacion(){    
        console.log("id:" + this.id);
        console.log("Title:" + this.title);
        console.log("Artist:" + this.duracion + " in minutes");
}
}
module.exports = discCompact;

