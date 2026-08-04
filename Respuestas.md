# 1. ¿Cuál es la diferencia entre git merge y git rebase?
La diferencia entre estos dos es que, el **git merge** es que preserva todo el log de las ramas que se han mezclado, 
y muestra donde se fusionaron, mas **git rebase** es un poco mas limpio en el manejo del log, con lo que da una mejor
y mas limpia historia de las modificaciones, pareciendo que es solo un trabajo hecho linealmente.

# 2. Si dos ramas modifican la misma línea de un archivo, ¿qué sucede al hacer merge?
Bueno, para esto, Git **no** realiza el cambio automaticamente, cuando detecta el conflicto, ademas Git insertara un 
marcador especial en los archivos afectados. Para generar la union toca hacerlo manualmente, y seleccionar entre las
diferentes opciones: Mantener tu version, Mantener la otra version, Combinar ambas en una correcta.

# 3. ¿Cómo puedes ver gráficamente el historial de merges y ramas en consola?
Para ver el historial se usa **git log**, para que se vea mas grafico todo un poco es unicamente con el comando "--graph",
pero para embellecerlo un poco mas, podriamos usar "git log --graph --oneline --all --decorate"

# 4. Explica la diferencia entre un commit y un push.
Las diferecnias entre estos dos comandos, son que el **git commit** guarda los cambios unicamente en la maquina local,
y **git push** envia los commits locales al repositorio remoto, que ya lo a=hace accesible para otros colaboradores.

# 5. ¿Para qué sirven git stash y git stash pop?
Estos dos comandos sirven para gestionar cambios temporales. **git stash** es para guardar y su contraparte es para obtener.
Por ejemplo, si no quiero hacer un commit a medias, y necesito cambiar de rama, o de proyecto, hago un pequeno guardado,
para despues poder retomarlo en un futuro.

# 6. ¿Qué diferencia hay entre HashMap y HashTable?
Estos dos tienen varias diferencias, una de ellas es la sincronizacion, donde HashMap no esta sincronizado y Hashtable 
si lo esta. Para valores Null, HashMap permite una clave unla y varios valores nulos, y Hashtable no lo permite. Y la 
mayor diferencia es la base computacional que son diferentes algoritmos.

# 7. ¿Qué ventajas tiene Collectors.toMap() frente a un bucle tradicional para llenar un mapa?
**Collectors.toMap()** es declarativo por ser codigo con Streams, por lo que este solo describe que quieres hacer y no 
el como hacerlo. Tambien tiene ventajas como la paralelizacion facil.

# 8. Si usas List con objetos y aplicas stream().map(), ¿qué tipo de operación estás haciendo?
Si usames estos dos, es un operacion intermedia de transformacion, que tiene las siguientes caracteristicas
Transformacion uno a uno, e inmutabilidad del Origen, que es que la lista original no se modifica.

# 9. ¿Qué hace stream().filter() y qué retorna?
Tambien como la anterior es una operacion intermedia, que se usa para seleccionar elementos de un Stream basandose en
una condicion. Y retorna un nuevo Stream que contiene unicamente los elementos que cumplieron la condicion. 

# 10. Describe el paso a paso para crear una rama desde develop para una funcionalidad nueva.
- Lo primero es **Actualizar tu rama base**, esto para evitar conflictos futuros. 
- **Crear y cambiar la nueva rama**, usando el comando "checkout -b" para crear la rama.
- **Subor la rama al remoto**, esto para que este en la nube directamente.
- Trabajar en tu nueva rama

# 11. ¿Cuál es la diferencia entre git branch y git checkout -b?
La diferencia entre estas dos en la colocacion despues de la creacion de la rama. **Git branch** unicamente crea la rama
y **git checkout -b** crea la rama y se mueve a ella, colocandonos en la nueva rama creada, es como un branch, y 
un checkout hechos secuencialmente.

# 12. ¿Por qué se recomienda usar ramas feature/ en lugar de trabajar directamente en main?
Hya varios puntos por que son mejores, uno de ellos es la estabilidad, para que no se hagan un conflicto entre todas las
modificaciones, es mejor que el main este estatico, y es el "producto final". Otra mejoria es el Aislamiento y colaboracion
paralela. Ademas tenemos un control de los cambios por los commits y en un futuro los pulls request.