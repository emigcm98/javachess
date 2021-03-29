# Información sobre el estado del proyecto


**PREREQUISITES:**

- Para el correcto funcionamiento se necesita una BD MySQL en localhost:3306 con usuario root y sin contraseña
	- Para cambiar los parámetros de conexión: _Database/ServidorPersistencia.java_ 
	- BD en formato sql con tabla de usuarios en _db/mydatabase.sql_

**DONE:**

- Comprobación de jaque
- Correcto movimiento de peón, alfil, caballo, torre y dama
- Enroque
- Usuarios en BD
- Notación estándar y exportación a PGN (pulsando botón)
- Gráficos piezas y tablero
- 

**TO DO:**

- Gráficos: rotación de gráficos (el tablero) para según el color que se juegue
- Comprobación de movimiento del rey en función de si hay jaque.
- Comprobación de jaque mate (de momento se come el rey para ganar)
- Controlador para partidas, basado en un modelo C/S
	- El servidor crea la partida y el cliente se une a ella
	- Serialización de las jugadas en JSON (formato a determinar)
	- Mecanismos de sincronización.
- Control del tiempo por jugador.
- Mecanismo de finalización de partida
	- Rey ahogado
	- Tablas pactadas
	- Rendición de algún jugador
	- Jaque mate