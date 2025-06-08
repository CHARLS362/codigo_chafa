# Nombre del Proyecto ( "Aplicación de Temperaturas")


Este proyecto es una aplicación de ejemplo desarrollada en Kotlin para Android que demuestra la implementación de una arquitectura limpia utilizando componentes de Android Jetpack como Room para persistencia de datos, Coroutines para programación asíncrona, y el patrón de diseño MVVM (Model-View-ViewModel) para una separación clara de responsabilidades.

## 🚀 Características

* **Persistencia de Datos:** Almacena y gestiona datos de temperatura utilizando la biblioteca Room.
* **Arquitectura MVVM:** Separación clara de la lógica de negocio, la capa de datos y la interfaz de usuario.
* **Componentes Jetpack:** Utiliza `ViewModel`, `LiveData`/`Flow` (a juzgar por `collect`), `Room` y `RecyclerView`.
* **Coroutines de Kotlin:** Manejo eficiente de operaciones asíncronas para la interacción con la base de datos y la recolección de datos.
* **Interfaz de Usuario Responsiva:** Muestra una lista de temperaturas con un `RecyclerView`.

## 🛠️ Tecnologías Utilizadas

* **Kotlin:** Lenguaje de programación principal.
* **Android Jetpack:**
    * **Room:** Capa de abstracción de base de datos SQLite.
    * **ViewModel:** Ciclo de vida consciente de los datos de la UI.
    * **LifecycleScope:** Para coroutines vinculadas al ciclo de vida de la Activity.
    * **RecyclerView:** Para mostrar listas eficientes.
* **Coroutines de Kotlin:** Para concurrencia y programación asíncrona.

## 📁 Estructura del Proyecto

El proyecto sigue una estructura modular y organizada, facilitando la escalabilidad y el mantenimiento:
