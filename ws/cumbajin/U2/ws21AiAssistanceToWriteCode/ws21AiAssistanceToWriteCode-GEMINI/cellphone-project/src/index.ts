import { Cellphone } from './model/Cellphone';
import { CellphoneController } from './controller/CellphoneController';
import { CellphoneView } from './view/CellphoneView';

function main() {
  const controller = new CellphoneController('cellphones.json');
  const view = new CellphoneView();

  // 1. Crear objetos y agregarlos a la lista
  view.showMessage("Creating Cellphone objects...");
  const phone1 = new Cellphone(1, "Samsung", "Galaxy S24", 999.99);
  const phone2 = new Cellphone(2, "Apple", "iPhone 15", 1099.99);
  const phone3 = new Cellphone(3, "Xiaomi", "13 Pro", 749.50);

  controller.addCellphone(phone1);
  controller.addCellphone(phone2);
  controller.addCellphone(phone3);

  // 2. Guardar en el archivo JSON
  view.showMessage("Saving cellphones to 'cellphones.json'...");
  controller.saveToJson();

  // 3. Leer los objetos de vuelta desde el archivo JSON
  view.showMessage("Reading cellphones from 'cellphones.json'...");
  const loadedCellphones = controller.readFromJson();

  // 4. Mostrar el resultado por pantalla
  view.displayCellphones(loadedCellphones);
}

main();