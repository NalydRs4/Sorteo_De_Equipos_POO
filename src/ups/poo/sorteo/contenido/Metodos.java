package ups.poo.sorteo.contenido;

// Importamos las clases necesarias para el funcionamiento del sorteo. 
// Stack para manejar las pilas de equipos y Collections para mezclar los equipos antes de cada ronda.
import java.util.Stack;
import java.util.Collections;

public class Metodos {

    // Excepción propia para evitar que se agreguen equipos repetidos al sorteo.
    public class EquipoRepetidoInvalidoException extends Exception {
        public EquipoRepetidoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public void agregarEquipos(String equipo) throws EquipoRepetidoInvalidoException {
        if (this.agregarEquipos.contains(equipo)) {
            throw new EquipoRepetidoInvalidoException("ERROR: El equipo ya ha sido agregado.");
        }
        this.agregarEquipos.push(equipo);
    }

    // Declaración de las pilas para manejar los equipos en cada fase del sorteo.
    private Stack<String> agregarEquipos;
    public Stack<String> equiposOctavos;
    public Stack<String> equiposCuartos;
    public Stack<String> equiposSemifinales;
    public Stack<String> equiposFinales;

    // Getters y Setters para la pila de equipos agregados al sorteo.
    public Stack<String> getAgregarEquipos() {
        return agregarEquipos;
    }

    public void setAgregarEquipos(Stack<String> agregarEquipos) {
        this.agregarEquipos = agregarEquipos;
    }

    // Constructor de la clase Metodos para inicializar las pilas de equipos.
    public Metodos() {
        this.agregarEquipos = new Stack<String>();
        this.equiposOctavos = new Stack<String>();
        this.equiposCuartos = new Stack<String>();
        this.equiposSemifinales = new Stack<String>();
        this.equiposFinales = new Stack<String>();
    }

    // Métodos para realizar el sorteo de Octavos de Final, utilizando recursividad para manejar las rondas y determinar los ganadores.
    public void sorteoOctavos() {
        Collections.shuffle(this.agregarEquipos);
        System.out.println("---------------------------------------");
        System.out.println("Resultados Para los Octavos de Final: ");
        System.out.println("---------------------------------------");
        octavosRecursivo(this.agregarEquipos, this.equiposOctavos, 1);
        System.out.println("---------------------------------------");
        System.out.println("Equipos Clasificados a Cuartos de Final:");
        System.out.println(this.equiposOctavos.toString());
        Collections.shuffle(this.equiposOctavos);
        System.out.println("---------------------------------------");
        System.out.println("Resultados Para los Cuartos de Final: ");
        System.out.println("---------------------------------------");
        cuartosRecursivo(this.equiposOctavos, this.equiposCuartos, 1);
        System.out.println("---------------------------------------");
        System.out.println("Equipos Clasificados a Cuartos de Final:");
        System.out.println(this.equiposCuartos.toString());
        Collections.shuffle(this.equiposCuartos);
        System.out.println("---------------------------------------");
        System.out.println("Resultados Para las Semifinales: ");
        System.out.println("---------------------------------------");
        semifinalesRecursivo(this.equiposCuartos, this.equiposSemifinales, 1);
        System.out.println("---------------------------------------");
        System.out.println("Equipos Clasificados a las Semifinales:");
        System.out.println(this.equiposSemifinales.toString());
        Collections.shuffle(this.equiposSemifinales);
        System.out.println("---------------------------------------");
        System.out.println("Resultados Para la Final: ");
        System.out.println("---------------------------------------");
        finalRecursivo(this.equiposSemifinales, this.equiposFinales, 1);
        System.out.println("---------------------------------------");
        System.out.println("¡Ganador del torneo!:");
        System.out.println(this.equiposFinales.toString());
        // Limpiamos las pilas de ganadores para permitir un nuevo sorteo si el usuario decide continuar.
        this.agregarEquipos.clear();
        this.equiposOctavos.clear();
        this.equiposCuartos.clear();    
        this.equiposSemifinales.clear();
        this.equiposFinales.clear();
    }

    // Métodos para realizar el sorteo de Cuartos de Final, utilizando recursividad para manejar las rondas y determinar los ganadores.
    public void sorteoCuartos() {
        Collections.shuffle(this.agregarEquipos);
        System.out.println("---------------------------------------");
        System.out.println("Resultados Para los Cuartos de Final: ");
        System.out.println("---------------------------------------");
        cuartosRecursivo(this.agregarEquipos, this.equiposCuartos, 1);
        System.out.println("---------------------------------------");
        System.out.println("Equipos Clasificados a Semifinales:");
        System.out.println(this.equiposCuartos.toString());
        Collections.shuffle(this.equiposCuartos);
        System.out.println("---------------------------------------");
        System.out.println("Resultados Para las Semifinales: ");
        System.out.println("---------------------------------------");
        semifinalesRecursivo(this.equiposCuartos, this.equiposSemifinales, 1);
        System.out.println("---------------------------------------");
        System.out.println("Equipos Clasificados a la Final:");
        System.out.println(this.equiposSemifinales.toString());
        Collections.shuffle(this.equiposSemifinales);
        System.out.println("---------------------------------------");
        System.out.println("Resultados Para la Final: ");
        System.out.println("---------------------------------------");
        finalRecursivo(this.equiposSemifinales, this.equiposFinales, 1);
        System.out.println("---------------------------------------");
        System.out.println("¡Ganador del torneo!:");
        System.out.println(this.equiposFinales.toString());
        // Limpiamos las pilas de ganadores para permitir un nuevo sorteo si el usuario decide continuar.
        this.agregarEquipos.clear();
        this.equiposCuartos.clear();    
        this.equiposSemifinales.clear();
        this.equiposFinales.clear();    
    }

    // Métodos para realizar el sorteo de Semifinales, utilizando recursividad para manejar las rondas y determinar los ganadores.
    public void sorteoSemifinales() {
        Collections.shuffle(this.agregarEquipos);
        System.out.println("---------------------------------------");
        System.out.println("Resultados Para las Semifinales: ");
        System.out.println("---------------------------------------");
        semifinalesRecursivo(this.agregarEquipos, this.equiposSemifinales, 1);
        System.out.println("---------------------------------------");
        System.out.println("Equipos Clasificados a la Final:");
        System.out.println(this.equiposSemifinales.toString());
        Collections.shuffle(this.equiposSemifinales);
        System.out.println("---------------------------------------");
        System.out.println("Resultados Para la Final: ");
        System.out.println("---------------------------------------");
        finalRecursivo(this.equiposSemifinales, this.equiposFinales, 1);
        System.out.println("---------------------------------------");
        System.out.println("¡Ganador del torneo!:");
        System.out.println(this.equiposFinales.toString());
        // Limpiamos las pilas de ganadores para permitir un nuevo sorteo si el usuario decide continuar.
        this.agregarEquipos.clear();
        this.equiposSemifinales.clear();
        this.equiposFinales.clear();    
    }

    // Métodos para realizar el sorteo de la Final, utilizando recursividad para manejar las rondas y determinar el ganador.
    public void sorteoFinal() {
        Collections.shuffle(this.agregarEquipos);
        System.out.println("---------------------------------------");
        System.out.println("Resultados Para la Final: ");
        System.out.println("---------------------------------------");
        finalRecursivo(this.agregarEquipos, this.equiposFinales, 1);
        System.out.println("---------------------------------------");
        System.out.println("¡Ganador del torneo!:");
        System.out.println(this.equiposFinales.toString());
        // Limpiamos las pilas de ganadores para permitir un nuevo sorteo si el usuario decide continuar.
        this.agregarEquipos.clear();
        this.equiposFinales.clear();    
    }

    // Método para determinar el ganador de un partido entre dos equipos.
    public String determinarGanador(String equipo1, String equipo2) {
        if (Math.random() < 0.5) {
            return equipo1;
        } else {
            return equipo2;
        }
    }

    // Recursividad para manejar Octavos de Final, determinando los ganadores y mostrando los resultados de cada enfrentamiento.
    private void octavosRecursivo(Stack<String> equipos, Stack<String> ganadores, int ronda) {
        if (equipos.size() < 2) {
            return;
        }
        String equipo1 = equipos.pop();
        String equipo2 = equipos.pop();
        String ganador = determinarGanador(equipo1, equipo2);
        ganadores.push(ganador);
        System.out.println("Ronda " + ronda + ": " + equipo1 + " vs " + equipo2 + " - Ganador: " + ganador);
        octavosRecursivo(equipos, ganadores, ronda + 1);
    }

    // Recursividad para manejar Cuartos de Final, determinando los ganadores y mostrando los resultados de cada enfrentamiento.
    private void cuartosRecursivo(Stack<String> equipos, Stack<String> ganadores, int ronda) {
        if (equipos.size() < 2) {
            return;
        }
        String equipo1 = equipos.pop();
        String equipo2 = equipos.pop();
        String ganador = determinarGanador(equipo1, equipo2);
        ganadores.push(ganador);
        System.out.println("Ronda " + ronda + ": " + equipo1 + " vs " + equipo2 + " - Ganador: " + ganador);
        cuartosRecursivo(equipos, ganadores, ronda + 1);
    }

    // Recursividad para manejar Semifinales, determinando los ganadores y mostrando los resultados de cada enfrentamiento.
    private void semifinalesRecursivo(Stack<String> equipos, Stack<String> ganadores, int ronda) {
        if (equipos.size() < 2) {
            return;
        }
        String equipo1 = equipos.pop();
        String equipo2 = equipos.pop();
        String ganador = determinarGanador(equipo1, equipo2);
        ganadores.push(ganador);
        System.out.println("Ronda " + ronda + ": " + equipo1 + " vs " + equipo2 + " - Ganador: " + ganador);
        semifinalesRecursivo(equipos, ganadores, ronda + 1);
    }

    // Recursividad para manejar la Final, determinando el ganador y mostrando los resultados del enfrentamiento.
    private void finalRecursivo(Stack<String> equipos, Stack<String> ganadores, int ronda) {
        if (equipos.size() < 2) {
            return;
        }
        String equipo1 = equipos.pop();
        String equipo2 = equipos.pop();
        String ganador = determinarGanador(equipo1, equipo2);
        ganadores.push(ganador);
        System.out.println("Ronda " + ronda + ": " + equipo1 + " vs " + equipo2 + " - Ganador: " + ganador);
        finalRecursivo(equipos, ganadores, ronda + 1);
    }
}
