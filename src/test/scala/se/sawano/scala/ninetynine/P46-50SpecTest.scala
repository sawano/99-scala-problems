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

import S99Logic._

@RunWith(classOf[JUnitRunner])
class P46_50SpecTest extends Specification {

  "Calling S99Logic.and" should {
    "return true if a and b are true" in {
      and(true, true) must beTrue
      and(false, true) must beFalse
      and(false, false) must beFalse
      and(true, false) must beFalse
    }
  }
  "Calling S99Logic.or" should {
    "return true if a or b are true" in {
      or(true, true) must beTrue
      or(false, true) must beTrue
      or(false, false) must beFalse
      or(true, false) must beTrue
    }
  }
  "Calling S99Logic.nand" should {
    "return true if a nand b are true" in {
      nand(true, true) must beFalse
      nand(false, true) must beTrue
      nand(false, false) must beTrue
      nand(true, false) must beTrue
    }
  }
  "Calling S99Logic.nor" should {
    "return true if a nor b are true" in {
      nor(true, true) must beFalse
      nor(false, true) must beFalse
      nor(false, false) must beTrue
      nor(true, false) must beFalse
    }
  }
  "Calling S99Logic.equ" should {
    "return true if a equ b are true" in {
      equ(true, true) must beTrue
      equ(false, true) must beFalse
      equ(false, false) must beTrue
      equ(true, false) must beFalse
    }
  }
  "Calling S99Logic.xor" should {
    "return true if a xor b are true" in {
      xor(true, true) must beFalse
      xor(false, true) must beTrue
      xor(false, false) must beFalse
      xor(true, false) must beTrue
    }
  }
  "Calling S99Logic.impl" should {
    "return true if a impl b are true" in {
      impl(true, true) must beTrue
      impl(true, false) must beFalse
      impl(false, true) must beTrue
      impl(false, false) must beTrue
    }
  }
}
