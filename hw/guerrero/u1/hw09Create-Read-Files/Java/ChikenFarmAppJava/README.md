# Chicken Farm App

Los pollitos del gallinero se guardan en `chickens.json`, en la carpeta desde la que se ejecuta el programa. La ruta completa aparece al iniciar. En NetBeans, abre este proyecto y usa **Run Project**.

El proyecto actualizado aparece en NetBeans como **ChikenFarmApp - HW08 JSON** y esta en `hw/arevalo/u1/hw08MethodDefinitionOnChickenFarmApp/ChikenFarmApp`. La copia de `ws/arevalo/u1/ws12Coding/ChikenFarmApp` es un proyecto distinto y todavia no tiene persistencia JSON. Para ejecutar la version actualizada, haz clic derecho en **ChikenFarmApp - HW08 JSON** y elige **Run**.

1. Usa la opcion **1** para crear un pollito. Al aparecer `Chicken added and saved.`, sus datos ya estan guardados.
2. Cierra y vuelve a ejecutar el programa desde la misma carpeta.
3. Usa la opcion **5** para ver los pollitos recuperados.
4. La opcion **2** elimina un pollito y guarda el cambio inmediatamente.

El archivo se crea al guardar el primer pollito. Si eliminas todos, contiene `[]`. Se conserva el limite de 10 pollitos del gallinero y no se permiten IDs repetidos.

La lectura y escritura de JSON estan dentro del metodo `main` de `ChickenFarmApp.java`. Se guardan el ID, nombre, color, fecha de nacimiento (`YYYY-MM-DD`) y estado de muda. La edad se recalcula al cargar. Si el archivo contiene datos invalidos, el programa informa del problema y termina sin sobrescribirlo.

Se incluye [Gson 2.13.2](https://google.github.io/gson/UserGuide.html) en `lib/gson-2.13.2.jar`, configurado en las dependencias de NetBeans. La biblioteca se obtuvo de [Maven Central](https://repo.maven.apache.org/maven2/com/google/code/gson/gson/2.13.2/gson-2.13.2.jar).
