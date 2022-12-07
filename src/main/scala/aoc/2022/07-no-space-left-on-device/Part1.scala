package aoc.y2022.day07
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable

object Part1 extends Problem(7, 2022)(1)(95437):
  def name = "No Space Left On Device - Part 1"
  def solve(data: List[String]): Int =
    val dirSizes = parse(data)

    dirSizes.map((_, f) => f.values.sum).filter(i => i <= 100000).sum