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

/**
 * Logic
 */

object S99Logic {

  // P46 Truth tables for logical expressions
  def not(a: Boolean): Boolean = {
    a match {
      case true => false
      case false => true
    }
  }

  def and(a: Boolean, b: Boolean): Boolean = {
    (a, b) match {
      case (true, true) => true
      case _ => false
    }
  }

  def or(a: Boolean, b: Boolean): Boolean = {
    (a, b) match {
      case (_, true) => true
      case (true, _) => true
      case _ => false
    }
  }


  def nand(a: Boolean, b: Boolean): Boolean = not(and(a, b))

  def nor(a: Boolean, b: Boolean): Boolean = not(or(a, b))

  def equ(a: Boolean, b: Boolean): Boolean = or(and(a, b), and(not(a), not(b)))

  def xor(a: Boolean, b: Boolean): Boolean = not(equ(a, b))

  def impl(a: Boolean, b: Boolean): Boolean = or(not(a), b)

}


