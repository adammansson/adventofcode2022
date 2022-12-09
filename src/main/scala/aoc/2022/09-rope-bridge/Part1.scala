package aoc.y2022.day09
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable

object Part1 extends Problem(9, 2022)(1)(13):
  def name = "Rope Bridge - Part 1"
  def solve(data: List[String]): Int =
    var h = Pos(0, 0)
    var t = Pos(0, 0)
    val visited = mutable.Set[Pos]()

    for line <- parse(data) do
      for _ <- 0 until line(1) do
        h = h.moved(line(0))
        t = t.followed(h)
        visited.add(t)

    visited.size