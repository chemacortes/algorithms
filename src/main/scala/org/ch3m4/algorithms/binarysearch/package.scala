/*
 * Búsqueda binaria sobre secuencias ordenadas
 *
 * La complejidad algorítmica es de O(log n) frente a O(n) de una búsqueda normal
 */

package org.ch3m4.algorithms

package object binarysearch {

  /*
   * Búsqueda binaria sobre secuencias ordenadas
   *
   * Se emplea Vector por ser más rápido en acceso aleatorio
   * El Vector debe estar ordenado
   *
   * El bug al calcular el punto medio está documentado en la literatura. Debería
   * ser (start + end)/2 , pero da un error de desbordamiento cuando se usan
   * enteros alrededor de 2^30. Usando el operador bitshift >>> no se da este
   * problema.
   *
   */
  def binarySearch[A: Ordering](v: Vector[A])(target: A, start: Int = 0, end: Int = v.size - 1): Boolean = {
    val ord = implicitly[Ordering[A]]

    def bsf(start: Int, end: Int): Boolean =
      if (start > end)
        false
      else {
        val mid = (start + end) >>> 1 // Fixed bug with N ~ 2^30
        ord.compare(v(mid), target) match {
          case 0  => true
          case -1 => bsf(mid + 1, end)
          case _  => bsf(start, mid - 1)
        }
      }

    bsf(start, end)
  }

}