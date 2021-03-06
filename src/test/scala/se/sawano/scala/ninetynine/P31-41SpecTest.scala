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

package se.sawano.scala.ninetynine

/**
 * These problems are taken from the "S-99 Ninety-Nine Scala Problems" http://aperiodic.net/phil/scala/s-99/ﬁ
 */

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.Specification

import S99Int._

@RunWith(classOf[JUnitRunner])
class P31_41SpecTest extends Specification {

  "Calling S99Int.isPrime" should {
    "return true if a number is a prime number" in {
      7.isPrime must beTrue
      509.isPrime must beTrue
      937.isPrime must beTrue
    }
    "return false if a number is not a prime number" in {
      45.isPrime must beFalse
      243.isPrime must beFalse
    }
  }
  "Calling S99Int.gcd" should {
    "return the greatest common divisor of two positive integers" in {
      gcd(36, 63) must be equalTo 9
    }
  }
  "Calling S99Int.isCoPrimeTo" should {
    "determine whether two positive integer numbers are coprime" in {
      35.isCoprimeTo(64) must beTrue
      4.isCoprimeTo(8) must beFalse
    }
  }
  "Calling S99Int.totient" should {
    "calculate Euler's totient function phi(m)" in {
      10.totient must be equalTo 4
    }
  }
  "Calling S99Int.primeFactors" should {
    "determine the prime factors of a given positive integer" in {
      315.primeFactors must be equalTo List(3, 3, 5, 7)
    }
  }
  "Calling S99Int.primeFactorMultiplicity" should {
    "construct a list containing the prime factors and their multiplicity" in {
      315.primeFactorMultiplicity must be equalTo List((3, 2), (5, 1), (7, 1))
    }
  }
  "Calling S99Int.totient2" should {
    "calculate Euler's totient function phi(m)" in {
      10.totient2 must be equalTo 4
    }
  }
  "Calling S99Int.compareTotients" should {
    "compare the two methods of calculating Euler's totient function" in {
      S99Int.compareTotients
      success
    }
  }
  "Calling S99Int.listPrimesInRange" should {
    "return a list of prime numbers" in {
      S99Int.listPrimesInRange(7 to 31) must be equalTo List(7, 11, 13, 17, 19, 23, 29, 31)
    }
  }
  "Calling S99Int.goldbach" should {
    "return the two primes whose sum is the current int" in {
      28.goldbach must be equalTo(5, 23)
    }
  }
  "Calling S99Int.printGoldbachList" should {
    "print the result" in {
      S99Int.printGoldbachList(9 to 20)
      success
    }
  }
  "Calling S99Int.printGoldbachListLimited" should {
    "print the result" in {
      S99Int.printGoldbachListLimited(1 to 2000, 50)
      success
    }
  }
}
