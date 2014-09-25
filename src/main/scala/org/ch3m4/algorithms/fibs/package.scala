/*
 * Sucesión de Fibonacci
 */
package org.ch3m4.algorithms

package object fibs {

  /*
   * Stream de la sucesión de Fibonacci
   */
  lazy val fibs: Stream[BigInt] = BigInt(1) #:: BigInt(1) #:: fibs.zip(fibs.tail).map(n => { n._1 + n._2 })

}