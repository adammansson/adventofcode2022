package aoc.y2022.day03
import paut.aoc.*
import problemutils.*, extensions.*

object Part1 extends Problem(3, 2022)(1)(157):
  def name = "Rucksack Reorganization - Part 1"

  def parse(data: List[String]): List[Vector[Set[String]]] =
    data
      .map(s => s.split("").splitAt(s.length / 2))
      .map((x, y) => Vector[Set[String]](x.toSet,y.toSet))

  def solve(data: List[String]): Int =
    parse(data).map(xs => xs(0).intersect(xs(1)).toVector).map(ys => priority(ys(0)(0))).sum
