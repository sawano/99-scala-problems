/*
 * Copyright 2012 Daniel Sawano
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * These problems are taken from the "S-99 Ninety-Nine Scala Problems" http://aperiodic.net/phil/scala/s-99/ﬁ
 */

package se.sawano.scala.ninetynine

/**
 * Arithmetic
 */

class S99Int(val start: Int) {

  import S99Int._

  // P31 Determine whether a given integer number is prime
  def isPrime: Boolean = (2 until start).find(start % _ == 0) == None

  // P33 Determine whether two positive integer numbers are coprime
  def isCoprimeTo(that: Int): Boolean = S99Int.gcd(start, that) == 1

  // P34 Calculate Euler's totient function phi(m)
  // Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
  def totient: Int = (1 to start).filter(isCoprimeTo(_)).size

  // P35 Determine the prime factors of a given positive integer
  def primeFactors: List[Int] = {
    (2 until start).toList filter (x => start % x == 0 && x.isPrime) flatMap {
      prime => multiplicity(start, prime)
    }
  }

  private def multiplicity(i: Int, prime: Int): List[Int] = {
    if (i <= prime)
      Nil
    else if (i % prime == 0)
      prime +: multiplicity(i / prime, prime)
    else
      multiplicity(i / prime, prime)
  }

  // P36 Determine the prime factors of a given positive integer (2)
  def primeFactorMultiplicity: List[(Int, Int)] = {
    (2 until start).toList filter (x => start % x == 0 && x.isPrime) map {
      prime => (prime, multiplicity(start, prime).size)
    }
  }

  // P37 Calculate Euler's totient function phi(m) (improved)
  def totient2: Int = primeFactorMultiplicity map (x => (x._1 - 1) * (math.pow(x._1, x._2 - 1).toInt)) product


  //P40  Goldbach's conjecture
  def goldbach: (Int, Int) = {
    val l: List[(Int, Int)] = allGoldbachs
    if (l.isEmpty)
      null
    else
      l.head
  }

  private def allGoldbachs: List[(Int, Int)] = {
    val primes: List[Int] = (2 to start).toList filter (_.isPrime)
    primes map {
      x => val m = primes.find(_ + x == start)
      if (m.isDefined)
        (x, m.get)
      else
        null
    } filter (_ != null)
  }


}

object S99Int {
  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)

  // P32 Determine the greatest common divisor of two positive integer numbers
  def gcd(i: Int, k: Int): Int = {
    val min = i.min(k)
    val max = i.max(k)

    if (min == 0) {
      max
    }
    else {
      gcd(max % min, min)
    }
  }

  // P38 Compare the two methods of calculating Euler's totient function
  def compareTotients = {
    val t1 = System.currentTimeMillis()
    10090 totient
    val t2 = System.currentTimeMillis()
    10090 totient2
    val t3 = System.currentTimeMillis()
    printf("totient: %d ms, totient2: %d ms", t2 - t1, t3 - t2)
  }

  // P39 A list of prime numbers
  def listPrimesInRange(numbers: Range): List[Int] = numbers.toList filter (_.isPrime)

  // P41 A list of Goldbach compositions
  def printGoldbachList(r: Range) = {
    r foreach {
      x =>
        if (x % 2 == 0) {
          val goldbach: (Int, Int) = x.goldbach
          printf("%d = %d + %d\n", x, goldbach._1, goldbach._2)
        }
    }
  }

  // P41 b
  def printGoldbachListLimited(r: Range, min: Int) = {
    r foreach {
      x =>
        if (x % 2 == 0) {
          val goldbach: (Int, Int) = x.goldbach
          if (goldbach != null && goldbach._1 > min && goldbach._2 > min)
            printf("%d = %d + %d\n", x, goldbach._1, goldbach._2)
        }
    }
  }
}


