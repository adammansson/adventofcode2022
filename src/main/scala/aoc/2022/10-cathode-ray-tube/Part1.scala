package aoc.y2022.day10
import paut.aoc.*
import problemutils.*, extensions.*

object Part1 extends Problem(10, 2022)(1)(13140):
  def name = "Cathode-Ray Tube - Part 1"
  def solve(data: List[String]): Int =
    var counter = 0
    var reg = 1
    var res = 0

    for line <- parse(data) do
      if line(0) == "addx" then
        counter += 1
        if counter == 20 || (counter - 20) % 40 == 0 then
          println(counter * reg)
          res += counter * reg
        counter += 1
        if counter == 20 || (counter - 20) % 40 == 0 then
          println(counter * reg)
          res += counter * reg
        reg += line(1).toInt
      else
        counter += 1
        if counter == 20 || (counter - 20) % 40 == 0 then
          println(counter * reg)
          res += counter * reg

    res
