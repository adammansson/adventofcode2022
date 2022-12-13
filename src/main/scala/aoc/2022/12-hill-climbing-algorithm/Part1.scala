package aoc.y2022.day12
import paut.aoc.*

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

case class Pos(row: Int, col: Int)

object Part1 extends Problem(12, 2022)(1)(31):
  def name = "Hill Climbing Algorithm - Part 1"
  def solve(data: List[String]) =
    val map = parse(data)
    val width = map(0).length
    val height = map.length

    val startRow = map.indexWhere(_.contains('S'))
    val start = Pos(startRow, map(startRow).indexOf('S'))
    val goalRow = map.indexWhere(_.contains('E'))
    val goal = Pos(goalRow, map(goalRow).indexOf('E'))

    val frontier = mutable.Queue[Pos](start)
    val cameFrom = mutable.HashMap[Pos, Pos](start -> null)

    def neighbors(pos: Pos): Vector[Pos] =
      val possible = ArrayBuffer[Pos]()

      if pos.row > 0 then
        if okDiff(map(pos.row)(pos.col), map(pos.row - 1)(pos.col)) then
          possible.addOne(Pos(pos.row - 1, pos.col))
      if pos.row < height - 1 then
        if okDiff(map(pos.row)(pos.col), map(pos.row + 1)(pos.col)) then
          possible.addOne(Pos(pos.row + 1, pos.col))
      if pos.col > 0 then
        if okDiff(map(pos.row)(pos.col), map(pos.row)(pos.col - 1)) then
          possible.addOne(Pos(pos.row, pos.col - 1))
      if pos.col < width - 1 then
        if okDiff(map(pos.row)(pos.col), map(pos.row)(pos.col + 1)) then
          possible.addOne(Pos(pos.row, pos.col + 1))

      possible.toVector

    // BFS
    var reachedEnd = false
    while frontier.nonEmpty && !reachedEnd do
      val current = frontier.dequeue
      if current == goal then
        reachedEnd = true
      else
        for next <- neighbors(current) do
          if !cameFrom.contains(next) then
            frontier.enqueue(next)
            cameFrom.addOne(next -> current)

    // RECONSTRUCT THE TAKEN PATH
    var current = goal
    val path = mutable.ArrayBuffer[Pos]()
    while current != start do
      path.addOne(current)
      current = cameFrom(current)
    path.length
