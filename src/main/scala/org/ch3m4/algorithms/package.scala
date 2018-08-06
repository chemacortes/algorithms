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

	// Retorna tiempo de ejecución en ms
  def time(f: => Any): Double = {
    val s = System.nanoTime
    f
    (System.nanoTime - s) / 1e6
  }

	def timePrint[A](f: => A): A = {
			val s = System.nanoTime
			val ret = f
			println("time: " + (System.nanoTime - s) / 1e6 + "ms")
			ret
		}

}
