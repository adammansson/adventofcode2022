package aoc.y2022.day05
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable.ListBuffer

object Part2 extends Problem(5, 2022)(2)("MCD"):
  def name = "Supply Stacks - Part 2"
  def solve(data: List[String]): String =
    val (stacks, instructions) = parse(data)

    for ins <- instructions do
      val temp = ListBuffer[Char]()
      for _ <- 0 until ins(0) do
        temp.addOne(stacks(ins(1) - 1).pop)

      for e <- temp.reverse do
        stacks(ins(2) - 1).push(e)

    stacks.map(s => s.pop).mkString("")
