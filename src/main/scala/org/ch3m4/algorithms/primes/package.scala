/*
 * Diversos algoritmos para calcular números primos
 */
package org.ch3m4.algorithms

package object primes {

  /*
   * Stream infinito de números primos
   */
  lazy val primes: Stream[Int] = 2 #:: Stream.from(3, 2)
    .filter(i => primes.takeWhile(j => j * j <= i).forall(k => i % k > 0))

  /*
   * Chequeo de primos
   *
   * isPrime(2) == true
   * isPrime(22) == true
   */
  def isPrime(n: Int) = primes.takeWhile(_ <= n).last == n

  /*
   * Devuelve un rango de números primos
   *
   * range(10, 20) --> List(11, 13, 17, 19)
   */
  def range(from: Int, to: Int) = primes.dropWhile(_ < from).takeWhile(_ <= to)

}