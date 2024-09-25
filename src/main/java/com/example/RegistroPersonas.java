import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistroPersonas {
    private static final int MAX_PERSONAS = 50;
    private static final String[][] registro = new String[MAX_PERSONAS][3];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 6);
        System.out.println("Programa finalizado");
    }

    private static void mostrarMenu() {
        System.out.println("""
                Menú:
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6) Salir.
                """);
    }

    private static int leerOpcion() {
        int opcion = -1;
        while (opcion < 1 || opcion > 6) {
            try {
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida, debe ingresar un número entre 1 y 6.");
                scanner.nextLine();
            }
        }
        return opcion;
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> agregarPersona();
            case 2 -> mostrarMayoresDeEdad();
            case 3 -> mostrarMenoresDeEdad();
            case 4 -> mostrarPersonasTerceraEdad();
            case 5 -> mostrarPersonasPorEstadoCivil();
        }
    }

    private static void agregarPersona() {
        if (hayCupo()) {
            int indiceDisponible = obtenerUltimoEspacio();
            String nombre = leerNombre();
            String estadoCivil = leerEstadoCivil();
            int edad = leerEdad();

            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = estadoCivil;
            registro[indiceDisponible][2] = String.valueOf(edad);

            System.out.println("Persona agregada con éxito.");
        } else {
            System.out.println("No hay más cupo disponible.");
        }
    }

    private static String leerNombre() {
        String nombre;
        while (true) {
            System.out.print("Ingrese el nombre de la persona: ");
            nombre = scanner.nextLine().trim();
            if (!nombre.isEmpty()) {
                break;
            }
            System.err.println("El nombre no puede estar vacío. Intente nuevamente.");
        }
        return nombre;
    }

    private static String leerEstadoCivil() {
        String estadoCivil;
        while (true) {
            System.out.print("Ingrese estado civil (Soltero/a o Casado/a): ");
            estadoCivil = scanner.nextLine().trim();
            if (estadoCivil.equalsIgnoreCase("Soltero/a") || estadoCivil.equalsIgnoreCase("Casado/a")) {
                break;
            }
            System.err.println("Estado civil inválido. Debe ser Soltero/a o Casado/a.");
        }
        return estadoCivil;
    }

    private static int leerEdad() {
        int edad = -1;
        while (edad < 0) {
            try {
                System.out.print("Ingrese la edad: ");
                edad = scanner.nextInt();
                scanner.nextLine();
                if (edad < 0) {
                    System.err.println("La edad debe ser un número positivo.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida, por favor ingrese un número válido para la edad.");
                scanner.nextLine();
            }
        }
        return edad;
    }

    private static boolean hayCupo() {
        return obtenerUltimoEspacio() != -1;
    }

    private static int obtenerUltimoEspacio() {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null || registro[i][0].isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    private static void mostrarMayoresDeEdad() {
        int mayoresDeEdad = 0;
        for (String[] persona : registro) {
            if (persona[0] != null && !persona[0].isEmpty() && Integer.parseInt(persona[2]) >= 18) {
                mayoresDeEdad++;
            }
        }
        System.out.println("Cantidad de personas mayores de edad: " + mayoresDeEdad);
    }

    private static void mostrarMenoresDeEdad() {
        int menoresDeEdad = 0;
        for (String[] persona : registro) {
            if (persona[0] != null && !persona[0].isEmpty() && Integer.parseInt(persona[2]) < 18) {
                menoresDeEdad++;
            }
        }
        System.out.println("Cantidad de personas menores de edad: " + menoresDeEdad);
    }

    private static void mostrarPersonasTerceraEdad() {
        int terceraEdad = 0;
        for (String[] persona : registro) {
            if (persona[0] != null && !persona[0].isEmpty() && Integer.parseInt(persona[2]) >= 60) {
                terceraEdad++;
            }
        }
        System.out.println("Cantidad de personas de tercera edad: " + terceraEdad);
    }

    private static void mostrarPersonasPorEstadoCivil() {
        int solteros = 0;
        int casados = 0;
        for (String[] persona : registro) {
            if (persona[0] != null && !persona[0].isEmpty()) {
                if (persona[1].equalsIgnoreCase("Soltero/a")) {
                    solteros++;
                } else if (persona[1].equalsIgnoreCase("Casado/a")) {
                    casados++;
                }
            }
        }
        System.out.println("Cantidad de personas solteras: " + solteros);
        System.out.println("Cantidad de personas casadas: " + casados);
    }
}
