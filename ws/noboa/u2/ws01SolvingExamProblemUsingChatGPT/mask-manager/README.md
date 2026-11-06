# Gestor de Máscaras (TypeScript + MVC)

Programa de consola con menú para añadir, eliminar, listar y revisar un archivo JSON de máscaras.

## Cómo ejecutarlo en Visual Studio Code

1. Abre la carpeta `mask-manager` en VS Code (**Archivo > Abrir carpeta**).
2. Abre la terminal integrada (**Ctrl + ñ** o **Terminal > Nueva terminal**).
3. Instala las dependencias (solo la primera vez):
   ```bash
   npm install
   ```
4. Ejecuta el programa:
   ```bash
   npm start
   ```

> También puedes presionar **F5** (usa `.vscode/launch.json`). La entrada de datos funciona en la terminal integrada.

Requiere **Node.js 18 o superior**.

## Estructura (MVC)

```
mask-manager/
├── src/
│   ├── models/
│   │   ├── Mask.ts             # Entidad: id, name, size, isWearing
│   │   └── MaskRepository.ts   # Lee y escribe data/masks.json
│   ├── views/
│   │   └── ConsoleView.ts      # Menú, entrada de datos y salida por consola
│   ├── controllers/
│   │   └── MaskController.ts   # Conecta vista y modelo
│   └── main.ts                 # Punto de entrada
├── data/masks.json             # Se genera automáticamente al añadir la primera máscara
├── package.json
└── tsconfig.json
```

## Scripts

| Comando         | Acción                                   |
|-----------------|------------------------------------------|
| `npm start`     | Ejecuta con ts-node (sin compilar)       |
| `npm run build` | Compila a JavaScript en `dist/`          |
| `npm run serve` | Ejecuta la versión compilada             |
