/*
 * Construcci�n de una serie infinita (stream) de n�meros primos
 * basado en la definici�n de primo
 */

package org.ch3m4.algorithms

object LazyPrimes {

  /*
   * Stream infinito de n�meros primos
   */
  lazy val primes: Stream[Int] = 2 #:: Stream.from(3, 2)
    .filter(i => primes.takeWhile { j => j * j <= i }.forall { k => i % k > 0 })

  /*
	 * Chequeo de primos
	 *
	 * isPrime(2) == true
	 * isPrime(22) == true
	 */
  def isPrime(n: Int) = primes.takeWhile(_ <= n).contains(n)

  /*
	 * Devuelve un rango de n�meros primos
	 *
	 * range(10, 20) --> List(11, 13, 17, 19)
	 */
  def range(from: Int, to: Int) = primes.dropWhile(_ < from).takeWhile(_ <= to)

}