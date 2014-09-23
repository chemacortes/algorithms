/*
 * Criba de Eratóstenes (Sieve of Eratosthenes)
 */

package org.ch3m4.algorithms

object sieve {

  /*
   * Utiliza un objeto BitSet para señalar los números cribados
   *
   * sieve(10) -> List(2,3,5,7)
   */
  def apply(n: Int) = {
    val isPrime = collection.mutable.BitSet(2) ++ (3 to n by 2)
    for (p <- 2 to Math.sqrt(n).toInt if isPrime(p)) {
      isPrime --= p * p to n by p
    }
    isPrime.toList
  }

}