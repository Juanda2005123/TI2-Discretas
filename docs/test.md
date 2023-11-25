## Tabla de Clases, Métodos, Escenarios, Valores de Entrada y Resultado Esperado

### AddStudent, EditStudent, RemoveStudent y SearchStudent 

| Clase           | Método                | Escenario           | Valores de Entrada                  | Resultado Esperado               |
| --------------- | --------------------- | ------------------- | ----------------------------------- | --------------------------------- |
| AddStudentTest  | addStudentTest        | Agregar estudiante válido         | "Juan David", "Quintero", "001", +18, 1.90, 1, 1.3, 2.4, 3.1, 3.2 | Éxito en la adición del estudiante |
| AddStudentTest  | addMoreStudentsTest   | Agregar varios estudiantes válidos | Varios estudiantes con datos válidos | Éxito en la adición de estudiantes |
| AddStudentTest  | addStudentSameIdTest  | Agregar estudiante con el mismo ID (excepción) | Estudiante con ID duplicado | Excepción SameCodeStudentException |
| EditStudentTest | editStudentTest       | Editar estudiante existente (éxito) | Estudiante existente, datos de edición válidos | Éxito en la edición del estudiante |
| EditStudentTest | editMoreStudentsTest  | Editar varios estudiantes existentes (éxito) | Varios estudiantes existentes, datos de edición válidos | Éxito en la edición de estudiantes |
| EditStudentTest | editNotFoundStudentTest | Editar estudiante no encontrado (excepción) | Estudiante no encontrado, datos de edición válidos | Excepción NotFoundStudentException |
| EditStudentTest | editStudentEmptyStructureTest | Editar en estructura de estudiantes vacía (excepción) | Estructura de estudiantes vacía, datos de edición válidos | Excepción EmptyStudentListException |
| RemoveStudentTest | removeStudentTest   | Eliminar estudiante existente (éxito) | Estudiante existente | Éxito en la eliminación del estudiante |
| RemoveStudentTest | removeMoreStudentsTest | Eliminar varios estudiantes existentes (éxito) | Varios estudiantes existentes | Éxito en la eliminación de estudiantes |
| RemoveStudentTest | removeNotExistingStudentTest | Eliminar estudiante no existente (excepción) | Estudiante no encontrado | Excepción NotFoundStudentException |
| RemoveStudentTest | removeStudentEmptyStructureTest | Eliminar en estructura de estudiantes vacía (excepción) | Estructura de estudiantes vacía | Excepción EmptyStudentListException |
| SearchStudentTest | searchStudentTest   | Buscar estudiante existente (éxito) | Estudiante existente | Datos del estudiante coinciden |
| SearchStudentTest | searchMoreStudentsTest | Buscar varios estudiantes existentes (éxito) | Varios estudiantes existentes | Datos de los estudiantes coinciden |
| SearchStudentTest | searchNotFoundStudentTest | Buscar estudiante no existente (excepción) | Estudiante no encontrado | Excepción NotFoundStudentException |
| SearchStudentTest | searchStudentEmptyStructureTest | Buscar en estructura de estudiantes vacía (excepción) | Estructura de estudiantes vacía | Excepción EmptyStudentListException |

### UploadStudent y LoadStudent

| Clase              | Método             | Escenario                                       | Valores de Entrada                  | Resultado Esperado                 |
| ------------------ | ------------------ | ----------------------------------------------- | ----------------------------------- | --------------------------------- |
| UploadStudentTest  | emptyUploadDataTest | Cargar datos vacíos                             | Datos vacíos                        | Éxito en la carga de datos vacíos |
| UploadStudentTest  | uploadStudentList  | Cargar lista de estudiantes                     | Lista de estudiantes válida         | Éxito en la carga de la lista de estudiantes |
| UploadStudentTest  | uploadMoreStudentTest | Cargar múltiples estudiantes                    | Múltiples estudiantes válidos       | Éxito en la carga de múltiples estudiantes |
| LoadStudentTest    | emptyLoadDataTest  | Cargar datos vacíos                             | Datos vacíos                        | Éxito en la carga de datos vacíos |
| LoadStudentTest    | loadStudentTest    | Cargar un estudiante                           | Estudiante válido                   | Éxito en la carga del estudiante   |
| LoadStudentTest    | loadStudentMoreStudentTest | Cargar varios estudiantes              | Varios estudiantes válidos         | Éxito en la carga de varios estudiantes |
| LoadStudentTest    | loadProgramStudentsTest | Cargar estudiantes desde el programa y verificar coincidencia | Estudiantes en el programa | Coincidencia con estudiantes cargados |
| LoadStudentTest    | loadProgramStudentsAndAddStudentTest | Cargar estudiantes desde el programa, agregar uno y verificar coincidencia | Estudiantes en el programa, agregar uno | Coincidencia con estudiantes cargados después de agregar uno |
| LoadStudentTest    | loadProgramStudentsAndEditSearchStudentTest | Cargar estudiantes desde el programa, editar uno y verificar no coincidencia | Estudiantes en el programa, editar uno | No coincidencia con el estudiante después de la edición |
| LoadStudentTest    | loadProgramStudentAndRemoveStudentTest | Cargar estudiantes desde el programa, agregar uno, eliminarlo y verificar excepción | Estudiantes en el programa, agregar uno, eliminarlo | Excepción al intentar mostrar un estudiante eliminado |

--------------------------------------------------
## Tabla de Nombres, Clases y Escenarios de los Tests

### AddStudent, EditStudent, RemoveStudent y SearchStudent

| Nombre del Test          | Clase         | Escenario                                       |
| ------------------------ | -------------  | ----------------------------------------------- |
| addStudentTest           | AddStudentTest | Agregar estudiante válido                       |
| addMoreStudentsTest      | AddStudentTest | Agregar varios estudiantes válidos              |
| addStudentSameIdTest     | AddStudentTest | Agregar estudiante con el mismo ID (excepción) |
| editStudentTest          | EditStudentTest | Editar estudiante existente (éxito)            |
| editMoreStudentsTest     | EditStudentTest | Editar varios estudiantes existentes (éxito)   |
| editNotFoundStudentTest  | EditStudentTest | Editar estudiante no encontrado (excepción)     |
| editStudentEmptyStructureTest | EditStudentTest | Editar en una estructura de estudiantes vacía (excepción) |
| removeStudentTest        | RemoveStudentTest | Eliminar estudiante existente (éxito)         |
| removeMoreStudentsTest   | RemoveStudentTest | Eliminar varios estudiantes existentes (éxito) |
| removeNotExistingStudentTest | RemoveStudentTest | Eliminar estudiante que no existe (excepción) |
| removeStudentEmptyStructureTest | RemoveStudentTest | Eliminar en estructura de estudiantes vacía (excepción) |
| searchStudentTest        | SearchStudentTest | Buscar estudiante existente (éxito)           |
| searchMoreStudentsTest   | SearchStudentTest | Buscar varios estudiantes existentes (éxito)  |
| searchNotFoundStudentTest | SearchStudentTest | Buscar estudiante que no existe (excepción)   |
| searchStudentEmptyStructureTest | SearchStudentTest | Buscar en estructura de estudiantes vacía (excepción) |

### UploadStudent y LoadStudent

| Nombre del Test             | Clase            | Escenario                                       |
| --------------------------- | ----------------  | ----------------------------------------------- |
| emptyUploadDataTest        | UploadStudentTest | Cargar datos vacíos                             |
| uploadStudentList           | UploadStudentTest | Cargar lista de estudiantes                     |
| uploadMoreStudentTest      | UploadStudentTest | Cargar múltiples estudiantes                    |
| emptyLoadDataTest          | LoadStudentTest   | Cargar datos vacíos                             |
| loadStudentTest            | LoadStudentTest   | Cargar un estudiante                           |
| loadStudentMoreStudentTest | LoadStudentTest   | Cargar varios estudiantes                       |
| loadProgramStudentsTest    | LoadStudentTest   | Cargar estudiantes desde el programa y verificar coincidencia |
| loadProgramStudentsAndAddStudentTest | LoadStudentTest | Cargar estudiantes desde el programa, agregar uno y verificar coincidencia |
| loadProgramStudentsAndEditSearchStudentTest | LoadStudentTest | Cargar estudiantes desde el programa, editar uno y verificar no coincidencia |
| loadProgramStudentAndRemoveStudentTest   | LoadStudentTest | Cargar estudiantes desde el programa, agregar uno, eliminarlo y verificar excepción |


### Graphs


| Clase            | Método        | Escenario                                      | Valores de Entrada                                | Resultado Esperado                   |
| ---------------- | ------------- | ---------------------------------------------- | -------------------------------------------------- | ----------------------------------- |
| GraphListTest     | addVertex      | Agregar vértice                                | (1, 2, 3), (2, 3, 4)                             | El vértice 2 debe estar en la lista |
| GraphListTest     | addVertex      | Agregar vértice                                | (1, 2, 3), (2, 3, 4)                             | El vértice 4 no debe estar en la lista |
| GraphListTest     | addVertex      | Agregar vértice                                | (1, 2, 3), (2, 3, 4), (3, 4, 1)                 | El vértice 3 no debe estar en la lista |
| GraphListTest     | fillMatrix     | Llenar matriz de adyacencia                   | (1, 2, 3), (2, 3, 4), (3, 4, 1)                 | La matriz debe contener valores correctos |
| GraphListTest     | fillMatrix     | Llenar matriz de adyacencia                   | (1, 2, 3), (2, 3, 4), (3, 4, 1)                 | La matriz debe contener valores correctos |
| GraphListTest     | fillMatrix     | Llenar matriz de adyacencia                   | (1, 2, 3), (2, 3, 4), (3, 4, 1)                 | La matriz debe contener valores correctos |
| GraphListTest     | addVertexDirigido | Agregar vértice dirigido                    | (1, 2, 3), (2, 3, 4), (3, 4, 5), (4, 5, 6), (5, 6, 7) | No debe haber camino de 6 a 1        |
| GraphListTest     | addVertexDirigido | Agregar vértice dirigido                    | (1, 2, 3), (2, 3, 4), (3, 4, 5), (4, 5, 6), (5, 6, 7) | No debe haber conexión entre 2 y 1   |
| GraphListTest     | addVertexDirigido | Agregar vértice dirigido                    | (1, 2, 3), (2, 3, 4), (3, 4, 5), (4, 5, 6), (5, 6, 7) | Debe haber conexión entre 1 y 2      |
| GraphListTest     | deleteVertex   | Eliminar vértice                              | (1, 2, 3), (2, 3, 4), (3, 4, 1), vertex = 1     | El vértice 2 debe estar en la lista |
| GraphListTest     | deleteVertex   | Eliminar vértice                              | ("MaloH", "Agua", 11), ("Agua", "No puede ser", 12), ("Locura", "Descontrol", 2) | "MaloH" no debe estar conectado a "Agua" |
| GraphListTest     | deleteVertex   | Eliminar vértice                              | (1, 2, 3), (2, 3, 4), vertex = 2                 | Debe haber un camino de 1 a 3       |
| GraphListTest     | deleteEdge     | Eliminar arista                               | (1, 2, 3), (2, 3, 4), (3, 4, 5), edge = (2, 3)    | El vértice 1 debe estar en la lista |
| GraphListTest     | deleteEdge     | Eliminar arista                               | (1, 2, 3), (2, 3, 4), (3, 4, 5), edge = (2, 3)    | No debe haber conexión entre 2 y 3 |
| GraphListTest     | deleteEdge     | Eliminar arista                               | (1, 2, 3), (2, 3, 4), (3, 4, 5), edge = (3, 4)    | No debe haber conexión entre 3 y 4 |
| GraphListTest     | getEdgeWeight  | Obtener peso de arista                        | (1, 2, 3), (2, 3, 4), edge = (2, 3)                | Debe devolver 4                      |
| GraphListTest     | getEdgeWeight  | Obtener peso de arista                        | ('A', 'B', 5), ('A', 'C', 10), ('B', 'C', 3), edge = ('B', 'C') | Debe devolver 3                      |
| GraphListTest     | getEdgeWeight  | Obtener peso de arista                        | ("MaloH", "Agua", 12), ("Agua", "No puede ser", 12), edge = ("Locura", "MaloH") | No debe devolver 12                   |
| GraphListTest     | checkConnect   | Verificar conexión entre vértices            | (1, 2, 3), (2, 3, 4), vertex1 = 1, vertex2 = 2    | Debe devolver true                   |
| GraphListTest     | checkConnect   | Verificar conexión entre vértices            | (1, 2, 3), (2, 3, 4), vertex1 = 1, vertex2 = 3    | Debe devolver false                  |
| GraphListTest     | checkConnect   | Verificar conexión entre vértices            | ('A', 'B', 5), ('A', 'C', 10), ('B', 'C', 3), vertex1 = 'A', vertex2 = 'E' | Debe devolver false                  |
| GraphListTest     | testDijkstra   | Realizar prueba de Dijkstra                   | ('A', 'B', 5), ('A', 'C', 10), ('B', 'C', 3), start = 'A', destination = 'C' | Debe devolver 8                       |
| GraphListTest     | testDijkstra   | Realizar prueba de Dijkstra                   | ('A', 'B', 7), ('A', 'C', 10), ('B', 'C', 4), start = 'A', destination = 'C' | Debe devolver 10                      |
| GraphListTest     | testDijkstra   | Real

izar prueba de Dijkstra                   | ('A', 'D', 7), ('A', 'H', 10), ('B', 'C', 4), start = 'A', destination = 'C' | Debe devolver -1                      |

### Métodos del código en formato de tabla

| Nombre del Test                       | Clase            | Escenario                                       |
| ------------------------------------- | ---------------- | ----------------------------------------------- |
| addVertex                             | GraphListTest     | Agregar vértice                                 |
| addVertex2                            | GraphListTest     | Agregar vértice                                 |
| addVertex3                            | GraphListTest     | Agregar vértice                                 |
| fillMatrix                            | GraphListTest     | Llenar matriz de adyacencia                    |
| fillMatrix2                           | GraphListTest     | Llenar matriz de adyacencia                    |
| fillMatrix3                           | GraphListTest     | Llenar matriz de adyacencia                    |
| addVertexDirigido                     | GraphListTest     | Agregar vértice dirigido                       |
| addVertexDirigido2                    | GraphListTest     | Agregar vértice dirigido                       |
| addVertexDirigido3                    | GraphListTest     | Agregar vértice dirigido                       |
| deleteVertex                          | GraphListTest     | Eliminar vértice                               |
| deleteVertex2                         | GraphListTest     | Eliminar vértice                               |
| deleteVertex3                         | GraphListTest     | Eliminar vértice                               |
| deleteEdge                            | GraphListTest     | Eliminar arista                                |
| deleteEdge2                           | GraphListTest     | Eliminar arista                                |
| deleteEdge3                           | GraphListTest     | Eliminar arista                                |
| getEdgeWeight                         | GraphListTest     | Obtener peso de arista                         |
| getEdgeWeight2                        | GraphListTest     | Obtener peso de arista                         |
| getEdgeWeight3                        | GraphListTest     | Obtener peso de arista                         |
| checkConnect                          | GraphListTest     | Verificar conexión entre vértices             |
| checkConnect2                         | GraphListTest     | Verificar conexión entre vértices             |
| checkConnect3                         | GraphListTest     | Verificar conexión entre vértices             |
| testDijkstra                          | GraphListTest     | Realizar prueba de Dijkstra                    |
| testDijkstra2                         | GraphListTest     | Realizar prueba de Dijkstra                    |
| testDijkstra3                         | GraphListTest     | Realizar prueba de Dijkstra                    |
| floydWarshall                         | GraphListTest     | Aplicar algoritmo de Floyd-Warshall            |
| floydWarshall2                        | GraphListTest     | Aplicar algoritmo de Floyd-Warshall            |
| floydWarshall3                        | GraphListTest     | Aplicar algoritmo de Floyd-Warshall            |

