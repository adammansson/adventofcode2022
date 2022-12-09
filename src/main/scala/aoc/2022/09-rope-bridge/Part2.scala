package aoc.y2022.day09
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable

object Part2 extends Problem(9, 2022)(2)(36, i = 2):
  def name = "Rope Bridge - Part 2"
  def solve(data: List[String]) =
    val xs =
      (for _ <- 0 until 10 yield
        Pos(0, 0)
        ).toArray

    val visited = mutable.Set[Pos]()

    for line <- parse(data) do
      for _ <- 0 until line(1) do
        xs(0) = xs(0).moved(line(0))

        for i <- 1 until xs.length do
          xs(i) = xs(i).followed(xs(i - 1))

        visited.add(xs.last)

    visited.size
