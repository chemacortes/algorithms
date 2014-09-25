/*
 * Criba de Eratóstenes (Sieve of Eratosthenes)
 */

package org.ch3m4.algorithms.primes

package object sieve {

  /*
   * Definición recursiva de la criba de Eratóstenes
   *
   * Para obtener una serie de números primos:
   *
   * val primes = sieve(Stream.from(2))
   *
   */
  def sieveRecursive(s: Stream[Int]): Stream[Int] =
    s.head #:: sieveRecursive(s.tail filter (_ % s.head != 0))

  /*
   * Utiliza un objeto BitSet para señalar los números cribados,
   * un método muy directo y eficiente
   *
   * sieve(10) -> BitSet(2,3,5,7)
   */
  def sieveBitSet(n: Int) = {
    val isPrime = collection.mutable.BitSet(2) ++ (3 to n by 2)
    for (p <- 2 to Math.sqrt(n).toInt if isPrime(p)) {
      isPrime --= p * p to n by p
    }
    isPrime.toImmutable
  }

  /*
   * Implementación para uso general
   */
  def sieve(n: Int): List[Int] = sieveBitSet(n: Int).toList

}