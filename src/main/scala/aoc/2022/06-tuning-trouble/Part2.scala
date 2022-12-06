package aoc.y2022.day06
import paut.aoc.*
import problemutils.*, extensions.*

object Part2 extends Problem(6, 2022)(2)(19):
  def name = "Tuning Trouble - Part 2"
  def solve(data: List[String]): Int = parse(data).sliding(14).indexWhere(xs => xs.distinct.length == 14) + 14
