PathBin = ./EXE

PathGson = ./src/main/java/lib/gson-2.8.6.jar

PathDatos = ./src/main/java/othello/data/*.java
PathClasses = ./src/main/java/othello/domain/*.java
PathClassesTablero = ./src/main/java/othello/domain/tablero/*.java
PathPersistencia = ./src/main/java/othello/persistence/*.java
PathPresentacio = ./src/main/java/othello/view/*.java

PathMain = ./src/main/java/othello/test/Main.java
PathTests = ./src/main/java/drivers/*.java

Main = othello/test/Main

DriverCtrlDomain = drivers/DriverCtrlDomain
DriverEscenario = drivers/DriverEscenario
DriverIA = drivers/DriverIA
DriverPartida = drivers/DriverPartida
DriverTablero = drivers/DriverTablero

default: all

all:
	 javac -d $(PathBin) -cp $(PathGson) $(PathDatos) $(PathClasses) $(PathClassesTablero) $(PathPersistencia) $(PathPresentacio) 

compileMain: 
	javac -d $(PathBin) -cp $(PathGson) $(PathDatos) $(PathClasses) $(PathClassesTablero) $(PathPersistencia) $(PathPresentacio) $(PathMain) 

run: compileMain
	java -cp $(PathBin):$(PathGson) $(Main)


compileDrivers: 
	javac -d $(PathBin) -cp $(PathGson) $(PathDatos) $(PathClasses) $(PathClassesTablero) $(PathPersistencia) $(PathPresentacio) $(PathTests) 
	
	
runDriverCtrlDomain: compileDrivers
	java -cp $(PathBin):$(PathGson) $(DriverCtrlDomain)

runDriverEscenario: compileDrivers
	java -cp $(PathBin):$(PathGson) $(DriverEscenario)

runDriverIA: compileDrivers
	java -cp $(PathBin):$(PathGson) $(DriverIA)

runDriverPartida: compileDrivers
	java -cp $(PathBin):$(PathGson) $(DriverPartida)
	
runDriverTablero: compileDrivers
	java -cp $(PathBin):$(PathGson) $(DriverTablero)
	
clean:
	rm -f -r $(PathBin)
