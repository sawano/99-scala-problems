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

  def table2(f: (Boolean, Boolean) => Boolean) = {
    println("A\t\tB\t\tResult")
    for {a <- List(true, false);
         b <- List(true, false)
    } {
      printf("%s\t%s\t%s\n", a, b, f(a, b))
    }
  }

}

object S99Logicb {
  implicit def s99LogicToBoolean(v: Boolean): S99Logicb = new S99Logicb(v)


  def gray(n: Int): List[String] = {
    if (n == 1) {
      List("0", "1")
    }
    else {
      val l = gray(n - 1)
      l.map('0' +: _) ++ l.reverse.map('1' +: _)
    }
  }

}

class S99Logicb(a: Boolean) {

  import S99Logic.not
  import S99Logicb._

  //P47 Truth tables for logical expressions (2)
  def and(b: Boolean): Boolean = {
    (a, b) match {
      case (true, true) => true
      case _ => false
    }
  }

  def or(b: Boolean): Boolean = {
    (a, b) match {
      case (_, true) => true
      case (true, _) => true
      case _ => false
    }
  }


  def nand(b: Boolean): Boolean = not(a and b)

  def nor(b: Boolean): Boolean = not(a or b)

  def equ(b: Boolean): Boolean = (a and b) or (not(a) and not(b))

  def xor(b: Boolean): Boolean = not(a equ b)

  def impl(b: Boolean): Boolean = not(a) or b

}


