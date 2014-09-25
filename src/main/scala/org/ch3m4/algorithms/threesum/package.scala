/*
 * Este algoritmo consiste en encontrar todas las ternas de números de una
 * secuencia cuya suma sea 0
 *
 * Por fuerza bruta, la complejidad algorítmica es O(n^3), pero con una
 * ordenación previa y una posterior búsqueda binaria, la complejidad se
 * reduce a O(n^2 log n)
 *
 */

package org.ch3m4.algorithms

package object threesum {

  import binarysearch.binarySearch

  type Terna = (Int, Int, Int)

  // Fuerza Bruta O(n^3)
  def threesumBrute(lst: List[Int]): Seq[Terna] = {
    lst.combinations(3).collect { case List(a, b, c) if (a + b + c == 0) => (a, b, c) }.toSeq
  }

  // Implementación funcional O(n^2 log n)
  def threesumFunc(lst: Vector[Int]): Seq[Terna] = {

    def tails(lst: Vector[Int]): Seq[Vector[Int]] =
      if (lst.size == 0)
        Nil
      else
        lst +: tails(lst.tail)

    for {
      // Double loop O(n^2)
      a +: tail1 <- tails(lst.sorted) // sorted O(n log n)
      b +: tail2 <- tails(tail1)
      c = -(a + b)
      if (binarySearch(tail2)(c)) // binary sort O(log n)
    } yield (a, b, c)
  }

  // Implementación imperativa O(n^2 log n)
  def threesum(lst: Vector[Int]): Seq[Terna] = {

    val lst2 = lst.sorted // O(n log n)

    for {
      // Double loop O(n^2)
      i <- 0 until lst2.size
      j <- i + 1 until lst2.size
      (a, b) = (lst2(i), lst2(j))
      c = -(a + b)
      if (binarySearch(lst2)(c, j + 1)) // O(log n)
    } yield (a, b, c)
  }

}