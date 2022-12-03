package aoc.y2022.day03
import paut.aoc.*
import problemutils.*, extensions.*

object Part2 extends Problem(3, 2022)(2)(70):
  def name = "Rucksack Reorganization - Part 2"

  def parse(data: List[String]): List[List[Set[String]]] = 
    data
      .sliding(3, 3)
      .map(xs => xs.map(s => s.split("").toSet))
      .toList
    
  def solve(data: List[String]): Int =
    parse(data)
      .map(ys => ys(0).intersect(ys(1)).intersect(ys(2)).toVector(0))
      .map(s => priority(s(0)))
      .sum
