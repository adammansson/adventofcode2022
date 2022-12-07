package aoc.y2022.day07
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Part2 extends Problem(7, 2022)(2)(24933642):
  def name = "No Space Left On Device - Part 2"
  def solve(data: List[String]): Int =
    val dirSizes = parse(data)
    val mustBeDeleted = 30000000 - 70000000 + dirSizes("/").values.sum

    dirSizes.map((_, f) => f.values.sum).filter(i => i >= mustBeDeleted).toVector.sorted.head
