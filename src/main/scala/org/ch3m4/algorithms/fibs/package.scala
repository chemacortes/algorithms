/*
 * Sucesión de Fibonacci
 */
package org.ch3m4.algorithms

package object fibs {

  /*
   * Stream de la sucesión de Fibonacci
   */
  lazy val fibs: Stream[BigInt] = BigInt(1) #:: BigInt(1) #:: (fibs zip fibs.tail).map{ case (a,b) => a + b }

  /*
   * Implementación mediante scanLeft
   */

  lazy val fibsScan: Stream[BigInt] = BigInt(1) #:: fibsScan.scanLeft(BigInt(1)){case (acc, x) => acc + x}

}