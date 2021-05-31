PathBin = ./EXE

PathLibs = ./src/main/java/lib/\*
PathGson = ./src/main/java/lib/gson-2.8.6.jar
PathJUnit = ./src/main/java/lib/junit-4.13.2.jar

PathDatos = ./src/main/java/othello/data/*.java
PathClasses = ./src/main/java/othello/domain/*.java
PathClassesTablero = ./src/main/java/othello/domain/tablero/*.java
PathPersistencia = ./src/main/java/othello/persistence/*.java
PathPresentacio = ./src/main/java/othello/view/*.java

PathMain = ./src/main/java/othello/view/Main.java

PathTests = ./src/main/java/drivers/*.java

PathJUnitTests = ./src/test/java/othello/domain/*.java

Main = othello/view/Main

DriverCtrlDomain = drivers/DriverCtrlDomain
DriverEscenario = drivers/DriverEscenario
DriverIA = drivers/DriverIA
DriverPartida = drivers/DriverPartida
DriverTablero = drivers/DriverTablero

JUnitCtrlDomainTest = othello/domain/CtrlDomainTest
JUnitEscenarioTest = othello/domain/EscenarioTest
JUnitPartidaTest = othello/domain/PartidaTest

default: all

all:
	 javac -d $(PathBin) -cp $(PathLibs) $(PathDatos) $(PathClasses) $(PathClassesTablero) $(PathPersistencia) $(PathPresentacio) 

compileMain: 
	javac -d $(PathBin) -cp $(PathLibs) $(PathDatos) $(PathClasses) $(PathClassesTablero) $(PathPersistencia) $(PathPresentacio) $(PathMain) 

run: compileMain
	java -cp $(PathBin):$(PathLibs) $(Main)


compileDrivers: 
	javac -d $(PathBin) -cp $(PathLibs) $(PathDatos) $(PathClasses) $(PathClassesTablero) $(PathPersistencia) $(PathPresentacio) $(PathTests) 
	
	
runDriverCtrlDomain: compileDrivers
	java -cp $(PathBin):$(PathLibs) $(DriverCtrlDomain)

runDriverEscenario: compileDrivers
	java -cp $(PathBin):$(PathLibs) $(DriverEscenario)

runDriverIA: compileDrivers
	java -cp $(PathBin):$(PathLibs) $(DriverIA)

runDriverPartida: compileDrivers
	java -cp $(PathBin):$(PathLibs) $(DriverPartida)
	
runDriverTablero: compileDrivers
	java -cp $(PathBin):$(PathLibs) $(DriverTablero)
	
compileJUnit: 
	javac -d $(PathBin) -cp $(PathLibs) $(PathDatos) $(PathClasses) $(PathClassesTablero) $(PathPersistencia) $(PathPresentacio) $(PathJUnitTests)

	
clean:
	rm -f -r $(PathBin)
