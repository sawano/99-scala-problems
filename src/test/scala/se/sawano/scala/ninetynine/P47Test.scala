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

import org.junit.Test
import org.junit.Assert._

class P47Test {

  import S99Logicb._
  import S99Logic.not

  @Test
  def callTable2 {
    S99Logic.table2((a: Boolean, b: Boolean) => a and (a or not(b)))
    assertTrue(true)
  }
}