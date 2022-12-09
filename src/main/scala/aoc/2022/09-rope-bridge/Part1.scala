package aoc.y2022.day09
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable

object Part1 extends Problem(9, 2022)(1)(13):
  def name = "Rope Bridge - Part 1"
  def solve(data: List[String]): Int =
    val rope = Array.fill(2)(Pos(0, 0))
    parse(data).flatMap((s, i) => {
      (0 until i).map(_ => {
        rope(0) = rope(0).moved(s)
        rope.indices.drop(1).foreach(j => rope(j) = rope(j).followed(rope(j - 1)))
        rope.last
      })
    }).distinct.size
