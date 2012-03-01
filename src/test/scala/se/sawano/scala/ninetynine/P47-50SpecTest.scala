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

import S99Logicb._

@RunWith(classOf[JUnitRunner])
class P47_50SpecTest extends Specification {
  "Calling S99Logicb.gray" should {
    "generate Gray codes" in {
      gray(1) must be equalTo List("0", "1")
      gray(2) must be equalTo List("00", "01", "11", "10")
      gray(3) must be equalTo List("000", "001", "011", "010", "110", "111", "101", "100")
    }
  }
}
