# Taller - App Android con Jetpack Compose

Este proyecto es una aplicación Android desarrollada con **Kotlin** y **Jetpack Compose** que consume la API pública de [DummyJSON](https://dummyjson.com/users) para mostrar una lista de usuarios.  
Al seleccionar un usuario, se despliega una pantalla de detalle con toda su información.

---

## 📱 Características

- 🔗 **Consumo de API REST** (DummyJSON - lista de usuarios).  
- 📝 **Lista de usuarios** con nombres y datos básicos.  
- 👤 **Detalle de usuario**: al pulsar sobre un usuario, se muestra su información completa.  
- 🎨 **Interfaz moderna** con Jetpack Compose y Material 3.  
- 📦 Arquitectura organizada con capas de `data`, `repository`, `service` y `ui`.

---

## 🛠️ Tecnologías usadas

- [Kotlin](https://kotlinlang.org/)  
- [Jetpack Compose](https://developer.android.com/jetpack/compose)  
- [Material 3](https://m3.material.io/)  
- [Ktor / Retrofit] (dependiendo de lo que uses para peticiones HTTP)  
- [Kotlinx Serialization] (para parsear JSON)  

---

## 🚀 Instalación y ejecución

1. Clona este repositorio:
   ```bash
   git clone https://github.com/TU-USUARIO/TU-REPO.git
2. Ábrelo en Android Studio.
3. Sincroniza las dependencias de Gradle.
4. Ejecuta la app en un emulador o dispositivo físico (SDK mínimo 24).

## 📚 API usada

Se consume la API de DummyJSON que devuelve información de prueba de usuarios en formato JSON.
Ejemplo de endpoint: https://dummyjson.com/users

## ✨ Autor

Proyecto realizado como parte de un taller de Android con Jetpack Compose.
Desarrollado por: Mateo Moreno ✨
