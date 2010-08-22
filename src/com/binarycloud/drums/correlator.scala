package com.binarycloud.drums

import Math.signum



class Correlator(N:Int) {
  // keep the last 100 values in a ring buffer
  val history = new Array[Double](N)
  var i = 0

  def append(value:Double) {
    history(i) = value
    i = (i + 1) % N
  }
  def kendall_tau(template:Array[Double]):Double = {
    // match template against the history buffer. I.e match
    // history[i - length(template):i] against template using
    // http://en.wikipedia.org/wiki/Kendall_tau_rank_correlation_coefficient
    // XXX using the n**2 algortihm for now, move to mergesort later.
    var result = 0.0
    for (j <- 0 to template.length - 1) {
      for (k <- 0 to j - 1) {
	val hj = (i - template.length + j + N) % N // ringbuffer adjustments
	val hk = (i - template.length + k + N) % N
	result += signum(template(j)-template(k))*signum(history(hj) - history(hk))
      }
    }
    return 2 * result / (template.length * (template.length-1))
  }

  def avg(l:Array[Double]):Double = l.foldRight(0.0)(_+_)/l.length
  def stddev(l:Array[Double]):Double = l.foldLeft(0.0)((a, b) => a + (b - avg(l))*(b - avg(l)))

  def pearson(template:Array[Double]):Double = {
    val hist_slice = new Array[Double](template.length)
    for (j <- 0 to template.length - 1) {
      val hj = (i - template.length + j + N) % N // ringbuffer adjustments
      hist_slice(j) = history(hj)
    }
    val all = template.zip(hist_slice)
//    println("a1 %s, a2 %s (f %s __ %s".format(avg(template), avg(hist_slice), s, e, hist_slice.length))
    return all.foldLeft(0.0)((a, b) => a + (b._1 - avg(template)) * (b._2 - avg(hist_slice)) )
  }
}
