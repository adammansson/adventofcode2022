package aoc.y2022.day14
import paut.aoc.*
import problemutils.*, extensions.*

object Part1 extends Problem(14, 2022)(1)(24):
  def name = "Regolith Reservoir - Part 1"
  def solve(data: List[String]) =
    val m = generateMap(parse(data))
    val leftMost = parse(data).flatMap(_.map(_(0))).min
    var i = 0
    while simulateSandBlock(m, leftMost) do
      // println(m.map(_.mkString("")).mkString("\n"))
      i += 1

    i
    
  def generateMap(data: Vector[Vector[(Int, Int)]]): Array[Array[Char]] =
    val leftMost = data.flatMap(_.map(_(0))).min
    val rightMost = data.flatMap(_.map(_(0))).max
    val height = data.flatMap(_.map(_(1))).max
    val xs = Array.fill(height + 7)(Array.fill(rightMost - leftMost + 12)('.'))

    for line <- data do
      for i <- line.indices.dropRight(1) do
        val c0 = line(i)
        val c1 = line(i + 1)

        if c0(0) == c1(0) then
          val x = c0(0)
          val yss = Vector(c0(1), c1(1)).sorted
          for y <- yss(0) to yss(1) do
            xs(y)(x - leftMost + 6) = '#'
        else if c0(1) == c1(1) then
          val xss = Vector(c0(0), c1(0)).sorted
          val y = c0(1)
          for x <- xss(0) to xss(1) do
            xs(y)(x - leftMost + 6) = '#'

    xs

  def simulateSandBlock(map: Array[Array[Char]], leftMost: Int): Boolean =
    var currentPos = (500, 0)

    var running = true
    var rest = false
    while running && !rest do
      if currentPos(1) == map.length - 1 then
        running = false
      else
        if map(currentPos(1) + 1)(currentPos(0) - leftMost + 6) == '.' then
          currentPos = (currentPos(0), currentPos(1) + 1)
        else if map(currentPos(1) + 1)(currentPos(0) - 1 - leftMost + 6) == '.' then
          currentPos = (currentPos(0) - 1, currentPos(1) + 1)
        else if map(currentPos(1) + 1)(currentPos(0) + 1 - leftMost + 6) == '.' then
          currentPos = (currentPos(0) + 1, currentPos(1) + 1)
        else
          map(currentPos(1))(currentPos(0) - leftMost + 6) = 'o'
          rest = true

    rest