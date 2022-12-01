package aoc.y2022.day01
import paut.aoc.*
import problemutils.*, extensions.*

object Part1 extends Problem(1, 2022)(1)(24000):
  def name = "Calorie Counting - Part 1"
  def solve(data: List[String]) =
  /*  
    var maxFound = 0
    var current = 0

    for line <- data do
      if line == "" then
        if current > maxFound then
          maxFound = current

        current = 0
      else
        current += line.toInt

    maxFound
  */
  
  parse(data).max
