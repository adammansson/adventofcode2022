package aoc.y2022.day05
import problemutils.*
import extensions.*

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

def parse(data: List[String]): (List[mutable.Stack[Char]], List[Vector[Int]]) =
  val stacksEnd = data.indexWhere(s => s.startsWith(" 1"))
  val nbrStacks = data(stacksEnd).split("  ").length

  val stacks =
    (for _ <- 0 until nbrStacks yield
      mutable.Stack[Char]()
      ).toList

  for row <- (stacksEnd - 1) to 0 by -1 do
    for col <- 0 until nbrStacks do
      val i = col*4 + 1
      if data(row).length >= i then
        val crate = data(row)(i)
        if crate != ' ' then
          stacks(col).push(crate)

  val instructions =
    (for row <- stacksEnd + 2 until data.length yield
      val xs = data(row).split(" ")
      Vector[String](xs(1), xs(3), xs(5)).map(s => s.toInt)
      ).toList

  (stacks, instructions)
