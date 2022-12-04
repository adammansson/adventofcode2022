package aoc.y2022.day04
import paut.aoc.*
import problemutils.*, extensions.*

object Part1 extends Problem(4, 2022)(1)(2):
  def name = "Camp Cleanup - Part 1"
  def solve(data: List[String]): Int =
    parse(data)
      .map(xs => xs.sortWith((x, y) => x.length <= y.length))
      .count(xs => xs(0).forall(e => xs(1).contains(e)))
    