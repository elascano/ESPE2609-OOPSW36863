class Cathedral{
	constructor (id, name, capacity){
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}

	toString() {
        return `Cathedral{id=${this.id}, name=${this.name}, capacity=${this.capacity}}`;
    }

	getId() {
        return this.id;
    }
}

function main() {
    console.log("=============");
    console.log("| Cathedrals |");
    console.log("=============");

    let things = [];
    let cathedrals = new cathedrals(1, "La paz", 55);
    cathedrals.push(Cathedral);

    let cathedrals = [];
    cathedrals.push(cathedrals);
    cathedral2 = new Cathedral (2, "San Francisco", 230);
    cathedrals.push(cathedral2);
    persons.push(new Person(3, "Loma de Quito", 130));

    cathedrals.forEach((c) => {
        console.log("Cathedrals -->" + c.toString());
    });

    for (let i = 0; i < 10; i++) {
        persons.push(new Person(i + 1, "Basilica " + (i + 1), (i + 1) * 1000));
    }

    const jsonTexto = JSON.stringify(cathedrals);
main();