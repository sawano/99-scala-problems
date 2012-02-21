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

  // P31 Determine whether a given integer number is prime
  def isPrime: Boolean = (2 until start).find(start % _ == 0) == None

  // P33 Determine whether two positive integer numbers are coprime
  def isCoprimeTo(that: Int): Boolean = S99Int.gcd(start, that) == 1

  // P34 Calculate Euler's totient function phi(m)
  // Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
  def totient: Int = (1 to start).filter(isCoprimeTo(_)).size

  // P35 Determine the prime factors of a given positive integer
  def primeFactors: List[Int] = Nil
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
}


