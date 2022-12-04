package aoc.y2022.day04
import paut.aoc.*
import problemutils.*, extensions.*

object Part2 extends Problem(4, 2022)(2)(4):
  def name = "Camp Cleanup - Part 2"
  def solve(data: List[String]): Int =
    parse(data)
      .count(xs => xs(0).exists(e => xs(1).contains(e)))
    