algorithms
==========

Algunos algoritmos famosos, reprogramados según la programación funcional ([lenguaje scala][scala])



[scala]: http://scala-lang.org/ "The Scala Programming Language - official site"


## Cálculo de tiempos

Se incluye la función `time` para cálculo de tiempos de ejecución para poder comparar la eficiencia de los distintos algoritmos. Se usa creando un bloque de ejecución:

    time {
    	algoritmo()
    }

## Números primos

[package primes](https://github.com/chemacortes/algorithms/blob/master/src/main/scala/org/ch3m4/algorithms/primes/package.scala) - Secuencia infinita (<em>Stream</em>) de números primos:

[package primes.sieve](https://github.com/chemacortes/algorithms/blob/master/src/main/scala/org/ch3m4/algorithms/primes/sieve/package.scala) - Criba de Eratóstenes:

## Sucesión de Fibonacci
[package fibs](https://github.com/chemacortes/algorithms/blob/master/src/main/scala/org/ch3m4/algorithms/fibs/package.scala)

## Búsqueda Binaria
[package binarySearch](https://github.com/chemacortes/algorithms/tree/master/src/main/scala/org/ch3m4/algorithms/binarysearch) - Búsqueda en listas ordenadas de números. La complejidad algorítmica se reduce a <em>O(log n)</em>, por lo que se emplea en numerosos algoritmos que tienen de entrada una lista ordenada.

## Suma de tres
[package threesum](https://github.com/chemacortes/algorithms/blob/master/src/main/scala/org/ch3m4/algorithms/threesum/package.scala) - Búsqueda dentro de una lista de tres números cuya suma sea cero. Es un algoritmo que reduce la complejidad algoritmica de <em>O(n^3)</em> a <em>O(n^2 log n)</em>.

## Función de Ackermann
[package ackermann](https://github.com/chemacortes/algorithms/blob/master/src/main/scala/org/ch3m4/algorithms/ackermann/package.scala) -
Esta función recursiva es conocida por crecer muy rápidamente y desbordar la pila de cálculo, incluso con valores pequeños.

- **ackermann**: Alias a la mejor implementación conseguida (*=ackermannMemo*)
- **ackermannRec**: Definición recursiva
- **ackermannPart**: Definición recursiva con algunos términos desarrollados de valores pequeños
- **ackermannMemo**: Definición con *memonización* para evitar calcular términos ya calculados
