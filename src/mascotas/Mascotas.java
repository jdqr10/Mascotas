package mascotas;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;

public class Mascotas {
    private String id;
    private String nombre;
    private String especie;
    private int edad;

    public Mascotas() {
    }

    public Mascotas(String id, String nombre, String especie, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public void mostrarInformacion() {
        String info = "INFO\n";
        info += "Identificación: " + id + "\n";
        info += "Nombre: " + nombre + "\n";
        info += "Especie: " + especie + "\n";
        info += "Edad: " + edad + " años";
        JOptionPane.showMessageDialog(null, info);
        hacerSonido();
        alimentacion();
    }

    private void alimentacion() {
    	if (especie.equalsIgnoreCase("perro")) {
            JOptionPane.showMessageDialog(null, "Come Pollo");
        } else if (especie.equalsIgnoreCase("gato")) {
            JOptionPane.showMessageDialog(null, "Come Pesacado");
        } else if(especie.equalsIgnoreCase("cerdo")){
        	JOptionPane.showMessageDialog(null, "Come aguamasa");
        }else if(especie.equalsIgnoreCase("gallo")){
        	JOptionPane.showMessageDialog(null, "Come maiz");
        }else{
            JOptionPane.showMessageDialog(null, "La mascota no come");
        }
	}

	public void hacerSonido() {
        if (especie.equalsIgnoreCase("perro")) {
            JOptionPane.showMessageDialog(null, "¡Guau guau!");
        } else if (especie.equalsIgnoreCase("gato")) {
            JOptionPane.showMessageDialog(null, "¡Miau miau!");
        } else if(especie.equalsIgnoreCase("cerdo")){
        	JOptionPane.showMessageDialog(null, "¡Oink, Oink");
        }else if(especie.equalsIgnoreCase("gallo")){
        	JOptionPane.showMessageDialog(null, "¡Kikiriki!");
        }else{
            JOptionPane.showMessageDialog(null, "La mascota no hace sonidos conocidos.");
        }
    }

    public void ingresarDatos() {
        id = JOptionPane.showInputDialog("Ingrese la identificación:");
        nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        especie = JOptionPane.showInputDialog("Ingrese la especie:");
        String edadStr = JOptionPane.showInputDialog("Ingrese la edad:");
        edad = Integer.parseInt(edadStr);
    }

    public static void main(String[] args) {
        ArrayList<Mascotas> listaMascotas = new ArrayList<>();
        HashMap<String, Mascotas> mapaMascotas = new HashMap<>();
        int opcion;

        do {
            String opcionStr = JOptionPane.showInputDialog(
                    "MENU\n" +
                            "1. Crear mascota\n" +
                            "2. Consultar mascota\n" +
                            "3. Consultar lista de mascotas\n" +
                            "4. Actualizar mascota\n" +
                            "5. Salir\n" +
                            "Ingrese una opción:"
            );
            opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1:
                    Mascotas mascota = new Mascotas();
                    mascota.ingresarDatos();
                    listaMascotas.add(mascota);
                    mapaMascotas.put(mascota.getIdentificacion(), mascota);
                    break;
                case 2:
                    String identificacion = JOptionPane.showInputDialog("Ingrese la identificación de la mascota a consultar:");
                    if (mapaMascotas.containsKey(identificacion)) {
                        Mascotas mascotaConsultada = mapaMascotas.get(identificacion);
                        mascotaConsultada.mostrarInformacion();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con la identificación ingresada.");
                    }
                    break;
                case 3:
                    StringBuilder listaMascotasInfo = new StringBuilder("Lista de mascotas:\n");
                    for (Mascotas mascotaLista : listaMascotas) {
                        listaMascotasInfo.append("------------------\n");
                        listaMascotasInfo.append("Identificación: ").append(mascotaLista.getIdentificacion()).append("\n");
                        listaMascotasInfo.append("Nombre: ").append(mascotaLista.getNombre()).append("\n");
                        listaMascotasInfo.append("Especie: ").append(mascotaLista.getEspecie()).append("\n");
                        listaMascotasInfo.append("Edad: ").append(mascotaLista.getEdad()).append(" años\n");
                    }
                    JOptionPane.showMessageDialog(null, listaMascotasInfo.toString());
                    break;
                case 4:
                    identificacion = JOptionPane.showInputDialog("Ingrese la identificación de la mascota a modificar:");
                    if (mapaMascotas.containsKey(identificacion)) {
                        Mascotas mascotaModificar = mapaMascotas.get(identificacion);
                        mascotaModificar.ingresarDatos();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con la identificación ingresada.");
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa\n" +
                            "--------------------------------\n" +
                            "-----  MUCHAS GRACIAS POR  -----\n" +
                            "-----  CONFIAR EN NOSOTROS -----");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Ingrese una opción correcta.");
            }
        } while (opcion != 5);
    }

    // Getter y Setter para los atributos

    public String getIdentificacion() {
        return id;
    }

    public void setIdentificacion(String identificacion) {
        this.id = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}