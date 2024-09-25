# Taller02

**Vicente Contreras (VicenteContrerasUfro)**

- **Tareas asignadas(Vicente Contreras)**:
     - Análisis de la problemática.
     - Identificación de errores en el código original.
     - Refactorización del código y separación en métodos.
     - Pruebas unitarias de los métodos relacionados con el conteo de personas por edad.

     El objetivo es implementar buenas prácticas de programación, gestionar excepciones, y realizar pruebas unitarias para asegurar el correcto funcionamiento del programa.

---

## Pruebas Unitarias

### Estudiante 1:
- **Método**: contarMayoresEdad()
  - **Datos de prueba**: 
    - Persona 1: Nombre: Juan, Edad: 20, Estado civil: Soltero/a
    - Persona 2: Nombre: Ana, Edad: 17, Estado civil: Casado/a
    - Persona 3: Nombre: Isabel, Edad: 76, Estado civil: Casado/a
  - **Resultado esperado**: La función debe devolver que hay 2 mayor de edad.

- **Método**: contarMenoresEdad()
  - **Datos de prueba**:
    - Persona 1: Nombre: Juan, Edad: 20, Estado civil: Soltero/a
    - Persona 2: Nombre: Ana, Edad: 17, Estado civil: Casado/a
    - Persona 3: Nombre: Isabel, Edad: 76, Estado civil: Casado/a
  - **Resultado esperado**: La función debe devolver que hay 1 menor de edad.

- **Método**: contarPorEstadoCivil()
  - **Datos de prueba**:
    - Persona 1: Nombre: Juan, Edad: 25, Estado civil: Soltero/a
    - Persona 2: Nombre: Ana, Edad: 30, Estado civil: Casado/a
    - Persona 3: Nombre: Isabel, Edad: 76, Estado civil: Casado/a
  - **Resultado esperado**: La función debe devolver que hay 1 persona soltera y 2 personas casada.

  **Metodo**: verificarAdultoMayor()
    **datos de prueba**:
    - Persona 1: Nombre: Juan, Edad: 25, Estado civil: Soltero/a
    - Persona 2: Nombre: Ana, Edad: 30, Estado civil: Casado/a
    - Persona 3: Nombre: Isabel, Edad: 76, Estado civil: Casado/a
  - **Resultado esperado**: La función debe devolver que hay 1 adulto mayor.

- **Gestión de errores en la entrada**:
  - **Prueba**: Validación de entradas no numéricas en el campo edad.
  - **Resultado esperado**: El programa debe manejar el error y solicitar la entrada del dato nuevamente.

---


