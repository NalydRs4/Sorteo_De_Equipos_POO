package ups.poo.sorteo.ejecucion;

// Importamos la clase Metodos para poder utilizar sus funcionalidades en el menú de ejecución del sorteo.
import ups.poo.sorteo.contenido.Metodos;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Metodos aplicacion = new Metodos();
        // Bucle infinito para mostrar el menú hasta que el usuario decida salir.
        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("== Sorteo de los partidos de fútbol ==");
            System.out.println("1. Octavos de final (16 equipos)");
            System.out.println("2. Cuartos de final (8 equipos)");
            System.out.println("3. Semifinales (4 equipos)");
            System.out.println("4. Final (2 equipos)");
            System.out.println("5. Salir");
            System.out.println("---------------------------------------");
            int opcion = leer.nextInt();
            leer.nextLine(); // Limpiar el buffer del scanner
            switch (opcion) {
                case 1:
                    System.out.println("---------------------------------------");
                    System.out.println("Ingrese los 16 equipos para los octavos de final:");
                    System.out.println("---------------------------------------");
                    for (int i = 0; i < 16; i++) {
                        System.out.print("Equipo " + (i + 1) + ": ");
                        String equipo = leer.nextLine();
                        // Manejo de excepción try-Catch para evitar que se agreguen equipos repetidos al sorteo.
                        try {
                            aplicacion.agregarEquipos(equipo);
                        } catch (Metodos.EquipoRepetidoInvalidoException exception) {
                            // Excepción propia para evitar que se agreguen equipos repetidos al sorteo.
                            System.out.println(exception.getMessage());
                            i--;
                        }
                        if (aplicacion.getAgregarEquipos().size() == 16) {
                            // Si se han agregado los 16 equipos, se procede a realizar el sorteo de octavos de final y sucesivos.
                            aplicacion.sorteoOctavos();                        
                        }
                    }
                    break;
                case 2:
                    System.out.println("---------------------------------------");
                    System.out.println("Ingrese los 8 equipos para los cuartos de final:");
                    System.out.println("---------------------------------------");
                    for (int i = 0; i < 8; i++) {
                        System.out.print("Equipo " + (i + 1) + ": ");
                        String equipo = leer.nextLine();
                        try {
                            aplicacion.agregarEquipos(equipo);
                        } catch (Metodos.EquipoRepetidoInvalidoException exception) {
                            System.out.println(exception.getMessage());
                            i--;
                        }
                        if (aplicacion.getAgregarEquipos().size() == 8) {
                            aplicacion.sorteoCuartos();
                        }   
                    }
                    break;
                case 3:
                    System.out.println("---------------------------------------");
                    System.out.println("Ingrese los 4 equipos para las semifinales:");
                    System.out.println("---------------------------------------");
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Equipo " + (i + 1) + ": ");
                        String equipo = leer.nextLine();
                        try {
                            aplicacion.agregarEquipos(equipo);
                        } catch (Metodos.EquipoRepetidoInvalidoException exception) {
                            System.out.println(exception.getMessage());
                            i--;
                        }
                        if (aplicacion.getAgregarEquipos().size() == 4) {
                           aplicacion.sorteoSemifinales();
                        }
                    }
                    break;
                case 4:
                    System.out.println("---------------------------------------");
                    System.out.println("Ingrese los 2 equipos para la final:");
                    System.out.println("---------------------------------------");
                    for (int i = 0; i < 2; i++) {
                        System.out.print("Equipo " + (i + 1) + ": ");
                        String equipo = leer.nextLine();
                        try {
                            aplicacion.agregarEquipos(equipo);
                        } catch (Metodos.EquipoRepetidoInvalidoException exception) {
                            System.out.println(exception.getMessage());
                            i--;
                        }
                        if (aplicacion.getAgregarEquipos().size() == 2) {
                          aplicacion.sorteoFinal();
                        }
                    }
                    break;
                case 5:
                    System.out.println("---------------------------------------");
                    System.out.println("Saliendo del programa...");
                    System.out.println("---------------------------------------");
                    return;
                default:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    System.out.println("----------------------------------------------------------");
            }
        }
    }
}
