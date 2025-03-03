# Instrument List App

## 📌 Descripción
Este proyecto es una aplicación simple de Android que permite visualizar y agregar instrumentos musicales a una base de datos utilizando **Supabase**. Se implementa un **ListView** para mostrar los instrumentos almacenados y un campo de entrada con un botón para agregar nuevos.

## 🚀 Funcionalidades
- Mostrar una lista de instrumentos almacenados en **Supabase**.
- Agregar nuevos instrumentos desde la aplicación.
- Reflejar los cambios en la base de datos de Supabase.

## 🔧 Configuración
### Clone el repositorio
```bash
git clone https://github.com/Estebans441/Ejemplo-Supabase
```
### Configurar variables de Supabase
- En la clase `SupabaseService`, reemplace los valores de `SUPABASE_URL` y `SUPABASE_KEY` con los valores de su proyecto de Supabase.
```kotlin
    private const val SUPABASE_URL = "..."
    private const val SUPABASE_KEY = "..."
```
### Ejecutar la aplicación

## 📖 Notas
- Los cambios en la base de datos **no son en tiempo real**, se debe usar **Supabase Realtime** si se desea esta funcionalidad.
- Para mayor seguridad en producción, se recomienda habilitar autenticación y restringir acceso.

## 📌 Recursos
- [Supabase Docs](https://supabase.com/docs)


