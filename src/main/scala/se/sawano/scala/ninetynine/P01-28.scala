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

import util.Random

/*
 * Working with lists
 */

//Find the last element of a list
object P01 {
  def last(list: List[Any]): Any = list last
}

// Find the last but one element of a list
object P02 {
  def penultimate(list: List[Any]): Any = list takeRight (2) head
}

// Find the Kth element of a list
object P03 {
  def nth(index: Int, list: List[Any]): Any = list(index)
}

// Find the number of elements of a list
object P04 {
  def length(list: List[Any]): Int = list size
}

// Reverse a list
object P05 {
  def reverse(list: List[Any]): List[Any] = list reverse
}

// Find out whether a list is a palindrome
object P06 {
  def isPalindrome(list: List[Any]): Boolean = list == list.reverse
}

// Flatten a nested list structure
object P07 {
  def flatten(nestedList: List[Any]): List[Any] = nestedList flatMap {
    item => item match {
      case l: List[_] => flatten(l)
      case e => List(e)
    }
  }
}

// Eliminate consecutive duplicates of list elements
object P08 {
  def compress(list: List[Any]): List[Any] = {
    list match {
      case List() => List()
      case List(e, _*) => e +: compress(list dropWhile (_ == e))
    }
  }
}

// Pack consecutive duplicates of list elements into sublists
object P09 {
  def pack(list: List[Symbol]): List[List[Symbol]] = {
    if (list.isEmpty)
      Nil
    else
      (list takeWhile (_ == list.head)) :: pack(list dropWhile (_ == list.head))
  }
}

// Run-length encoding of a list
object P10 {
  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    P09.pack(list).foldLeft(List[(Int, Symbol)]()) {
      (result, symbolList) => result :+ symbolList.size -> symbolList.head
    }
  }
}

//Modified run-length encoding
object P11 {
  def encodeModified(list: List[Symbol]): List[Any] = P10.encode(list) map (e => if (e._1 == 1) e._2 else e)
}

// Decode a run-length encoded list
object P12 {
  def decode(list: List[(Int, Symbol)]): List[Symbol] = list flatMap (e => List.fill(e._1)(e._2))
}

// Run-length encoding of a list (direct solution)
object P13 {
  def encodeDirect(list: List[Symbol]): List[(Int, Symbol)] = {
    list match {
      case Nil => Nil
      case List(x, _*) => (list.takeWhile(_ == x).size, x) +: encodeDirect(list.dropWhile(_ == x))
    }
  }
}

// Duplicate the elements of a list
object P14 {
  def duplicate(list: List[Symbol]): List[Symbol] = list flatMap (symbol => List.fill(2)(symbol))
}

// Duplicate the elements of a list a given number of times
object P15 {
  def duplicateN(n: Int, list: List[Symbol]): List[Symbol] = list flatMap (symbol => List.fill(n)(symbol))
}

// Drop every Nth element from a list
object P16 {
  def drop(n: Int, list: List[Symbol]): List[Symbol] = {
    if (list == Nil)
      Nil
    else
      list.take(n - 1) ++ drop(n, list.drop(n))
  }
}

// Split a list into two parts
object P17 {
  def split(n: Int, list: List[Symbol]): (List[Symbol], List[Symbol]) = list splitAt n
}

// Extract a slice from a list
object P18 {
  def slice(i: Int, k: Int, list: List[Symbol]): List[Symbol] = list slice(i, k)
}

// Rotate a list N places to the left
object P19 {
  def rotate(n: Int, list: List[Symbol]): List[Symbol] = {
    if (n >= 0)
      list.drop(n) ++ list.take(n)
    else
      list.takeRight(-n) ++ list.dropRight(-n)
  }
}

// Remove the Kth element from a list
object P20 {
  def removeAt(k: Int, list: List[Symbol]): (List[Symbol], Symbol) = (list.take(k) ++ list.drop(k + 1), list(k))
}

// Insert an element at a given position into a list
object P21 {
  def insertAt(e: Symbol, i: Int, list: List[Symbol]): List[Symbol] = (list.take(i) :+ e) ++ list.drop(i)
}

// Create a list containing all integers within a given range
object P22 {
  def range(from: Int, upTo: Int): List[Int] = (from to upTo).toList
}

// Extract a given number of randomly selected elements from a list
object P23 {
  def randomSelect(n: Int, list: List[Symbol]): List[Symbol] = {
    if (n <= 0)
      Nil
    else {
      val e = list(Random.nextInt(list.size))
      e +: randomSelect(n - 1, list diff List(e))
    }
  }
}

// Lotto: Draw N different random numbers from the set 1..M
object P24 {
  def lotto(n: Int, m: Int): List[Int] = if (n <= 0) Nil else (Random.nextInt(n) + 1) +: lotto(n - 1, m)
}

// Generate a random permutation of the elements of a list
object P25 {
  def randomPermute(list: List[Symbol]): List[Symbol] = P23.randomSelect(list.size, list)
}

// Generate the combinations of K distinct objects chosen from the N elements of a list
object P26 {
  def combinations(n: Int, list: List[Symbol]): List[List[Symbol]] = list.combinations(n).toList
}

// Group the elements of a set into disjoint subsets
object P27 {
  def group3(list: List[String]): List[List[List[String]]] = {
    for {
      a <- list.combinations(2).toList
      noA = list diff a
      b <- noA.combinations(3)
    }
    yield List(a, b, noA diff b)
  }

  def group(groupSizes: List[Int], list: List[String]): List[List[List[String]]] = {
    // TODO implement this
    Nil
  }
}

// Sorting a list of lists according to length of sublists
object P28 {
  def lsort(lists: List[List[Symbol]]): List[List[Symbol]] = lists.sortBy(_.size)

  def lsortFreq(lists: List[List[Symbol]]): List[List[Symbol]] = {
    val sizeAndListsTuples = lists.groupBy(_.size).toList
    sizeAndListsTuples.sortWith(_._2.size < _._2.size) flatMap (_._2)
  }
}