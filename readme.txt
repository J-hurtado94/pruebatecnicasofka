PRUEBA E2E - FLUJO DE COMPRA EN SAUCEDEMO
Serenity BDD 5 + Screenplay + Cucumber 7 + JUnit 6 + Gradle
===============================================================

1. REQUISITOS PREVIOS
   - JDK 17 o superior (probado con Amazon Corretto 21)
   - Google Chrome instalado (el driver lo descarga Serenity automáticamente)
   - Git
   - No es necesario instalar Gradle: el proyecto incluye el wrapper (gradlew)

2. CLONAR EL REPOSITORIO
   git clone https://github.com/J-hurtado94/pruebatecnicasofka.git
   cd pruebatecnicasofka

3. CONFIGURAR LA CLAVE DE ACCESO (variable de entorno)
   Por buenas prácticas, la clave no está en el código ni en los features: se lee de la
   variable de entorno SAUCEDEMO_PASSWORD. Usar la clave del enunciado del ejercicio
   (es la misma que muestra la página de login de SauceDemo).

   macOS / Linux:
     export SAUCEDEMO_PASSWORD=<clave>

   Windows (PowerShell):
     $env:SAUCEDEMO_PASSWORD="<clave>"

   Alternativa sin variable de entorno:
     ./gradlew clean test -Dsaucedemo.password=<clave>

   Si no se define, la prueba falla de inmediato con el mensaje:
     "No se encontró la clave de acceso. Defina la variable de entorno SAUCEDEMO_PASSWORD..."

   Desde IntelliJ (ejecutando el runner directamente): Run > Edit Configurations >
   Environment variables > SAUCEDEMO_PASSWORD=<clave>.

4. EJECUTAR LAS PRUEBAS
   macOS / Linux:
     ./gradlew clean test

   Windows:
     gradlew.bat clean test

   Por defecto Chrome se ejecuta en modo headless (sin interfaz). Para ver el navegador:
     ./gradlew clean test -Dheadless.mode=false

   Ejecutar por tags de Cucumber:
     ./gradlew clean test -Dcucumber.filter.tags="@e2e"

   Usar otro navegador (por ejemplo Firefox o Edge, si está instalado):
     ./gradlew clean test -Dwebdriver.driver=firefox

5. VER EL REPORTE
   Al terminar, Serenity genera automáticamente (incluso si la prueba falla):
     - Reporte completo:  target/site/serenity/index.html
     - Resumen 1 página:  target/site/serenity/serenity-summary.html
   Abrir el archivo en el navegador.

   El reporte de una ejecución exitosa ya está versionado en:
     evidencias/serenity-report/index.html
   (incluye capturas de pantalla de cada acción).

6. EJECUCIÓN DESDE INTELLIJ IDEA
   - Abrir la carpeta del proyecto (IntelliJ lo importa como proyecto Gradle).
   - Clic derecho sobre src/test/java/com/sofka/saucedemo/runners/CompraTestSuite.java > Run.
   - O ejecutar la tarea Gradle "test" desde la ventana Gradle.

7. INTEGRACIÓN CONTINUA
   .github/workflows/gradle.yml ejecuta la prueba en GitHub Actions en cada push a master
   y publica el reporte de Serenity como artefacto descargable.
   Requiere crear el secret del repositorio: Settings > Secrets and variables > Actions >
   New repository secret > Nombre: SAUCEDEMO_PASSWORD.

8. ESTRUCTURA DEL PROYECTO
   src/main/java/com/sofka/saucedemo/      Componentes Screenplay reutilizables
     tasks/            Acciones de negocio del actor: AbrirTienda, IniciarSesion,
                       AgregarProductos, VerCarrito, CompletarFormularioCompra, FinalizarCompra
     interactions/     IngresarTextoSensible: escribe valores sensibles sin publicarlos en el reporte
     questions/        Lo que el actor consulta: TituloInventario, ProductosEnCarrito,
                       MensajeConfirmacion
     userinterfaces/   Solo localizadores (Targets) por página, usando atributos data-test
     models/           Comprador (record con los datos de envío)
     utils/            MemoriaActor (llaves de remember/recall)
                       Credenciales (lee la clave de la variable de entorno)

   src/test/java/com/sofka/saucedemo/      Ejecución de las pruebas
     runners/          CompraTestSuite: suite JUnit Platform que ejecuta Cucumber
     stepdefinitions/  Pasos Gherkin -> delegan en Tasks y Questions (sin lógica de UI)
                       Hooks: prepara el escenario (OnStage + OnlineCast)

   src/test/resources/
     features/compra/compra_productos.feature   Escenario en Gherkin (español)
     serenity.conf                               Configuración de navegador, capturas, URL base
     junit-platform.properties                   Configuración de Cucumber
