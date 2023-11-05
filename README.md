# TI2-Discretas

## Enunciado problema por desarrollar

### Título del juego 1: Campeones del Hipódromo

#### Descripción del juego


**¡Bienvenido a Campeones del Hipódromo!** En este juego, asumes el papel de un apostador en un hipódromo virtual único. 
Cinco caballos compiten en una pista de carreras única, cada una con su propio camino, lleno de desafíos. 
Cada pista es como un laberinto, y tu elección inicial marcará si eres el ganador.

#### Instrucciones del juego

1. **Elige tu caballo:** Al comienzo del juego, elige el caballo en el que crees que ganará la carrera.
La suerte estará de tu lado.

2. **Apuesta y observa:** Haz tu apuesta y observa cómo los caballos se lanzan a la carrera. 
Cada caballo navega por su pista única, luchando contra obstáculos y desafíos en su camino.

3. **Celebra la victoria:** Cuando el primer caballo cruce la línea de meta, sabrás si has acertado en tu apuesta. 
¡Si tu caballo gana, celebrarás con grandes ganancias!

#### Algoritmo del juego

El juego cuenta con cinco caballos que inician en una pista de carreras al mismo tiempo. 
Cada caballo tiene una pista realizada con 23 vértices y 60 aristas. 
Es decir, cada pista de caballo tiene su grafo. 
Este grafo es recorrido con ayuda de los algoritmos de Dijkstra y Floyd-Warshall. 
Cada arista tiene asignado un peso que es generado al inicio del juego de manera aleatoria. 
A través de hilos y con estos algoritmos, el primer caballo que llegue al último vértice es el ganador.

--------------------------------------------------------------------------------------------------------------------------------------

### Título del juego 2: osu!: El Juego de Ritmo y Precisión

#### Descripción del juego

**osu!** es un emocionante juego de ritmo y precisión que pondrá a prueba tus habilidades de reacción. 
En este juego tu objetivo es seguir patrones y golpear círculos, 
deslizar a lo largo de rutas para obtener la máxima puntuación. 

#### Instrucciones del juego

1. **Selección de Beatmap:** Comienza seleccionando un beatmap, que es el patrón de juego que corresponde a una canción específica. Puedes encontrar una amplia variedad de beatmaps creados por la comunidad en el juego.

2. **Sincronización con la Música:** Una vez que comienza el beatmap, debes sincronizar tus acciones con la música. Presta atención a los círculos, sliders y otros patrones que aparecen en la pantalla. Golpea, desliza o mantén pulsado en el momento preciso en que la música te indique.

3. **Precisión y Puntuación:** Tu precisión y tiempo determinarán tu puntuación. Cuanto más cerca estés del ritmo y más precisas sean tus acciones, mayor será tu puntuación. Además, puedes ganar "combos" al encadenar aciertos consecutivos.

4. **Dificultad Variable:** osu! ofrece beatmaps de diferentes niveles de dificultad, desde principiantes hasta expertos. Elige el que más te desafíe y diviértete superándote a ti mismo.

#### Algoritmo del juego

osu! utiliza algoritmos de grafos para generar patrones de juego en sincronización con la música. Cada beatmap es una secuencia de nodos y conexiones que representan los momentos en que debes interactuar con la pantalla. Los grafos se utilizan para calcular el tiempo de aparición de los círculos y la dirección de los sliders, lo que asegura que el juego se adapte perfectamente a la música y ofrezca una experiencia de juego emocionante.

¡Prepárate para poner a prueba tu ritmo y precisión en osu! y disfruta de una experiencia de juego musical única!
## Enlace al enunciado

[Enlace al enunciado del problema](https://docs.google.com/document/d/10hhjAGeJ64UNWm14GvJy1Y3xHKX2kzeJjCLxbtblADg/edit)
