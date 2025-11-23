# 💱 Conversor de Monedas

Aplicación de consola en Java que permite realizar conversiones entre diferentes monedas utilizando tasas de cambio en tiempo real.

## 📋 Descripción

Este proyecto es un conversor de monedas desarrollado en Java que consume la API de ExchangeRate-API para obtener las tasas de cambio actualizadas. La aplicación implementa conceptos de Programación Orientada a Objetos (POO) y ofrece una interfaz de usuario amigable por consola.

## ✨ Características

- 🔄 Conversión en tiempo real entre 6 monedas diferentes
- 🌐 Consumo de API REST (ExchangeRate-API)
- 💻 Interfaz de consola interactiva
- ✅ Validación de datos de entrada
- 🛡️ Manejo robusto de errores
- 📊 Uso de estructuras de datos (HashMap)

## 🪙 Monedas Soportadas

| Código | Moneda |
|--------|--------|
| USD | Dólar estadounidense |
| ARS | Peso argentino |
| BRL | Real brasileño |
| COP | Peso colombiano |
| CLP | Peso chileno |
| BOB | Boliviano boliviano |

## 🚀 Conversiones Disponibles

1. Dólar ⇒ Peso argentino
2. Peso argentino ⇒ Dólar
3. Dólar ⇒ Real brasileño
4. Real brasileño ⇒ Dólar
5. Dólar ⇒ Peso colombiano
6. Peso colombiano ⇒ Dólar

## 🛠️ Tecnologías Utilizadas

- **Java 11+** - Lenguaje de programación
- **HttpClient** - Para peticiones HTTP
- **Gson 2.10.1** - Para parseo de JSON
- **ExchangeRate-API** - API de tasas de cambio

## 📁 Estructura del Proyecto

```
conversor-monedas/
│
├── src/
│   ├── Principal.java
│   ├── ConversorDeMoneda.java
│   └── ConsultaDeAPI.java
│
├── README.md
└── pom.xml (si usas Maven)
```

## 📦 Instalación

### Prerrequisitos

- Java JDK 11 o superior
- JDK 17 o superior
- Librería Gson


## 🎮 Uso

1. Ejecuta la aplicación
2. Selecciona la opción de conversión deseada (1-6)
3. Ingresa la cantidad a convertir
4. Visualiza el resultado
5. Repite o selecciona opción 7 para salir

### Ejemplo de Uso

```
════════════════════════════════════════
  OPCIONES DE CONVERSIÓN
════════════════════════════════════════
1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileño
4) Real brasileño =>> Dólar
5) Dólar =>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Salir
════════════════════════════════════════
Elija una opción válida: 1

Ingrese el valor que desea convertir: 100

⏳ Consultando tasas de cambio...

========================================
RESULTADO DE LA CONVERSIÓN
========================================
100.00 USD equivale a 102500.00 ARS
========================================
```

## 🔑 Configuración de API Key

Para usar tu propia API Key de ExchangeRate-API:

1. Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/)
2. Obtén tu API Key gratuita
3. Reemplaza la constante en `ConsultaDeAPI.java`:

```java
private static final String API_KEY = "TU_API_KEY_AQUI";
```

## 🏗️ Arquitectura

El proyecto sigue los principios de POO con tres clases principales:

### `Principal.java`
- Clase principal con el método `main()`
- Maneja la interfaz de usuario por consola
- Controla el flujo del programa
- Captura y valida las entradas del usuario

### `ConversorDeMoneda.java`
- Contiene la lógica de conversión de monedas
- Gestiona el HashMap de monedas disponibles
- Realiza validaciones de códigos de moneda
- Formatea y muestra los resultados

### `ConsultaDeAPI.java`
- Maneja la comunicación con la API
- Implementa HttpClient, HttpRequest y HttpResponse
- Parsea las respuestas JSON con Gson
- Obtiene las tasas de cambio específicas

## 🧪 Manejo de Errores

La aplicación incluye manejo de errores para:
- ✅ Conexión fallida a la API
- ✅ Códigos de moneda inválidos
- ✅ Valores negativos o inválidos
- ✅ Opciones fuera de rango
- ✅ Entrada de texto en lugar de números

## 📚 Conceptos de Programación Aplicados

- **POO**: Clases, objetos, encapsulamiento
- **Consumo de APIs REST**: HTTP GET, JSON parsing
- **Colecciones**: HashMap para almacenar monedas
- **Control de flujo**: while, switch-case
- **Manejo de excepciones**: try-catch
- **Validación de datos**: entrada del usuario
- **Modularidad**: separación de responsabilidades

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Para cambios importantes:

1. Haz fork del proyecto
2. Crea una rama para tu característica (`git checkout -b feature/nueva-caracteristica`)
3. Commit tus cambios (`git commit -m 'Agrega nueva característica'`)
4. Push a la rama (`git push origin feature/nueva-caracteristica`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## 👨‍💻 Autor

**Daniel Flores**
- GitHub: [@Dafponce](https://github.com/dafponce)
- Email: dafponce@gmail.com

## 🙏 Agradecimientos

- [ExchangeRate-API](https://www.exchangerate-api.com/) por proporcionar la API de tasas de cambio
- [Gson](https://github.com/google/gson) por la librería de parseo JSON
- Oracle por la documentación de Java HttpClient

## 📞 Soporte

Si tienes alguna pregunta o problema, por favor abre un [issue](https://github.com/tu-usuario/conversor-monedas/issues) en el repositorio.

---

⭐ Si este proyecto te fue útil, considera darle una estrella en GitHub!
