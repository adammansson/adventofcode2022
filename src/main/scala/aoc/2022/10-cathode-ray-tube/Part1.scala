package aoc.y2022.day10
import paut.aoc.*
import problemutils.*, extensions.*

object Part1 extends Problem(10, 2022)(1)(13140):
  def name = "Cathode-Ray Tube - Part 1"
  def solve(data: List[String]): Int =
    var register = 1
    parse(data).zipWithIndex.map((line, i) => (line, i + 1)).map((line, i) => {
      var result = 0
      if (i - 20) % 40 == 0 then
        result = i * register

      if line(0) == "addx" then
        register += line(1).toInt

      result
    }).sum
