public readFromFile(): Product[] {
        try {
            if (!fs.existsSync(this.filePath)) {
                return [];
            }

            const fileContent = fs.readFileSync(this.filePath, 'utf-8');
            if (!fileContent.trim()) {
                return [];
            }

            const rawData: any[] = JSON.parse(fileContent);
            
            // Reconstruimos los objetos limpios como instancias de la clase Product
            return rawData.map(item => new Product(item.id, item.name, item.price, item.stock));
        } catch (error) {
            console.error('Error al leer el archivo JSON:', error);
            return [];
        }
    }
}
