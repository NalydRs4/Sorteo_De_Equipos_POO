package ups.poo.sorteo.contenido;

import java.util.Stack;
import java.util.Collections;

public class Metodos {

    public class EquipoRepetidoInvalidoException extends Exception {
        public EquipoRepetidoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    private Stack<String> agregarEquipos;

    public Stack<String> getAgregarEquipos() {
        return agregarEquipos;
    }

    public void setAgregarEquipos(Stack<String> agregarEquipos) {
        this.agregarEquipos = agregarEquipos;
    }

    public Metodos() {
        this.agregarEquipos = new Stack<String>();
    }

    public void agregarEquipos(String equipo) throws EquipoRepetidoInvalidoException {
        if (this.agregarEquipos.contains(equipo)) {
            throw new EquipoRepetidoInvalidoException("ERROR: El equipo ya ha sido agregado.");
        }
        this.agregarEquipos.push(equipo);
    }

    public void sorteo() {
        Collections.shuffle(this.agregarEquipos);
        System.out.println("----------------------------------");
        System.out.println("Resultados del sorteo: ");
        System.out.println("----------------------------------");
        emparejarEquiposRecursivo(this.agregarEquipos, 1);
    }

    private void emparejarEquiposRecursivo(Stack<String> equipos, int ronda) {
        if (equipos.size() < 2) {
            return; // Base case: no hay suficientes equipos para emparejar
        }
        String equipo1 = equipos.pop();
        String equipo2 = equipos.pop();
        System.out.println("Ronda " + ronda + ": " + equipo1 + " vs " + equipo2);
        emparejarEquiposRecursivo(equipos, ronda + 1);
    }

}
