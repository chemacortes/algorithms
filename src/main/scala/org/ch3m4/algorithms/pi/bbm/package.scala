package org.ch3m4.algorithms.pi

import spire.math.Rational

/*
 * Cálculo del número Pi por la fórmula de fórmula de Bailey–Borwein–Plouffe
 *
 * Mediante esta fórmula se obtienen de forma directa
 * la secuencia de dígitos hexadecimales
 */

package object bbm {

  // Fórmula de Bailey–Borwein–Plouffe
  def bbm(n: Long) = Rational((120 * n - 89) * n + 16, (((512 * n - 1024) * n + 712) * n - 206) * n + 21)

  // Obtención del primer dígito hexadecimal
  def divMod1(p: Rational): (BigInt, Rational) = {
    val a: BigInt = p.numerator / p.denominator
    (a, p - a)
  }

  // Fórmula recursiva
  private def pirec(x: Rational, n: Long): Stream[String] = {
    val (digit, xnext) = divMod1(16 * x + bbm(n))
    digit.toString(16) #:: pirec(xnext, n + 1)
  }

  // Sucesión (infinita) de dígitos hexadecimales con el número Pi
  val piStream: Stream[String] = pirec(Rational(0), 1)

}
