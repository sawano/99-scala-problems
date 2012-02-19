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

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.Specification

@RunWith(classOf[JUnitRunner])
class P01_28Spec extends Specification {

  "Calling P01.last" should {
    "return the last element" in {
      P01.last(List(1, 1, 2, 3, 5, 8)) must be equalTo 8
    }
  }
  "Calling P02.penultimate" should {
    "return the second last element" in {
      P02.penultimate(List(1, 1, 2, 3, 5, 8)) must be equalTo 5
      P02.penultimate(List(8)) must be equalTo 8
    }
  }
  "Calling P03.nth" should {
    "return the Nth element" in {
      P03.nth(2, List(1, 1, 2, 3, 5, 8)) must be equalTo 2
      P03.nth(0, List(1, 6, 2, 3, 5, 8)) must be equalTo 1
      P03.nth(4, List(1, 6, 2, 3, 5, 8)) must be equalTo 5
    }
  }
  "Calling P04.length" should {
    "return the length of the list" in {
      P04.length(List(1, 1, 2, 3, 5, 8)) == 6
      P04.length(List(1, 1, 2)) == 3
    }
  }
  "Calling P05.reverse" should {
    "return the reversed list" in {
      P05.reverse(List(1, 1, 2, 3, 5, 8)) must be equalTo List(8, 5, 3, 2, 1, 1)
    }
  }
  "Calling P06.isPalindrome" should {
    "return true for palindrome lists" in {
      P06.isPalindrome(List(1, 2, 3, 2, 1)) must beTrue
      P06.isPalindrome(List(1, 2, 3, 3, 1)) must beFalse
    }
  }
  "Calling P07.flatten" should {
    "return a flattened list" in {
      P07.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) must be equalTo List(1, 1, 2, 3, 5, 8)
    }
  }
  "Calling P08.compress" should {
    "remove duplicates" in {
      P08.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) must be equalTo List('a, 'b, 'c, 'a, 'd, 'e)
    }
  }
  "Calling P09.pack" should {
    "place each element group in separate lists" in {
      P09.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) must
        be equalTo List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    }
  }
  "Calling P10.encode" should {
    "encode the given list" in {
      P10.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) must
        be equalTo List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    }
  }
  "Calling P11.encodeModified" should {
    "encode the given list" in {
      P11.encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) must
        be equalTo List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))
    }
  }
  "Calling P12.decode" should {
    "return an uncopmressed list" in {
      P12.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) must
        be equalTo List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    }
  }
  "Calling P13.encodeDirect" should {
    "return an encoded list" in {
      P13.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) must
        be equalTo List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    }
  }
  "Calling P14.duplicate" should {
    "duplicate all elements" in {
      P14.duplicate(List('a, 'b, 'c, 'c, 'd)) must
        be equalTo List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    }
  }
  "Calling P15.duplicateN" should {
    "duplicate all elements N times" in {
      P15.duplicateN(3, List('a, 'b, 'c, 'c, 'd)) must
        be equalTo List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
    }
  }
  "Calling P16.drop" should {
    "drop every Nth element" in {
      P16.drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) must
        be equalTo List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    }
  }
  "Calling P17.split" should {
    "split the list correctly" in {
      P17.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) must
        be equalTo (List('a, 'b, 'c) -> List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    }
  }
  "Calling P18.slice" should {
    "extract a slice from the list" in {
      P18.slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) must
        be equalTo List('d, 'e, 'f, 'g)
    }
  }
  "Calling P19.rotate" should {
    "rotate a list N places to the left" in {
      P19.rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) must
        be equalTo List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
      P19.rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) must
        be equalTo List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
      P19.rotate(4, List()) must not(throwAn[Exception])
    }
  }
  "Calling P20.removeAt" should {
    "remove the Kth element" in {
      P20.removeAt(1, List('a, 'b, 'c, 'd)) must
        be equalTo ((List('a, 'c, 'd), 'b))
      P20.removeAt(9, List('a, 'b, 'c, 'd)) must throwAn[IndexOutOfBoundsException]
    }
  }
  "Calling P21.insertAt" should {
    "insert an element at a given position" in {
      P21.insertAt('new, 1, List('a, 'b, 'c, 'd)) must
        be equalTo List('a, 'new, 'b, 'c, 'd)
    }
  }
  "Calling P22.range" should {
    "create a list with integers from a range" in {
      P22.range(4, 9) must be equalTo List(4, 5, 6, 7, 8, 9)
    }
  }
  "Calling P23.randomSelect" should {
    "extract random numbers" in {
      P23.randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)).size must be equalTo 3
      List('a, 'b, 'c, 'd, 'f, 'g, 'h) must containAllOf(P23.randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    }
  }
  "Calling P24.lotto" should {
    "generate random numbers within a given range" in {
      P24.lotto(6, 49).size must be equalTo 6
      (1 to 49).toList must containAllOf(P24.lotto(6, 49))
    }
  }
  "Calling P25.randomPermute" should {
    "randomly shuffle the elements" in {
      P25.randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)) must not equalTo List('a, 'b, 'c, 'd, 'e, 'f)
      P25.randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)) must containAllOf(List('a, 'b, 'c, 'd, 'e, 'f))
    }
  }
  "Calling P26.combinations" should {
    "return all N combinations" in {
      P26.combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)).distinct.size must be equalTo 20
      P26.combinations(2, List('a, 'b, 'c)) must containAllOf(List(List('a, 'b), List('b, 'c), List('a, 'c)))
    }
  }
  "Calling P27.group3" should {
    "group elements in disjoint subset" in {
      P27.group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")).head must
        be equalTo List(List("Aldo", "Beat"), List("Carla", "David", "Evi"), List("Flip", "Gary", "Hugo", "Ida"))
    }
  }
  "Calling P28.lsort" should {
    "sort lists according to length" in {
      P28.lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) must
        be equalTo List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
    }
  }
  "Calling P28.lsortFreq" should {
    "sort lists according to length frequency" in {
      P28.lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) must
        be equalTo List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
    }
  }
}