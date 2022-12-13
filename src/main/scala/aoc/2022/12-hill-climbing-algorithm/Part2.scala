package aoc.y2022.day12
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Part2 extends Problem(12, 2022)(2)(29):
  def name = "Hill Climbing Algorithm - Part 2"
  def solve(data: List[String]) =
    val map = parse(data)
    val width = map(0).length
    val height = map.length

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

    val startRows = map.indices.filter(i => map(i).contains('a') || map(i).contains('S'))
    val starts =
      (for row <- startRows yield
        for col <- map(row).indices.filter(i => map(row)(i) == 'S' || map(row)(i) == 'a') yield
          Pos(row, col)
        ).flatten.toVector

    val goalRow = map.indexWhere(_.contains('E'))
    val goal = Pos(goalRow, map(goalRow).indexOf('E'))

    val res = mutable.ArrayBuffer[Int]()
    for start <- starts do
      val frontier = mutable.Queue[Pos](start)
      val cameFrom = mutable.HashMap[Pos, Pos](start -> null)

      // BFS
      var reachedGoal = false
      while frontier.nonEmpty && !reachedGoal do
        val current = frontier.dequeue
        if current == goal then
          reachedGoal = true
        else
          for next <- neighbors(current) do
            if !cameFrom.contains(next) then
              frontier.enqueue(next)
              cameFrom.addOne(next -> current)

      // RECONSTRUCT THE TAKEN PATH
      if cameFrom.isDefinedAt(goal) then
        var current = goal
        val path = mutable.ArrayBuffer[Pos]()
        while current != start do
          path.addOne(current)
          current = cameFrom(current)
        res.addOne(path.length)

    res.min