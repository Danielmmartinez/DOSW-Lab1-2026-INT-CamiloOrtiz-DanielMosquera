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
Estos dos tienen varias diferencias
