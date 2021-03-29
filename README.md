# Informaci�n sobre el estado del proyecto


**PREREQUISITES:**

- Para el correcto funcionamiento se necesita una BD MySQL en localhost:3306 con usuario root y sin contrase�a
	- Para cambiar los par�metros de conexi�n: _Database/ServidorPersistencia.java_ 
	- BD en formato sql con tabla de usuarios en _db/mydatabase.sql_

**DONE:**

- Comprobaci�n de jaque
- Correcto movimiento de pe�n, alfil, caballo, torre y dama
- Enroque
- Usuarios en BD
- Notaci�n est�ndar y exportaci�n a PGN (pulsando bot�n)
- Gr�ficos piezas y tablero
- 

**TO DO:**

- Gr�ficos: rotaci�n de gr�ficos (el tablero) para seg�n el color que se juegue
- Comprobaci�n de movimiento del rey en funci�n de si hay jaque.
- Comprobaci�n de jaque mate (de momento se come el rey para ganar)
- Controlador para partidas, basado en un modelo C/S
	- El servidor crea la partida y el cliente se une a ella
	- Serializaci�n de las jugadas en JSON (formato a determinar)
	- Mecanismos de sincronizaci�n.
- Control del tiempo por jugador.
- Mecanismo de finalizaci�n de partida
	- Rey ahogado
	- Tablas pactadas
	- Rendici�n de alg�n jugador
	- Jaque mate