/*
 * Función de Ackermann
 *
 * Esta función recursiva es conocida por crecer muy rapidamente. Es normal
 * que se desborde la pila con números no muy grandes.
 */

package org.ch3m4.algorithms

package object ackermann {

  // Definición recursiva
  def ackermannRec(m: BigInt, n: BigInt): BigInt = {
    assert(m >= 0 && n >= 0, "Los parámetros tienen que ser positivos")
    if (m == 0) n + 1
    else if (n == 0) ackermannRec(m - 1, 1)
    else ackermannRec(m - 1, ackermannRec(m, n - 1))
  }

  // Implementación con desarrollos parciales para m <= 3
  def ackermannPart(m: BigInt, n: BigInt): BigInt = {
    assert(m >= 0 && n >= 0, "Los parámetros tienen que ser positivos")
    if (m == 0) n + 1
    else if (m == 1) n + 2
    else if (m == 2) n * 2 + 3
    else if (m == 3) ((BigInt(1) << n.toInt) - 1) * 8 + 5
    else if (n == 0) ackermannPart(m - 1, 1)
    else ackermannPart(m - 1, ackermannPart(m, n - 1))
  }

  // Implementación con Memonización
  protected val memResults = collection.mutable.Map[(BigInt, BigInt), BigInt]()

  def ackermannMemo(m: BigInt, n: BigInt): BigInt =
    memResults.getOrElseUpdate((m, n), ackermannPart(m, n))

  // La mejor versión
  def ackermann(m: BigInt, n: BigInt): BigInt = ackermannMemo(m, n)

}