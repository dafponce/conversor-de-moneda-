import java.util.Scanner;

public class ConversorDeMoneda {
        private Scanner scanner;
        private ConsultaApi consultaApi;

        public ConversorDeMoneda() {
            this.scanner = new Scanner(System.in);
            this.consultaApi = new ConsultaApi();
        }

        public void ejecutar() {
            int opcion;

            do {
                mostrarMenu();
                opcion = scanner.nextInt();

                if (opcion >= 1 && opcion <= 6) {
                    procesarConversion(opcion);
                } else if (opcion != 7) {
                    System.out.println("Opción inválida. Intente nuevamente.");
                }

            } while (opcion != 7);

            System.out.println("¡Gracias por usar el Conversor de Monedas!");
            scanner.close();
        }

        private void mostrarMenu() {
            System.out.println("\n*******************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda");
            System.out.println("*******************************************");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print(" Elija una opción válida:\n ");
        }

        private void procesarConversion(int opcion) {
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
            }

            System.out.print("Ingrese el valor que desea convertir: ");
            double cantidad = scanner.nextDouble();

            realizarConversion(monedaOrigen,monedaDestino, cantidad);
        }

        private void realizarConversion(String codigoOrigen, String codigoDestino, double cantidad) {
            // Obtener las tasas de cambio desde la API
            Moneda monedaOrigen = consultaApi.obtenerMoneda(codigoOrigen, codigoDestino);

            if (monedaOrigen == null) {
                System.out.println("No se pudo obtener la información de conversión.");
                return;
            }

            // Realizar el cálculo de conversión
            double valorConvertido = cantidad * monedaOrigen.getTasaConversion();

            // Mostrar resultado
            System.out.println("\n==========================================");
            System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n",
                    cantidad, codigoOrigen, valorConvertido, codigoDestino);
            System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
            System.out.println("==========================================");
        }
    }

