package org.ch3m4

package object algorithms {

  /*
	 * Función de utilidad para calcular tiempos de ejecución
	 *
	 * Uso:
	 *
	 * time {
	 * 		bloque
	 * }
	 */
  def time[A](f: => A) = {
    val s = System.nanoTime
    val ret = f
    println("time: " + (System.nanoTime - s) / 1e6 + "ms")
    ret
  }

}
