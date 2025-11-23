import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoneda conversor = new ConversorDeMoneda();
        boolean continuar = true;


        System.out.println("\n════════════════════════════════════════");
        System.out.println("  BIENVENIDO/A AL CONVERSOR DE MONEDA");
        System.out.println("══════════════════════════════════════════");

        while (continuar) {
            mostrarMenu();

            int opcion = 0;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
            } catch (Exception e) {
                scanner.nextLine(); // Limpiar buffer
                System.out.println("  Por favor, ingrese un número válido.");
                continue;
            }

            if (opcion == 7) {
                System.out.println("\n════════════════════════════════════════");
                System.out.println("  ¡Gracias por usar el conversor!");
                System.out.println("   Hasta pronto");
                System.out.println("══════════════════════════════════════════\n");
                continuar = false;
                continue;
            }

            String monedaOrigen = "";
            String monedaDestino = "";

            switch (opcion) {
                case 1:
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    break;
                case 2:
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    break;
                case 3:
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    break;
                case 4:
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    break;
                case 5:
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    break;
                case 6:
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    break;
                default:
                    System.out.println("\n⚠️  Opción inválida. Por favor, elija una opción válida.\n");
                    continue;
            }

            System.out.print("\nIngrese el valor que desea convertir: ");
            double cantidad = 0;
            try {
                cantidad = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer

                if (cantidad < 0) {
                    System.out.println("\n⚠️  El valor no puede ser negativo.\n");
                    continue;
                }
            } catch (Exception e) {
                scanner.nextLine(); // Limpiar buffer
                System.out.println("\n⚠️  Por favor, ingrese un número válido.\n");
                continue;
            }

            System.out.println("\n⏳ Consultando tasas de cambio...");

            double resultado = conversor.convertirMoneda(monedaOrigen, monedaDestino, cantidad);

            if (resultado > 0) {
                conversor.mostrarResultadoConversion(monedaOrigen, monedaDestino, cantidad, resultado);
            } else {
                System.out.println("\n❌ Error al realizar la conversión. Intente nuevamente.\n");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("════════════════════════════════════════");
        System.out.println("  OPCIONES DE CONVERSIÓN");
        System.out.println("════════════════════════════════════════");
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real brasileño");
        System.out.println("4) Real brasileño =>> Dólar");
        System.out.println("5) Dólar =>> Peso colombiano");
        System.out.println("6) Peso colombiano =>> Dólar");
        System.out.println("7) Salir");
        System.out.println("════════════════════════════════════════");
        System.out.print("Elija una opción válida: ");
    }
}