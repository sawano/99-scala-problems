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
}
